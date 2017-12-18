package com.photochecker.dao.mlka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.mlka.NkaType;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface NkaTypeDao extends GenericDao<NkaType> {

    List<NkaType> findAllByDates(LocalDate startDate, LocalDate endDate, int repTypeInd);
}
