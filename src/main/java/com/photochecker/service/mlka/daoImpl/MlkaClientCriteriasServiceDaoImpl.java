package com.photochecker.service.mlka.daoImpl;

import com.photochecker.dao.mlka.MlkaClientCriteriasDao;
import com.photochecker.model.mlka.MlkaClientCriterias;
import com.photochecker.service.mlka.MlkaClientCriteriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MlkaClientCriteriasServiceDaoImpl implements MlkaClientCriteriasService {

    @Autowired
    private MlkaClientCriteriasDao mlkaClientCriteriasDao;

    @Override
    public boolean saveCriterias(MlkaClientCriterias clientCriterias) {
        boolean succeed;
        int id = -1;
        List<MlkaClientCriterias> savedClientCriterias = mlkaClientCriteriasDao.findAllByClientAndDates(clientCriterias.getClientId(),
                clientCriterias.getDateFrom(), clientCriterias.getDateTo());

        if (null != savedClientCriterias && savedClientCriterias.size() > 0) {
            succeed = mlkaClientCriteriasDao.update(clientCriterias);
        } else {
            id = mlkaClientCriteriasDao.save(clientCriterias);
            succeed = true;
        }

        return succeed;
    }

    @Override
    public MlkaClientCriterias getSavedCriterias(int clientId, LocalDate dateFrom, LocalDate dateTo) {
        MlkaClientCriterias clientCriterias = mlkaClientCriteriasDao.findAllByClientAndDates(clientId, dateFrom, dateTo).get(0);
        return clientCriterias;
    }
}
