package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.Distr;
import com.photochecker.model.common.Lka;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface LkaDao extends GenericDao<Lka> {

    List<Lka> findAllByDistrAndDates(Distr distr, LocalDate startDate, LocalDate endDate, int repTypeInd);

    List<Lka> findAllByRjkamAndDates(int rjkamId, LocalDate startDate, LocalDate endDate, int repTypeIndex);

    List<Lka> findAllNka();
}
