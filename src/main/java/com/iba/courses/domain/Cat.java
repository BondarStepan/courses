package com.iba.courses.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    @NotNull
    private String name;
    @Column(name="login")
    @NotNull
    private String login;
    @Column(name="university")
    @NotNull
    private String university;
    @Column(name="course")
    @NotNull
    private int course;
    @Column(name="password")
    @NotNull
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cat() {
    }
    public Cat(@NotNull String name, @NotNull String login, @NotNull String university, @NotNull int course, @NotNull String password) {
        this.name = name;
        this.login = login;
        this.university = university;
        this.course = course;
        this.password = password;
    }



    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", university='" + university + '\'' +
                ", course=" + course +
                ", password='" + password + '\'' +
                '}';
    }
}
