package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.domain.entity.Profile;
import com.ssafy.study_with_us.dto.*;
import com.ssafy.study_with_us.service.ProfileService;
import com.ssafy.study_with_us.service.StudyService;
import com.ssafy.study_with_us.util.response.ApiResult;
import com.ssafy.study_with_us.util.response.ResponseMessage;
import com.ssafy.study_with_us.util.response.StatusCode;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/study")
public class StudyController {
    private final StudyService studyService;
    private final ProfileService profileService;

    public StudyController(StudyService studyService, ProfileService profileService) {
        this.studyService = studyService;
        this.profileService = profileService;
    }

    // 멤버가 직접 가입 하는거
    @PostMapping("/join")
    public Object join(@RequestBody IdReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY_MEMBER).dataType("study_member_ref").data(studyService.joinMember(params)).build();
    }
    @PostMapping("/invite")
    public Object inviteMember(@RequestBody IdReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY_MEMBER).dataType("study_member_ref").data(studyService.joinMember(params)).build();
    }
    @DeleteMapping("/withdraw")
    public Object withdraw(@RequestBody IdReqDto params){
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.DELETED_STUDY_MEMBER).dataType("Long").data(studyService.withdraw(params)).build();
    }
    @PostMapping
    public Object create(FileReqDto params) throws IOException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_STUDY).dataType("study")
                .data(studyService.create(getStudyDtoAtFile(params))).build();
    }

    @PatchMapping
    public Object update(FileReqDto params) throws IOException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.UPDATED_STUDY)
                .data(studyService.update(getStudyDtoAtFile(params))).build();
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

//  image파일 아니면 에러 처리 해줘야함
    private StudyDto getStudyDtoAtFile(FileReqDto params) throws IOException {
        // 파일 정보 있으면 받은 정보로 생성
        Profile profile = profileService.studyProfileCreate(params.getFiles().get(0));
        // study
        JSONObject jObject = new JSONObject(params.getJsonData());
        Set<String> themes = new HashSet<>();
        //themes
        if (jObject.has("themes")){
            for (Object theme : jObject.getJSONArray("themes")) {
                themes.add((String) theme);
            }
        };
        return StudyDto.builder()
                .id(jObject.has("id") ? jObject.getLong("id") : null)
                .studyName(jObject.has("studyName") ? jObject.getString("studyName") : null)
                .studyIntro(jObject.has("studyIntro") ? jObject.getString("studyIntro") : null)
                .security(jObject.has("security") ? jObject.getString("security") : null)
                .themes(themes)
                .profile(profile == null ? null : profile.entityToDto())
                .build();
    }
}
