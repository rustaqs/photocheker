package com.photochecker.dao.mlka;

import com.photochecker.model.mlka.MlkaReportItem;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface MlkaReportItemDao {

    List<MlkaReportItem> findAllByDatesAndRepType(LocalDate startDate, LocalDate endDate, int repType);
}
