package com.ssafy.study_with_us.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@Getter
@Entity
@Table(name = "member")
// 객체 상속이랑 many to many 충돌 나는듯
//@DiscriminatorValue("member")
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

    @Column
    private Integer age;

    @Column(length = 30)
    private String department;

    @ManyToMany
    @JoinTable(
            name = "member_authority",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Column
    private LocalDateTime studytime;

    @Builder
    public Member(Long id, String email, String password, String name, String nickname, Integer age, String group, LocalDateTime studytime) {
        this(id, email, password, name, nickname, age, group, studytime, Collections.singleton(Authority.builder().authorityName("ROLE_USER").build()));
    }

    @Builder
    public Member(Long id, String email, String password, String name, String nickname, Integer age, String department, LocalDateTime studytime, Set<Authority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.department = department;
        this.studytime = studytime;
        this.authorities = authorities;
    }
    public Member() {
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
                ", department='" + department + '\'' +
                '}';
    }
}