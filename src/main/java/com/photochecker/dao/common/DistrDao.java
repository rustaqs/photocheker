package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.Distr;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


public interface DistrDao extends GenericDao<Distr> {

    List<Distr> findAllByDates(LocalDate startDate, LocalDate endDate, int repTypeInd);

    List<Distr> findAllByDatesAndNka(LocalDate startDate, LocalDate endDate, int repTypeInd, int nkaId);
}
