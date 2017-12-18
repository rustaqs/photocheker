package com.photochecker.model.nka;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class NkaRjkamReportItem {

    private int id;
    private String name;
    private List<NkaReportItem> reportItemList;

    public NkaRjkamReportItem() {
    }

    public NkaRjkamReportItem(int id, String name, List<NkaReportItem> reportItemList) {
        this.id = id;
        this.name = name;
        this.reportItemList = reportItemList;
    }

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

    public List<NkaReportItem> getReportItemList() {
        return reportItemList;
    }

    public void setReportItemList(List<NkaReportItem> reportItemList) {
        this.reportItemList = reportItemList;
    }
}
