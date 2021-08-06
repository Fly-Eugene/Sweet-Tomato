package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.dto.DataRoomDto;
import com.ssafy.study_with_us.dto.FileReqDto;
import com.ssafy.study_with_us.service.DataRoomService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dataroom")
public class DataRoomController {
    private final DataRoomService dataRoomService;

    public DataRoomController(DataRoomService dataRoomService) {
        this.dataRoomService = dataRoomService;
    }

    @PostMapping
    public Object create(FileReqDto params){
        getDataRoomDtoAtFile(params);
        return null;
    }

    private DataRoomDto getDataRoomDtoAtFile(FileReqDto params){
        for (MultipartFile file : params.getFiles()) {
            System.out.println("file = " + file);
        }
        JSONObject jObject = new JSONObject(params.getJsonData());
        System.out.println("jObject = " + jObject);
        return null;
    }
}
