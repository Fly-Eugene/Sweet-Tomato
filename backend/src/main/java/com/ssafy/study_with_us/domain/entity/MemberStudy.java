package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "member_study")
public class MemberStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_study_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "study_id")
    private Study study;

    private Integer tomato;
    private Integer like;

    public MemberStudy() {
    }

    public MemberStudy(Long id, Member member, Study study, Integer tomato, Integer like) {
        this.id = id;
        this.member = member;
        this.study = study;
        this.tomato = tomato;
        this.like = like;
    }

    @Override
    public String toString() {
        return "MemberStudy{" +
                "id=" + id +
                ", member=" + member +
                ", study=" + study +
                ", tomato=" + tomato +
                ", like=" + like +
                '}';
    }
}
