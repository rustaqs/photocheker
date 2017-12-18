package com.photochecker.dao.lkaDmp;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.lkaDmp.DmpClientCriterias;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface DmpClientCriteriasDao extends GenericDao<DmpClientCriterias> {
    List<DmpClientCriterias> findAllByClientAndDates(int clientId, LocalDate startDate, LocalDate endDate);
}
