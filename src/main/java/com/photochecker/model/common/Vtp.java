package com.photochecker.model.common;

public class Vtp {
    int id;
    String fio;
    Distr distr;

    public Vtp(int id, String fio, Distr distr) {
        this.id = id;
        this.fio = fio;
        this.distr = distr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Distr getDistr() {
        return distr;
    }

    public void setDistr(Distr distr) {
        this.distr = distr;
    }

}
