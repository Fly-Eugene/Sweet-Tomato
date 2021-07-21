package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "studyroom")
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studyroom_id")
    private Long id;

    @Column(name = "room_name", nullable = false, length = 50)
    private String roomName;

    @Column(name="authority", nullable = false, length = 50)
    private String authority;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "study_id")
    private Study study;

    public StudyRoom() {
    }

    public StudyRoom(Long id, String roomName, String authority, Study study) {
        this.id = id;
        this.roomName = roomName;
        this.authority = authority;
        this.study = study;
    }

    @Override
    public String toString() {
        return "StudyRoom{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", authority='" + authority + '\'' +
                ", study=" + study +
                '}';
    }
}
