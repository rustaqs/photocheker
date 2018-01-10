package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.*;

import java.util.List;


public interface ClientCardVtpDao extends GenericDao<ClientCardVtp> {

    void remove();
    public List<Region> findlistRegion();
    public List<Distr> findlistDistr(int regionid);
    public List<Vtp> findlistVtp(int distrid);
    public String getGrade(String fio);
    public void saveA(Answer answer1);
    public List<Tema> getTema(String fio);
}
