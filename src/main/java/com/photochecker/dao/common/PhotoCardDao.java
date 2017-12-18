package com.photochecker.dao.common;

import com.photochecker.dao.GenericDao;
import com.photochecker.model.common.PhotoCard;
import com.photochecker.model.common.ReportType;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PhotoCardDao extends GenericDao<PhotoCard> {

    List<PhotoCard> findAllByRepClientDates(ReportType reportType, int clientId, LocalDate startDate, LocalDate endDate);

    PhotoCard findByUrl(String url, ReportType reportType);

    public List<PhotoCard> findAllByDates(LocalDate startDate, LocalDate endDate);

    List<PhotoCard> findAllByDatesNst(int clientId, LocalDate startDate, LocalDate endDate, int repTypeInd);

    boolean markCheckedByUrl(List<String> photoUrlList);

    List<PhotoCard> findAllByDatesAndReport(LocalDate dateFrom, LocalDate dateTo, int repTypeInd);
}
