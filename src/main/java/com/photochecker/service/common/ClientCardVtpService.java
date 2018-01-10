package com.photochecker.service.common;

import com.photochecker.model.common.Distr;
import com.photochecker.model.common.Region;
import com.photochecker.model.common.Tema;
import com.photochecker.model.common.Vtp;

import java.util.List;

/**
 * Created by market6 on 17.05.2017.
 */
public interface ClientCardVtpService {

    public List<Region> getCCVtpRegion();
    public List<Distr> getCCVtpDistr(int regionid);
    public List<Vtp> getCCVtp(int distrid);
    public String getGrade(String fio);
    public void setAns(String type, String question, String answer, String nameauditor, String namevtp, String time, String creationTime, int vizNum, int stage, String tema);
    public List<Tema> getTema(String fio);
}
