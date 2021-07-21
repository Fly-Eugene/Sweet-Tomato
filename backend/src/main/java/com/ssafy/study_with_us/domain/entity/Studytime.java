package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studytime")
public class Studytime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studytime_id")
    private Long id;

    @Column(name = "study_time")
    LocalDate studyTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Studytime() {
    }

    public Studytime(Long id, LocalDate studyTime, Member member) {
        this.id = id;
        this.studyTime = studyTime;
        this.member = member;
    }

    @Override
    public String toString() {
        return "StudyTime{" +
                "id=" + id +
                ", studyTime=" + studyTime +
                ", member=" + member +
                '}';
    }
}
