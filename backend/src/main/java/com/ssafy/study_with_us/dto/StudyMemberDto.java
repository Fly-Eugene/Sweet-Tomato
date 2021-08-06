package com.ssafy.study_with_us.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StudyMemberDto {
    private Long id;
    private Long studyId;
    private Long memberId;
    private LocalDateTime recentlyConnectionTime;

    public StudyMemberDto() {
    }

    @Builder
    public StudyMemberDto(Long id, Long studyId, Long memberId, LocalDateTime recentlyConnectionTime) {
        this.id = id;
        this.studyId = studyId;
        this.memberId = memberId;
        this.recentlyConnectionTime = recentlyConnectionTime;
    }

    @Override
    public String toString() {
        return "StudyMemberDto{" +
                "id=" + id +
                ", studyId=" + studyId +
                ", memberId=" + memberId +
                ", recentlyConnectionTime=" + recentlyConnectionTime +
                '}';
    }
}
