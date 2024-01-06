package com.sql;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DbToXl {
    public static void getXlsx(String targetFileName) throws IOException, SQLException {
        ResultSet resultSet = DbResult.getResult();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file Name : ");
        String filePath = scanner.nextLine();
        // Create a new workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create a new sheet
        Sheet sheet = workbook.createSheet("Cars");
        // Get the ResultSet metadata to retrieve column names
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        // Create the header row
        Row headerRow = sheet.createRow(0);
        for (int i = 1; i <= columnCount; i++) {
            Cell cell = headerRow.createCell(i - 1);
            cell.setCellValue(metaData.getColumnName(i));
        }
        // Populate the sheet with data
        int rowNum = 1;
        while (resultSet.next()) {
            Row dataRow = sheet.createRow(rowNum++);
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = dataRow.createCell(i - 1);
                cell.setCellValue(resultSet.getString(i));
            }
        }
        // Write the workbook content to a file
        try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/"+targetFileName+".xlsx")) {
            workbook.write(fileOut);
        }
        // Close the workbook
        workbook.close();
        System.out.println("Excel file has been created successfully!");
    }

    public static void main(String[] args) throws SQLException, IOException {
        getXlsx("CarsDB");
    }
}
