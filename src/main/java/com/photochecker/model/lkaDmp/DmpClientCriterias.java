package com.photochecker.model.lkaDmp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DmpClientCriterias {

    private int id;
    private int clientId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private LocalDateTime saveDate;

    private int dmpNum;
    private int dmpCount;

    private boolean photoCorr;
    private boolean keyword;

    private boolean mz;
    private boolean mzRicco;
    private boolean mzRSpec;
    private boolean mzMilad;
    private boolean mzMSpec;
    private boolean k;
    private boolean s;
    private boolean sSpec;
    private boolean m;
    private boolean mSpec;

    private boolean minSize;
    private boolean tmaProd;
    private boolean price;
    private boolean fill80;
    private boolean place;

    private String comment;

    public DmpClientCriterias() {
    }

    public DmpClientCriterias(int clientId, LocalDate dateFrom, LocalDate dateTo, LocalDateTime saveDate,
                              int dmpNum, int dmpCount, boolean photoCorr, boolean keyword,
                              boolean mz, boolean mzRicco, boolean mzRSpec, boolean mzMilad, boolean mzMSpec,
                              boolean k, boolean s, boolean sSpec, boolean m, boolean mSpec,
                              boolean minSize, boolean tmaProd, boolean price, boolean fill80, boolean place, String comment) {
        this.clientId = clientId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.saveDate = saveDate;
        this.dmpNum = dmpNum;
        this.dmpCount = dmpCount;
        this.photoCorr = photoCorr;
        this.keyword = keyword;
        this.mz = mz;
        this.mzRicco = mzRicco;
        this.mzRSpec = mzRSpec;
        this.mzMilad = mzMilad;
        this.mzMSpec = mzMSpec;
        this.k = k;
        this.s = s;
        this.sSpec = sSpec;
        this.m = m;
        this.mSpec = mSpec;
        this.minSize = minSize;
        this.tmaProd = tmaProd;
        this.price = price;
        this.fill80 = fill80;
        this.place = place;
        this.comment = comment;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(LocalDateTime saveDate) {
        this.saveDate = saveDate;
    }

    public int getDmpNum() {
        return dmpNum;
    }

    public void setDmpNum(int dmpNum) {
        this.dmpNum = dmpNum;
    }

    public int getDmpCount() {
        return dmpCount;
    }

    public void setDmpCount(int dmpCount) {
        this.dmpCount = dmpCount;
    }

    public boolean isPhotoCorr() {
        return photoCorr;
    }

    public void setPhotoCorr(boolean photoCorr) {
        this.photoCorr = photoCorr;
    }

    public boolean isKeyword() {
        return keyword;
    }

    public void setKeyword(boolean keyword) {
        this.keyword = keyword;
    }

    public boolean isMz() {
        return mz;
    }

    public void setMz(boolean mz) {
        this.mz = mz;
    }

    public boolean isMzRicco() {
        return mzRicco;
    }

    public void setMzRicco(boolean mzRicco) {
        this.mzRicco = mzRicco;
    }

    public boolean isMzRSpec() {
        return mzRSpec;
    }

    public void setMzRSpec(boolean mzRSpec) {
        this.mzRSpec = mzRSpec;
    }

    public boolean isMzMilad() {
        return mzMilad;
    }

    public void setMzMilad(boolean mzMilad) {
        this.mzMilad = mzMilad;
    }

    public boolean isMzMSpec() {
        return mzMSpec;
    }

    public void setMzMSpec(boolean mzMSpec) {
        this.mzMSpec = mzMSpec;
    }

    public boolean isK() {
        return k;
    }

    public void setK(boolean k) {
        this.k = k;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public boolean issSpec() {
        return sSpec;
    }

    public void setsSpec(boolean sSpec) {
        this.sSpec = sSpec;
    }

    public boolean isM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public boolean ismSpec() {
        return mSpec;
    }

    public void setmSpec(boolean mSpec) {
        this.mSpec = mSpec;
    }

    public boolean isMinSize() {
        return minSize;
    }

    public void setMinSize(boolean minSize) {
        this.minSize = minSize;
    }

    public boolean isTmaProd() {
        return tmaProd;
    }

    public void setTmaProd(boolean tmaProd) {
        this.tmaProd = tmaProd;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isFill80() {
        return fill80;
    }

    public void setFill80(boolean fill80) {
        this.fill80 = fill80;
    }

    public boolean isPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmpClientCriterias that = (DmpClientCriterias) o;

        if (clientId != that.clientId) return false;
        if (dmpNum != that.dmpNum) return false;
        if (dmpCount != that.dmpCount) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(that.dateTo) : that.dateTo == null;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + dmpNum;
        result = 31 * result + dmpCount;
        return result;
    }

    @Override
    public String toString() {
        return "DmpClientCriterias{" +
                "clientId=" + clientId +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", saveDate=" + saveDate +
                ", dmpNum=" + dmpNum +
                ", dmpCount=" + dmpCount +
                ", photoCorr=" + photoCorr +
                ", keyword=" + keyword +
                ", mz=" + mz +
                ", mzRicco=" + mzRicco +
                ", mzRSpec=" + mzRSpec +
                ", mzMilad=" + mzMilad +
                ", mzMSpec=" + mzMSpec +
                ", k=" + k +
                ", s=" + s +
                ", sSpec=" + sSpec +
                ", m=" + m +
                ", mSpec=" + mSpec +
                ", minSize=" + minSize +
                ", tmaProd=" + tmaProd +
                ", price=" + price +
                ", fill80=" + fill80 +
                ", place=" + place +
                ", comment='" + comment + '\'' +
                '}';
    }
}
