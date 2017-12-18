package com.photochecker.controllers.nka;

import com.photochecker.service.nka.NkaExcelReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;


@Controller
public class NkaExcelReportController {

    @Autowired
    private NkaExcelReportService nkaExcelReportService;

    /**
	 *
	 * @param request
	 * @param response
	 */
	@GetMapping("/reports/nka/getExcelReport")
    public void getExcelReport (HttpServletRequest request,
                                        HttpServletResponse response) {

        LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom"));
        LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo"));

        response.setContentType("application/vnd.ms-excel.sheet.macroEnabled.12");
        response.setHeader("Content-disposition",
                "attachment; filename=rjkam_" + dateFrom + "_" + dateTo + ".xlsm");

        try {
            OutputStream out = response.getOutputStream();
            nkaExcelReportService.getExcelReportItems(out, dateFrom, dateTo);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
