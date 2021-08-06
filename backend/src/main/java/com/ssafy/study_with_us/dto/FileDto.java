package com.ssafy.study_with_us.dto;

import com.ssafy.study_with_us.domain.entity.DataRoom;
import lombok.Builder;

import java.time.LocalDateTime;

public class FileDto {
    private String sysName;
    private String orgName;
    private String path;
    private LocalDateTime regTime;
    private DataRoomDto dataRoom;

    public FileDto() {
    }

    @Builder
    public FileDto(String sysName, String orgName, String path, LocalDateTime regTime, DataRoomDto dataRoom) {
        this.sysName = sysName;
        this.orgName = orgName;
        this.path = path;
        this.regTime = regTime;
        this.dataRoom = dataRoom;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "sysName='" + sysName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", path='" + path + '\'' +
                ", regTime=" + regTime +
                ", dataRoom=" + dataRoom +
                '}';
    }
}
