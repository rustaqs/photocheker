package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.mlka.Employee;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


public interface EmployeeDao extends GenericDao<Employee> {
    List<Employee> findAllByDatesAndNka(int distrId, LocalDate startDate, LocalDate endDate, int repTypeInd, int nkaId);

    List<Employee> findAllByDates(LocalDate startDate, LocalDate endDate, int repTypeInd);
}
