package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.domain.entity.Profile;
import com.ssafy.study_with_us.domain.entity.StudyProfileService;
import com.ssafy.study_with_us.dto.FileDto;
import com.ssafy.study_with_us.dto.ProfileDto;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private StudyProfileService studyProfileService;

    public ProfileController(StudyProfileService studyProfileService) {
        this.studyProfileService = studyProfileService;
    }

    
    // 받는거 예시
    @PostMapping
    public Object fileReqTest(FileDto fileDto){
        // file 있을시 처리
        if (fileDto.getFiles() != null) {
            MultipartFile mf = fileDto.getFiles().get(0);
        }
        // data 처리
        JSONObject jObject = new JSONObject(fileDto.getJsonData());
        // jObject 가지고 멤버냐, 스터디냐에 따라서 처리해줌
        System.out.println("fileDto = " + fileDto);
        System.out.println("jObject.get(\"image\") = " + jObject.get("image"));
        return null;
//        return studyProfileService.create(params);
    }

}
