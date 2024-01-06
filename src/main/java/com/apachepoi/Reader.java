package com.apachepoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Reader {
    public static void read(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            FileInputStream reader = new FileInputStream("src/main/resources/" + fileName);
            Workbook workbook = null;
            if (fileName.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(reader);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(reader);
            }
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator iterator = sheet.rowIterator();
                if (iterator.hasNext()) {
                    iterator.next();
                }
                while (iterator.hasNext()) {
                    Employee employee = new Employee();
                    Row row = (Row) iterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getColumnIndex()) {
                            case 0:
                                employee.setEeid(cell.getStringCellValue());
                                break;
                            case 1:
                                employee.setFullName(cell.getStringCellValue());
                                break;
                            case 2:
                                employee.setJobTitle(cell.getStringCellValue());
                                break;
                            case 3:
                                employee.setDepartment(cell.getStringCellValue());
                                break;
                            case 4:
                                employee.setBusinessUnit(cell.getStringCellValue());
                                break;
                            case 5:
                                employee.setGender(cell.getStringCellValue());
                                break;
                            case 6:
                                employee.setEthnicity(cell.getStringCellValue());
                                break;
                            case 7:
                                employee.setAge((int) cell.getNumericCellValue());
                                break;
                            case 8:
                                employee.setHireDate(cell.getDateCellValue());
                                break;
                            case 9:
                                employee.setAnnualSalary((long) cell.getNumericCellValue());
                                break;
                            case 10:
                                employee.setBonusPer(cell.getNumericCellValue());
                                break;
                            case 11:
                                employee.setCountry(cell.getStringCellValue());
                                break;
                            case 12:
                                employee.setCity(cell.getStringCellValue());
                                break;

                        }
                    }
                    employees.add(employee);
                }
            }
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
