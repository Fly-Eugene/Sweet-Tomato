package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class StudyTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_theme_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "study_id")
    private StudyDetail studyDetail;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public StudyTheme() {
    }

    public StudyTheme(Long id, StudyDetail studyDetail, Theme theme) {
        this.id = id;
        this.studyDetail = studyDetail;
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "StudyTheme{" +
                "id=" + id +
                ", study=" + studyDetail +
                ", theme=" + theme +
                '}';
    }

}
