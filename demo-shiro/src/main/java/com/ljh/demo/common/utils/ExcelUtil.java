package com.ljh.demo.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author ljh
 * @date 2019-11-20 15:06
 */
public class ExcelUtil {
    public static void down(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet, HttpServletResponse response) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(entity, pojoClass, dataSet);
        Sheet sheet = workbook.getSheet(entity.getTitle());
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE1.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        /**
         * 隔行换色
         * */
        int totalRows = sheet.getLastRowNum();
        int totalCells;
        Row row;
        for (int i = 2; i <= totalRows; i++) {
            if (i % 2 == 0) {
                row = sheet.getRow(i);
                totalCells = row.getPhysicalNumberOfCells();
                for (int j = 0; j < totalCells; j++) {
                    row.getCell(j).setCellStyle(cellStyle);
                }
            }
        }
        ServletOutputStream fileOutputStream = response.getOutputStream();
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void downSimple(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet, HttpServletResponse response) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(entity, pojoClass, dataSet);
        ServletOutputStream fileOutputStream = response.getOutputStream();
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
