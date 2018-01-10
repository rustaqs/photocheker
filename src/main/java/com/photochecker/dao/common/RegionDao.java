package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.Region;

import java.time.LocalDate;
import java.util.List;


public interface RegionDao extends GenericDao<Region> {

    List<Region> findAllByDates(LocalDate startDate, LocalDate endDate, int repTypeInd);

    List<Region> findAllByDatesAndNka(LocalDate startDate, LocalDate endDate, int repTypeInd, int nkaId);
}
