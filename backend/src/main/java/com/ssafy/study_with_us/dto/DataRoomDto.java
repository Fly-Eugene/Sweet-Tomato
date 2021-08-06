package com.ssafy.study_with_us.dto;

import lombok.Builder;

import java.util.List;

public class DataRoomDto{
    private Long id;
    private String subject;
    private String content;
    private MemberDto member;
    private StudyDto study;
    private List<FileDto> files;

    public DataRoomDto() {
    }

    @Builder
    public DataRoomDto(Long id, String subject, String content, MemberDto member, StudyDto study, List<FileDto> files) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.member = member;
        this.study = study;
        this.files = files;
    }

    @Override
    public String toString() {
        return "DataRoomDto{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", member=" + member +
                ", study=" + study +
                ", files=" + files +
                '}';
    }
}
