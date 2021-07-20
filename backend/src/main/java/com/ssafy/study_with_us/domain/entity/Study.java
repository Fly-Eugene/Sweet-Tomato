package com.ssafy.study_with_us.domain.entity;


import javax.persistence.*;

@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long id;

    @Column(name = "study_name", length = 30, nullable = false)
    private String studyName;

    public Study() {
    }
    public Study(Long id, String studyName) {
        this.id = id;
        this.studyName = studyName;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", studyName='" + studyName + '\'' +
                '}';
    }
}
