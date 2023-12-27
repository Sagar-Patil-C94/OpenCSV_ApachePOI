package com.opencsv;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws CsvException, IOException {
        String readfilePath = "src/main/resources/student.csv";
        String writeFilePath = "src/main/resources/created.csv";
        String targetPath = "toCsv";
        // Reader
        Reader.readLines(readfilePath);
        Reader.readAll(readfilePath);
        Reader.iterRead(readfilePath);
        // Writter
        Writter.write(writeFilePath);
        // Csv To Bean and Vice Versa
        Bean.parseCsvToBean(readfilePath, targetPath);
        Bean.parseCsv(readfilePath, targetPath);
    }
}
