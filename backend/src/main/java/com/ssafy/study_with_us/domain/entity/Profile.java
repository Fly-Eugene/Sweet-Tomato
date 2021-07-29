package com.ssafy.study_with_us.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    private String image;
    private String thumbnail;
    private String path;

    public Profile() {
    }

    public Profile(Long id, String image, String thumbnail, String path) {
        this.id = id;
        this.image = image;
        this.thumbnail = thumbnail;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
