package com.ssafy.study_with_us.domain.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@DiscriminatorValue("study")
public class Study extends Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long id;

    @Column(name = "study_name")
    private String studyName;
    @Column(name = "study_intro", columnDefinition = "TEXT")
    private String studyIntro;
    @Column(name = "study_leader")
    private Long studyLeader;
    @Column(name = "security")
    private String security;

    public Study() {
    }
    @Builder
    public Study(Long id, String studyName, String studyIntro, Long studyLeader, String security) {
        this.id = id;
        this.studyName = studyName;
        this.studyIntro = studyIntro;
        this.studyLeader = studyLeader;
        this.security = security;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", studyName='" + studyName + '\'' +
                ", studyIntro='" + studyIntro + '\'' +
                ", studyLeader=" + studyLeader +
                ", security='" + security + '\'' +
                '}';
    }
}
