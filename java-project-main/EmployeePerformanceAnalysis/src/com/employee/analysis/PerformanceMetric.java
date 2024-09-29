package com.employee.analysis;

public class PerformanceMetric {
    private int employeeId;
    private int year;
    private int quarter;
    private double rating;

    public PerformanceMetric(int employeeId, int year, int quarter, double rating) {
        this.employeeId = employeeId;
        this.year = year;
        this.quarter = quarter;
        this.rating = rating;
    }

    public int getEmployeeId() { return employeeId; }
    public int getYear() { return year; }
    public int getQuarter() { return quarter; }
    public double getRating() { return rating; }
}
