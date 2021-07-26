package com.ssafy.study_with_us.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private Long id;

    @Column(name = "theme_name")
    private String themeName;

    public Theme() {
    }

    public Theme(Long id, String themeName) {
        this.id = id;
        this.themeName = themeName;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", themeName='" + themeName + '\'' +
                '}';
    }
}
