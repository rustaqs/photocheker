package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.Channel;
import com.photochecker.model.common.Distr;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


public interface ChannelDao extends GenericDao<Channel> {
    List<Channel> findAllByDistrAndDates(Distr distr, LocalDate dateFrom, LocalDate dateTo, int repTypeInd);
}
