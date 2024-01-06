package com.opencsv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Student {
    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByName(column = "name")
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByName(column = "class")
    @CsvBindByPosition(position = 2)
    private String std_cls;
    @CsvBindByName(column = "mark")
    @CsvBindByPosition(position = 3)
    private int mark;
    @CsvBindByName(column = "gender")
    @CsvBindByPosition(position = 4)
    private String gender;
}
