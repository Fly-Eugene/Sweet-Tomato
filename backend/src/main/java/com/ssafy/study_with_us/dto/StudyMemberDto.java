package com.ssafy.study_with_us.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StudyMemberDto {
    private Long id;
    private String nickname;
    private StudyDto study;
    private MemberDto member;
    private LocalDateTime recentlyConnectionTime;

    public StudyMemberDto() {
    }

    @Builder
    public StudyMemberDto(Long id, String nickname, StudyDto study, MemberDto member, LocalDateTime recentlyConnectionTime) {
        this.id = id;
        this.nickname = nickname;
        this.study = study;
        this.member = member;
        this.recentlyConnectionTime = recentlyConnectionTime;
    }

    @Override
    public String toString() {
        return "StudyMemberDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", study=" + study +
                ", member=" + member +
                ", recentlyConnectionTime=" + recentlyConnectionTime +
                '}';
    }
}
