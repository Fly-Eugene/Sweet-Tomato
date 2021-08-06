package com.ssafy.study_with_us.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public abstract class FileDto {
    private String sysName;
    private String orgName;
    private String path;
    private LocalDateTime regTime;

    public FileDto() {
    }

    public FileDto(String sysName, String orgName, String path, LocalDateTime regTime) {
        this.sysName = sysName;
        this.orgName = orgName;
        this.path = path;
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "sysName='" + sysName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", path='" + path + '\'' +
                ", regTime=" + regTime +
                '}';
    }
}
