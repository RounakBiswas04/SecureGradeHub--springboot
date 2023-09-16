package com.ltp.gradesubmission;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Grade {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @Score
    private String score;
    private String id;

    // public Grade(String name, String subject,String score) {
    // this.name = name;
    // this.subject = subject;
    // this.score = score;

    // }

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return this.score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
