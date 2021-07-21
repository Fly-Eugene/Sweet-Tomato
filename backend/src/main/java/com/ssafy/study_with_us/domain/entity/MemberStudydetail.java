package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "member_studydetail")
public class MemberStudydetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_study_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "studydetail_id")
    private StudyDetail studyDetail;

    private Integer tomato;
    private Integer like;

    public MemberStudydetail() {
    }

    public MemberStudydetail(Long id, Member member, StudyDetail studyDetail, Integer tomato, Integer like) {
        this.id = id;
        this.member = member;
        this.studyDetail = studyDetail;
        this.tomato = tomato;
        this.like = like;
    }

    @Override
    public String toString() {
        return "MemberStudy{" +
                "id=" + id +
                ", member=" + member +
                ", study=" + studyDetail +
                ", tomato=" + tomato +
                ", like=" + like +
                '}';
    }
}
