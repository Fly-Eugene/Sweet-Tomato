package com.ssafy.study_with_us.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "data_room")
public class DataRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_room_id")
    private Long id;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @OneToMany(mappedBy = "dataRoom")
    private List<File> files;

    public DataRoom() {
    }

    @Builder
    public DataRoom(Long id, String subject, String content, Member member, Study study, List<File> files) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.member = member;
        this.study = study;
        this.files = files;
    }
}
