package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.domain.entity.StudyProfile;
import com.ssafy.study_with_us.dto.FileDto;
import com.ssafy.study_with_us.dto.StudyDto;
import com.ssafy.study_with_us.service.ProfileService;
import com.ssafy.study_with_us.service.StudyService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/study")
public class StudyController {
    private StudyService studyService;
    private ProfileService profileService;

    public StudyController(StudyService studyService, ProfileService profileService) {
        this.studyService = studyService;
        this.profileService = profileService;
    }

    @PostMapping
    public Object create(FileDto params) throws IOException {
        // 파일 정보 있으면 받은 정보로 생성
        if (params.getFiles() != null) {
            profileService.studyProfileCreate(params.getFiles().get(0));
        // 없으면 기본 값으로 생성
        } else {

        }


        // study
//        JSONObject jObject = new JSONObject(params.getJsonData());
//        StudyDto studyDto = StudyDto.builder()
//                .id(jObject.getLong("id"))
//                .studyName(jObject.getString("studyName"))
//                .studyIntro(jObject.getString("studyIntro"))
//                .security(jObject.getString("security"))
//                .profile()


//        @RequestBody StudyDto params
//      create 호출하는 사람, 즉 만드는 사람이 leader
//        Map<String, Object> map = new HashMap<>();
//        map.put("result", studyService.create(params));
//        return map;
        return null;
    }

    @PatchMapping
    public Object update(@RequestBody StudyDto params){
        return studyService.update(params);
    }

    @GetMapping
    public Object read(@RequestParam Long id){
        return studyService.read(id);
    }
}
