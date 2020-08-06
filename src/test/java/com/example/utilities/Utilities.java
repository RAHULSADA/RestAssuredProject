package com.example.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Utilities {

    public static Object[][] readExcel() throws IOException {
        var fileInputStream = new FileInputStream("LibraryAPI_TestData.xlsx");
        var workbook = new XSSFWorkbook(fileInputStream);
        var worksheet = workbook.getSheetAt(0);
        int rowCount = worksheet.getPhysicalNumberOfRows();
        var firstRow = worksheet.getRow(0);
        var columnCount = firstRow.getLastCellNum();
        var formatter = new DataFormatter();
        Object[][] dataSet = new Object[rowCount -1][columnCount];

        for (int i = 0; i < rowCount -1; i++) {
            for (int j = 0; j < columnCount; j++)
                dataSet[i][j] = formatter.formatCellValue(worksheet.getRow(i+1).getCell(j));
        }
        return dataSet;
    }
}
