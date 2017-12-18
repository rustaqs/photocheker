package com.photochecker.model.common;

import javax.persistence.*;

@Entity
@Table(name = "client_card_vtp")
public class ClientCardVtp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int region_id;
    private String region;
    private String city;
    private String distr;
    private String client_name;
    private int client_id;
    private String client_address;
    private String fio;
    private String kanal;
    private String type;
    private int dist_id;
    private String job;
    private String sector_name;
    private int sector_id;

    public ClientCardVtp(int region_id, String region, String city, String distr, String client_name, int client_id, String client_address, String fio, String kanal, String type, int dist_id, String job, String sector_name, int sector_id) {
        this.region_id = region_id;
        this.region = region;
        this.city = city;
        this.distr = distr;
        this.client_name = client_name;
        this.client_id = client_id;
        this.client_address = client_address;
        this.fio = fio;
        this.kanal = kanal;
        this.type = type;
        this.dist_id = dist_id;
        this.job = job;
        this.sector_name = sector_name;
        this.sector_id = sector_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistr() {
        return distr;
    }

    public void setDistr(String distr) {
        this.distr = distr;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getKanal() {
        return kanal;
    }

    public void setKanal(String kanal) {
        this.kanal = kanal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDist_id() {
        return dist_id;
    }

    public void setDist_id(int dist_id) {
        this.dist_id = dist_id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSector_name() {
        return sector_name;
    }

    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }

    @Override
    public String toString() {
        return "ClientCardVtp{" +
                "id=" + id +
                ", region_id=" + region_id +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", distr='" + distr + '\'' +
                ", client_name='" + client_name + '\'' +
                ", client_id=" + client_id +
                ", client_address='" + client_address + '\'' +
                ", fio='" + fio + '\'' +
                ", kanal='" + kanal + '\'' +
                ", type='" + type + '\'' +
                ", dist_id=" + dist_id +
                ", job='" + job + '\'' +
                ", sector_name='" + sector_name + '\'' +
                ", sector_id=" + sector_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCardVtp that = (ClientCardVtp) o;
        return client_id == that.client_id;
    }
}

