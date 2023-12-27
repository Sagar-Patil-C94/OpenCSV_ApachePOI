package org.example;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Bean {
    // Using HeaderColumnNameMappingStrategy
    public static void parseCsvToBean(String filePath, String targetPath) {
        try (FileReader reader = new FileReader(filePath)) {
            HeaderColumnNameMappingStrategy<Student> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Student.class);
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Student> students = csvToBean.parse();
            for (Student student : students) {
                System.out.println(student);
            }
            // Bean To CSV
            CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/" + targetPath + ".csv"));
            writer.writeNext(new String[]{"id", "name", "std_cls", "mark", "gender"});
            for (Student student : students) {
                writer.writeNext(new String[]{
                        String.valueOf(student.getId()),
                        student.getName(),
                        student.getStd_cls(),
                        String.valueOf(student.getMark()),
                        student.getGender()
                });
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // Using ColumnPositionMappingStrategy
    public static void parseCsv(String filePath, String targetPath) {
        try (FileReader reader = new FileReader(filePath)) {
            ColumnPositionMappingStrategy<Student> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Student.class);
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)// Skip Header Row
                    .build();
            List<Student> students = csvToBean.parse();
            for (Student student : students) {
                System.out.println(student);
            }
            // Bean To CSV
            CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/" + targetPath + ".csv"));
            writer.writeNext(new String[]{"id", "name", "std_cls", "mark", "gender"});
            for (Student student : students) {
                writer.writeNext(new String[]{
                        String.valueOf(student.getId()),
                        student.getName(),
                        student.getStd_cls(),
                        String.valueOf(student.getMark()),
                        student.getGender()
                });
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

