package com.apachepoi;

public class App {
    public static void main(String[] args) {
        Reader.read("Employee_Data.xlsx");
        Writter.writeData("Generated");
    }
}