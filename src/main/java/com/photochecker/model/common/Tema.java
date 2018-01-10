package com.photochecker.model.common;

public class Tema {
    String tema;
    int vizNum;
    String date;

    public Tema( String tema, int vizNum, String date) {
        this.tema = tema;
        this.vizNum = vizNum;
        this.date = date;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getVizNum() {
        return vizNum;
    }

    public void setVizNum(int vizNum) {
        this.vizNum = vizNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
