package com.photochecker.service.nst;

import com.photochecker.model.common.User;

import java.io.OutputStream;
import java.time.LocalDate;

/**
 * Created by market6 on 17.05.2017.
 */
public interface NstExcelReportService {

    void getExcelReportItems(OutputStream out, LocalDate dateFrom, LocalDate dateTo, User user);
}
