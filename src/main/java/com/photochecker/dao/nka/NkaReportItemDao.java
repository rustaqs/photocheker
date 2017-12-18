package com.photochecker.dao.nka;

import com.photochecker.model.nka.NkaReportItem;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface NkaReportItemDao {
    List<NkaReportItem> findAllByDatesAndRepType(LocalDate dateFrom, LocalDate dateTo, int employeeId, int reportType);
}
