package com.photochecker.dao.lka;

import com.photochecker.model.lka.LkaReportItem;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


public interface LkaReportItemDao {

    List<LkaReportItem> findAllByDatesAndRepType(LocalDate startDate, LocalDate endDate, int repType);
}
