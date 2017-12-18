package com.photochecker.service.nka;

import java.io.OutputStream;
import java.time.LocalDate;

/**
 * Created by market6 on 17.05.2017.
 */
public interface NkaExcelReportService {
    public void getExcelReportItems(OutputStream out, LocalDate dateFrom, LocalDate dateTo);
}
