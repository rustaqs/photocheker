package com.photochecker.dao.lkaDmp;

import com.photochecker.model.lkaDmp.DmpReportItem;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface DmpReportItemDao {
    List<DmpReportItem> findAllByDatesAndRepType(LocalDate dateFrom, LocalDate dateTo, int i);
}
