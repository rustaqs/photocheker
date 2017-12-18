package com.photochecker.model.common;

import java.util.Date;

public class Grade {
    private Date date;
    private String stage;
    private double grade;

    public Grade(Date date, String stage, double grade) {
        this.date = date;
        this.stage = stage;
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
