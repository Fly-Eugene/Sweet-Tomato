package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "connectionhistory")
public class Connectionhistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connectionhistory_id")
    private Long id;

    @Column(name = "last_time")
    LocalDate lastTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "studyroom_id")
    private Studyroom studyRoom;

    public Connectionhistory() {
    }

    public Connectionhistory(Long id, LocalDate lastTime, Studyroom studyRoom) {
        this.id = id;
        this.lastTime = lastTime;
        this.studyRoom = studyRoom;
    }

    @Override
    public String toString() {
        return "ConnectionHistory{" +
                "id=" + id +
                ", lastTime=" + lastTime +
                ", studyRoom=" + studyRoom +
                '}';
    }
}
