package com.ssafy.study_with_us.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_room_id")
    private Long id;

    @Column(name = "sys_name")
    private String sysName;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "path")
    private String path;

    @Column(name = "reg_time")
    private LocalDateTime regTime;

    @ManyToOne
    @JoinColumn(name = "data_room_id")
    private DataRoom dataRoom;

    public File() {
    }

    @Builder
    public File(Long id, String sysName, String orgName, String path, LocalDateTime regTime, DataRoom dataRoom) {
        this.id = id;
        this.sysName = sysName;
        this.orgName = orgName;
        this.path = path;
        this.regTime = regTime;
        this.dataRoom = dataRoom;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", sysName='" + sysName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", path='" + path + '\'' +
                ", regTime=" + regTime +
                ", dataRoom=" + dataRoom +
                '}';
    }
}
