package com.ssafy.study_with_us.domain.entity;


import javax.persistence.*;

@Entity
@Table(name = "studydetail")
public class StudyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studydetail_id")
    private Long id;

    @Column(name = "study_name", length = 30, nullable = false)
    private String studyName;

    @Column(name = "study_leader")
    private String studyLeader;
    @Column(name = "authority")
    private String authority;

    public StudyDetail() {
    }

    public StudyDetail(Long id, String studyName, String studyLeader, String authority) {
        this.id = id;
        this.studyName = studyName;
        this.studyLeader = studyLeader;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "StudyDetail{" +
                "id=" + id +
                ", studyName='" + studyName + '\'' +
                ", studyLeader='" + studyLeader + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
