package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.dto.FileReqDto;
import com.ssafy.study_with_us.dto.IdReqDto;
import com.ssafy.study_with_us.dto.ScheduleDto;
import com.ssafy.study_with_us.dto.ThemesReqDto;
import com.ssafy.study_with_us.error.ErrorResponse;
import com.ssafy.study_with_us.error.exception.ErrorCode;
import com.ssafy.study_with_us.response.ApiResult;
import com.ssafy.study_with_us.response.ResponseMessage;
import com.ssafy.study_with_us.response.StatusCode;
import com.ssafy.study_with_us.service.StudyService;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.tasks.UnsupportedFormatException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@Slf4j
@RequestMapping("/study")
public class StudyController {
    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    // 멤버가 직접 가입 하는거
    @PostMapping("/join")
    public Object join(@RequestBody IdReqDto params) throws AuthenticationException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY_MEMBER).dataType("study_member_ref").data(studyService.joinMember(params)).build();
    }
    @PostMapping("/invite")
    public Object inviteMember(@RequestBody IdReqDto params) throws AuthenticationException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY_MEMBER).dataType("study_member_ref").data(studyService.joinMember(params)).build();
    }
    @DeleteMapping("/withdraw")
    public Object withdraw(@RequestBody IdReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.DELETED_STUDY_MEMBER).dataType("Long").data(studyService.withdraw(params)).build();
    }
    @PostMapping
    public Object create(FileReqDto params) throws IOException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY).dataType("study")
                .data(studyService.create(params)).build();
    }

    @PatchMapping
    public Object update(FileReqDto params) throws IOException, AuthenticationException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.UPDATED_STUDY)
                .data(studyService.update(params)).build();
    }

    @GetMapping("/detail")
    public Object getDetail(@RequestParam Long studyId){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.SEARCHED_STUDY_DETAIL).dataType("study").data(studyService.getDetail(studyId)).build();
    }
    @GetMapping("/{page}")
    public Object getStudyList(@PathVariable("page") Integer page){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.SEARCHED_STUDY_LIST).dataType("studies").data(studyService.getStudyList(page)).build();
    }

    @PostMapping("/search")
    public Object searchStudyByThemes(@RequestBody ThemesReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.SEARCHED_STUDY_THEMES).dataType("themes")
                .data(studyService.searchStudyByThemes(params.getThemes(), params.getPage())).build();
    }

    @PostMapping("/connection")
    public Object connection(@RequestBody IdReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CONNECTED_STUDY).dataType("study_member").data(studyService.connectStudy(params.getStudyId())).build();
    }

    @GetMapping("/recently")
    public Object getRecentlyStudies(){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.SEARCHED_RECENTLY_STUDIES).dataType("study").data(studyService.getRecentlyStudies()).build();
    }

    @GetMapping("/schedule/{yearMonth}")
    public Object getSchedules(@PathVariable("yearMonth") String yearMonth,
                                  @RequestParam Long studyId){
        LocalDate startDate = LocalDate.parse(yearMonth+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.SEARCHED_SCHEDULE).dataType("schedules").data(studyService.getSchedules(studyId, startDate)).build();
    }
    @PostMapping("/schedule")
    public Object createSchedule(@RequestBody ScheduleDto params){
        System.out.println("params = " + params);
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_SCHEDULE).dataType("schedule").data(studyService.saveSchedule(params)).build();
    }
    @PatchMapping("/schedule")
    public Object updateSchedule(@RequestBody ScheduleDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.UPDATED_SCHEDULE).dataType("schedule").data(studyService.saveSchedule(params)).build();
    }
    @DeleteMapping("/schedule/{scheduleId}")
    public Object deleteSchedule(@PathVariable("scheduleId") Long scheduleId){
        studyService.deleteSchedule(scheduleId);
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.DELETED_SCHEDULE).build();
    }

    @ExceptionHandler(UnsupportedFormatException.class)
    protected ResponseEntity<ErrorResponse> handleUnsupportedFormatException(Exception e) {
        log.error("이미지 형식 에러", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.FILE_FORMAT_ERROR);
        return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<ErrorResponse> handleAuthenticationException(Exception e) {
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BLACKLIST_ACCESS_DENIED);
        log.error("해당 권한은 스터디장만 가능합니다.", e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
