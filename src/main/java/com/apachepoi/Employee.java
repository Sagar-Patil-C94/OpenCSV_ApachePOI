package com.apachepoi;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Employee {
    private String eeid;
    private String fullName;
    private String jobTitle;
    private String department;
    private String businessUnit;
    private String gender;
    private String ethnicity;
    private int age;
    private Date hireDate;
    private long annualSalary;
    private double bonusPer;
    private String country;
    private String city;
}
