package com.photochecker.dao.nka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.nka.NkaClientCriterias;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface NkaClientCriteriasDao extends GenericDao<NkaClientCriterias> {

    List<NkaClientCriterias> findAllByClientAndDates(int clientId, LocalDate startDate, LocalDate endDate);
}
