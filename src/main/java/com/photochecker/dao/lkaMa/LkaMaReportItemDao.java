package com.photochecker.dao.lkaMa;

import com.photochecker.model.lkaMa.LkaMaReportItem;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface LkaMaReportItemDao {

    List<LkaMaReportItem> findAllByDatesAndRepType(LocalDate startDate, LocalDate endDate, int repType);
}
