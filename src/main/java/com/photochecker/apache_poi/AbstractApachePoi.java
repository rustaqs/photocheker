package com.photochecker.apache_poi;

import com.photochecker.model.common.TMAActivity;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.util.HashMap;

/**
 * Created by market6 on 13.01.2017.
 */
public abstract class AbstractApachePoi implements ApachePoi {
    XSSFWorkbook workbook;
    XSSFSheet spreadsheet;
    String reportPath;
    String dateFrom;
    String dateTo;
    int rowIndex = 4;
    int nkaRowIndex = 0;
    int nkaSumStartRow;
    int nkaSumEndRow;

    HashMap<String, Integer> downLimitMap = new HashMap<>();
    HashMap<TMAActivity, Integer> activityMap = null;

    XSSFCellStyle titleStyle;
    XSSFCellStyle headerStyle;
    XSSFCellStyle headerStyle1;
    XSSFCellStyle headerStyle2;
    XSSFCellStyle headerStyle3;
    XSSFCellStyle headerStyleM;
    XSSFCellStyle headerStyle4;

    XSSFColor lightRed;
    XSSFColor lightGreen;
    XSSFColor lightBlue;
    XSSFColor lightViolet;
    XSSFColor lightPurple;

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public void createReportFile(Workbook workbook, String dateFrom, String dateTo) {
        this.workbook = (XSSFWorkbook) workbook;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Workbook endWriting(String net) {
        return workbook;
    }

    /*public ArrayList<TMAActivity> getTMAActivityFromFile(int photoType, String netName, LocalDate dateFrom, LocalDate dateTo) throws IOException {
        File file = new File("tma/tma_list.xlsx");
        if (!file.exists() || !file.isFile())
            return null;
        ArrayList<TMAActivity> activityList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = xssfWorkbook.getSheetAt(0);
        XSSFRow row;
        Iterator<Row> rowIterator = spreadsheet.iterator();
        int i = 0;
        while (rowIterator.hasNext()) {
            i++;
            if (i < 4) {
                rowIterator.next();
                continue;
            }
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String channel = cell.getStringCellValue();
            if (channel == "")
                break;
            cell = cellIterator.next();
            String net = cell.getStringCellValue();
            cell = cellIterator.next();
            String tg = cell.getStringCellValue();
            cell = cellIterator.next();
            String tmaName = cell.getStringCellValue();
            cell = cellIterator.next();
            LocalDate dateStart = cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            cell = cellIterator.next();
            LocalDate dateEnd = cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            TMAActivity activity = new TMAActivity(channel, net, tg, tmaName, dateStart, dateEnd, false, false);
            activityList.add(activity);
        }

        Collections.sort(activityList);

        String selectedChannel;
        if ((photoType == 1 || photoType == 3) && netName.equals("X5")) {
            selectedChannel = "X5";
        } else if ((photoType == 1 || photoType == 3) && netName.equals("Тандер")) {
            selectedChannel = "Тандер";
        } else {
            selectedChannel = "LKA";
        }

        for (int k = activityList.size() - 1; k >= 0; k--) {
            if (!activityList.get(k).getChannel().equals(selectedChannel)) {
                activityList.remove(k);
                continue;
            }

            if (!(
                    (activityList.get(k).getActivityStartDate().isBefore(dateTo) || activityList.get(k).getActivityStartDate().isEqual(dateTo))
                            &&
                            (activityList.get(k).getActivityEndDate().isAfter(dateFrom) || activityList.get(k).getActivityEndDate().isEqual(dateFrom))
            )) {
                activityList.remove(k);
                continue;
            }
        }

        return activityList;
    }*/



    protected XSSFCellStyle createBorderedStyle() {
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        return cellStyle;
    }
}
