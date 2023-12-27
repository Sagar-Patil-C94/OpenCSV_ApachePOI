package com.apachepoi;

import java.util.Date;

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

    @Override
    public String toString() {
        return "Employee{" +
                "eeid='" + eeid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", annualSalary=" + annualSalary +
                ", bonusPer=" + bonusPer +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getEeid() {
        return eeid;
    }

    public void setEeid(String eeid) {
        this.eeid = eeid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public long getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(long annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getBonusPer() {
        return bonusPer;
    }

    public void setBonusPer(double bonusPer) {
        this.bonusPer = bonusPer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String country;
    private String city;
}
