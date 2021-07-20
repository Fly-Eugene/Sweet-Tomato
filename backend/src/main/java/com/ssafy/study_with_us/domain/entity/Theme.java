package com.ssafy.study_with_us.domain.entity;

import javax.persistence.*;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private Long id;

    @Column(name = "theme_name", length = 30, nullable = false)
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
