package com.opencsv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStd_cls() {
        return std_cls;
    }

    public void setStd_cls(String std_cls) {
        this.std_cls = std_cls;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", std_cls='" + std_cls + '\'' +
                ", mark=" + mark +
                ", gender='" + gender + '\'' +
                '}';
    }
}
