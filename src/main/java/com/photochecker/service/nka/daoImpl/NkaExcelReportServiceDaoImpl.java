package com.photochecker.service.nka.daoImpl;

import com.photochecker.dao.common.EmployeeDao;
import com.photochecker.dao.nka.NkaReportItemDao;
import com.photochecker.model.mlka.Employee;
import com.photochecker.model.nka.NkaReportItem;
import com.photochecker.model.nka.NkaRjkamReportItem;
import com.photochecker.service.nka.NkaExcelReportService;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NkaExcelReportServiceDaoImpl implements NkaExcelReportService {

    @Autowired
    private NkaReportItemDao nkaReportItemDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    ServletContext servletContext;

    @Override
    public void getExcelReportItems(OutputStream out, LocalDate dateFrom, LocalDate dateTo) {
        List<Employee> employeeList = employeeDao.findAllByDates(dateFrom, dateTo, 3);
        List<String> employeeNames = employeeList.stream()
                .map(employee -> employee.getName().substring(0, employee.getName().indexOf(" ") + 2))
                .collect(Collectors.toList());

        List<NkaRjkamReportItem> nkaRjkamReportItemList = new ArrayList<>();

        for (Employee employee : employeeList) {
            List<NkaReportItem> nkaReportItems = nkaReportItemDao.findAllByDatesAndRepType(dateFrom, dateTo, employee.getId(), 3);
            nkaRjkamReportItemList.add(new NkaRjkamReportItem(employee.getId(), employee.getName(), nkaReportItems));
        }

        File file = new File(servletContext.getRealPath("/resources/excelTemplates/rjkam_template.xlsm"));

        try (InputStream is = new FileInputStream(file)) {
            Context context = PoiTransformer.createInitialContext();
            context.putVar("rjkamReportItemList", nkaRjkamReportItemList);
            context.putVar("sheetNames", employeeNames);
            JxlsHelper.getInstance().processTemplate(is, out, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
