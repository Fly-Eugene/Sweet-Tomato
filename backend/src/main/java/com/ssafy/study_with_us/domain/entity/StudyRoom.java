package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "studyroom")
public class Studyroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studyroom_id")
    private Long id;

    @Column(name = "room_name", nullable = false, length = 50)
    private String roomName;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "study_id")
    private StudyDetail studyDetail;

    public Studyroom() {
    }

    public Studyroom(Long id, String roomName, StudyDetail studyDetail) {
        this.id = id;
        this.roomName = roomName;
        this.studyDetail = studyDetail;
    }

    @Override
    public String toString() {
        return "StudyRoom{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", studyDetail=" + studyDetail +
                '}';
    }
}
