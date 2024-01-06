package com.apachepoi;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVParser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writter {
    public static void writeData(String targetFileName) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            workbook.createSheet("Sheet 1");
            Sheet sheet = workbook.getSheetAt(0);
            // Create some sample data
            Object[][] data = {
                    {"Name", "Age", "City"},
                    {"John Doe", 25, "New York"},
                    {"Jane Doe", 30, "San Francisco"},
                    {"Bob Smith", 22, "Chicago"}
            };
            // Populate the sheet with data
            int rowNum = 0;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            workbook.write(Files.newOutputStream(Paths.get("src/main/resources/" + targetFileName + ".xlsx")));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

