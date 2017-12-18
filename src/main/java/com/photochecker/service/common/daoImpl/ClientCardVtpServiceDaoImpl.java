package com.photochecker.service.common.daoImpl;

import com.photochecker.dao.common.ClientCardVtpDao;
import com.photochecker.model.common.*;
import com.photochecker.service.common.ClientCardVtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardVtpServiceDaoImpl implements ClientCardVtpService {
    @Autowired
    ClientCardVtpDao clientCardVtpDao;

    @Override
    public List<Region> getCCVtpRegion() {

        List<Region> region = clientCardVtpDao.findlistRegion();
        return region;
    }
    @Override
    public List<Distr> getCCVtpDistr(int regionid){
        List<Distr> distr = clientCardVtpDao.findlistDistr(regionid);
        return distr;
    }
    @Override
    public List<Vtp> getCCVtp(int distrid){
        List<Vtp> vtp = clientCardVtpDao.findlistVtp(distrid);
        return vtp;
    }
    @Override
    public String getGrade(String fio){
        String grade = clientCardVtpDao.getGrade(fio);
        return grade;
    }

    @Override
    public void setAns(String type, String question, String answer, String nameauditor, String namevtp, String time, String creationTime, int vizNum, int stage) {
       Answer answer1 = new Answer(type, question,  answer,  nameauditor,  namevtp,  time,  creationTime,vizNum, stage);
        clientCardVtpDao.saveA( answer1);
    }
  /*  @Override
    public List<ClientCardVtp> getClientN(int vtpid){
        List<ClientCardVtp> clientCardVtpList = clientCardVtpDao.findlistClientN(vtpid);
        return clientCardVtpList;
    }*/
}
