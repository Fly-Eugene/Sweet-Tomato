package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.dto.DataRoomDto;
import com.ssafy.study_with_us.dto.FileReqDto;
import com.ssafy.study_with_us.service.DataRoomService;
import com.ssafy.study_with_us.util.response.ApiResult;
import com.ssafy.study_with_us.util.response.ResponseMessage;
import com.ssafy.study_with_us.util.response.StatusCode;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/dataroom")
public class DataRoomController {
    private final DataRoomService dataRoomService;

    public DataRoomController(DataRoomService dataRoomService) {
        this.dataRoomService = dataRoomService;
    }

    @PostMapping
    public Object create(FileReqDto params) throws IOException {
        return ApiResult.builder().status(StatusCode.OK).message(ResponseMessage.CREATED_DATA_ROOM).dataType("data_room")
        .data(dataRoomService.create(getDataRoomDtoAtFile(params), params.getFiles())).build();
    }

    private DataRoomDto getDataRoomDtoAtFile(FileReqDto params){
        JSONObject jObject = new JSONObject(params.getJsonData());
        return DataRoomDto.builder()
                .id(jObject.has("id") ? jObject.getLong("id") : null)
                .subject(jObject.has("subject") ? jObject.getString("subject") : null)
                .content(jObject.has("content") ? jObject.getString("content") : null)
                .studyId(jObject.has("studyId") ? jObject.getLong("studyId") : null)
                .build();
    }
}
