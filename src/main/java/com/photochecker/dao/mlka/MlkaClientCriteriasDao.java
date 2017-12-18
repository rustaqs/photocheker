package com.photochecker.dao.mlka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.mlka.MlkaClientCriterias;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface MlkaClientCriteriasDao extends GenericDao<MlkaClientCriterias> {

    List<MlkaClientCriterias> findAllByClientAndDates(int clientId, LocalDate startDate, LocalDate endDate);
}
