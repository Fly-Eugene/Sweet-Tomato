package com.ssafy.study_with_us.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickname;

    private Integer age;

    @Column(length = 30)
    private String group;

//    @Transient
//    private Set<Authority> authorities;
//
//    @Builder
//    public Member(Long id, String email, String password, String name, String phone, String bday, String gender) {
//        this(id, email, password, name, phone, bday, gender, true, Collections.singleton(Authority.builder().authorityName("ROLE_USER").build()));
//    }
//
//    @Builder
//    public Member(Long id, String email, String password, String name, String phone, String bday, String gender, boolean activated, Set<Authority> authorities) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.phone = phone;
//        this.bday = bday;
//        this.gender = gender;
//        this.activated = activated;
//        this.authorities = authorities;
//    }

    public Member() {
    }

    public Member(Long id, String email, String password, String name, String nickname, Integer age, String group) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }
}