package org.example;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writter {
    //Using the writeNext() and writeALl method
    public static void write(String filePath) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath));
        String[] line1 = {"id", "name", "salary", "start_date", "dept"};
        String[] line2 = {"1", "Krishna", "2548", "2012-01-01", "IT"};
        String[] line3 = {"2", "Vishnu", "4522", "2013-02-26", "Operations"};
        String[] line4 = {"3", "Raja", "3021", "2016-10-10", "HR"};
        String[] line5 = {"4", "Raghav", "6988", "2012-01-01", "IT"};
        csvWriter.writeNext(line1);
        csvWriter.writeNext(line2);
        List<String[]> list = new ArrayList<>();
        list.add(line3);
        list.add(line4);
        list.add(line5);
        csvWriter.writeAll(list);
        csvWriter.flush();
        System.out.println("Data entered");
    }
}
