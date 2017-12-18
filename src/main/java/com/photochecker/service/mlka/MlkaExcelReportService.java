package com.photochecker.service.mlka;

import com.photochecker.model.common.User;
import org.apache.poi.ss.usermodel.Workbook;

import java.time.LocalDate;

/**
 * Created by market6 on 17.05.2017.
 */
public interface MlkaExcelReportService {
    public Workbook getExcelReport(Workbook workbook, LocalDate dateFrom, LocalDate dateTo, User user);
}
