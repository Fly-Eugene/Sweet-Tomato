package com.ssafy.study_with_us.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDate reg_time;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    public Comment() {
    }

    @Builder
    public Comment(Long id, String content, LocalDate reg_time, Member member, Study study) {
        this.id = id;
        this.content = content;
        this.reg_time = reg_time;
        this.member = member;
        this.study = study;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", reg_time=" + reg_time +
                ", member=" + member +
                ", study=" + study +
                '}';
    }
}
