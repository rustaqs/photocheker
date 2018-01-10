package com.photochecker.model.common;
import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String question;
    private String answer;
    private String nameauditor;
    private String namevtp;
    private String time;
    private String creationTime;
    private int vizNum;
    private int stage;
    private String tema;

    public Answer() {
    }

    public Answer(String type, String question, String answer, String nameauditor, String namevtp, String time, String creationTime, int vizNum, int stage, String tema) {
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.nameauditor = nameauditor;
        this.namevtp = namevtp;
        this.time = time;
        this.creationTime = creationTime;
        this.vizNum = vizNum;
        this.stage = stage;
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNameauditor() {
        return nameauditor;
    }

    public void setNameauditor(String nameauditor) {
        this.nameauditor = nameauditor;
    }

    public String getNamevtp() {
        return namevtp;
    }

    public void setNamevtp(String namevtp) {
        this.namevtp = namevtp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getVizNum() {
        return vizNum;
    }

    public void setVizNum(int vizNum) {
        this.vizNum = vizNum;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
