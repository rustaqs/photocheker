package com.photochecker.dao.lka;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.lka.ClientCriterias;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


public interface ClientCriteriasDao extends GenericDao<ClientCriterias> {

    List<ClientCriterias> findAllByClientAndDates(int clientId, LocalDate startDate, LocalDate endDate);
}
