package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;
    private LocalDate reg_time;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "studydetail_id")
    private StudyDetail studyDetail;

    public Comment() {
    }

    public Comment(Long id, String content, LocalDate reg_time, Member member, StudyDetail studyDetail) {
        this.id = id;
        this.content = content;
        this.reg_time = reg_time;
        this.member = member;
        this.studyDetail = studyDetail;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", reg_time=" + reg_time +
                ", member=" + member +
                ", studyDetail=" + studyDetail +
                '}';
    }
}
