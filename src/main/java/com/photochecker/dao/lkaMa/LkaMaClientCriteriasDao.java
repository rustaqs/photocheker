package com.photochecker.dao.lkaMa;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.lkaMa.LkaMaClientCriterias;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface LkaMaClientCriteriasDao extends GenericDao<LkaMaClientCriterias> {

    List<LkaMaClientCriterias> findAllByClientAndDates(int clientId, LocalDate startDate, LocalDate endDate);
}
