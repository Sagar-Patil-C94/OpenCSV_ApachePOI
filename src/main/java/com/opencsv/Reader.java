package com.opencsv;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    // Using for loop line by line reading
    public static void readLines(String filePath) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Student> students = new ArrayList<>();
        String[] record = null;
        boolean isFirstLine = true;
        while ((record = reader.readNext()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            Student student = new Student();
            student.setId(Integer.parseInt(record[0]));
            student.setName(record[1]);
            student.setStd_cls(record[2]);
            student.setMark(Integer.parseInt(record[3]));
            student.setGender(record[4]);
            students.add(student);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        reader.close();
    }

    // Using iterator object
    public static void iterRead(String filePath) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Student> students = new ArrayList<>();
        boolean isFirstLine = true;
        for (String[] record : reader) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            Student student = new Student();
            student.setId(Integer.parseInt(record[0]));
            student.setName(record[1]);
            student.setStd_cls(record[2]);
            student.setMark(Integer.parseInt(record[3]));
            student.setGender(record[4]);
            students.add(student);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        reader.close();
    }

    public static void readAll(String filePath) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Student> students = new ArrayList<>();
        List<String[]> records = reader.readAll();
        boolean isFirstLine = true;
        for (String[] record : records) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            Student student = new Student();
            student.setId(Integer.parseInt(record[0]));
            student.setName(record[1]);
            student.setStd_cls(record[2]);
            student.setMark(Integer.parseInt(record[3]));
            student.setGender(record[4]);
            students.add(student);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        reader.close();
    }
}
