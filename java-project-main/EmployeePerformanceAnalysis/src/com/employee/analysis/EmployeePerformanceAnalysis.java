package com.employee.analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeePerformanceAnalysis {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Doe", "IT", 75000, LocalDate.of(2020, 1, 15)),
            new Employee(2, "Jane Smith", "HR", 65000, LocalDate.of(2019, 5, 11)),
            new Employee(3, "Mike Johnson", "Finance", 80000, LocalDate.of(2018, 3, 20)),
            new Employee(4, "Emily Brown", "IT", 72000, LocalDate.of(2021, 7, 8))
        );

        List<PerformanceMetric> performanceMetrics = Arrays.asList(
            new PerformanceMetric(1, 2023, 1, 4.2),
            new PerformanceMetric(1, 2023, 2, 4.5),
            new PerformanceMetric(2, 2023, 1, 3.8),
            new PerformanceMetric(2, 2023, 2, 4.0),
            new PerformanceMetric(3, 2023, 1, 4.7),
            new PerformanceMetric(3, 2023, 2, 4.8),
            new PerformanceMetric(4, 2023, 1, 3.9),
            new PerformanceMetric(4, 2023, 2, 4.1)
        );

        printAverageSalaryByDept(employees);
        printTopPerformer(employees, performanceMetrics);
        printRecentHires(employees);
        printTotalSalaryExpense(employees);
        printImprovedEmployees(employees, performanceMetrics);
    }

    public static void printAverageSalaryByDept(List<Employee> employees) {
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        System.out.println("Average salary by department: " + avgSalaryByDept);
    }

    public static void printTopPerformer(List<Employee> employees, List<PerformanceMetric> performanceMetrics) {
        Map<Integer, Double> avgRatingByEmployee = performanceMetrics.stream()
            .collect(Collectors.groupingBy(
                PerformanceMetric::getEmployeeId,
                Collectors.averagingDouble(PerformanceMetric::getRating)
            ));

        Employee topPerformer = employees.stream()
            .max((e1, e2) -> Double.compare(
                avgRatingByEmployee.getOrDefault(e1.getId(), 0.0),
                avgRatingByEmployee.getOrDefault(e2.getId(), 0.0)
            ))
            .orElse(null);

        System.out.println("Top performer: " + topPerformer);
    }

    public static void printRecentHires(List<Employee> employees) {
        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        List<Employee> recentHires = employees.stream()
            .filter(e -> e.getHireDate().isAfter(twoYearsAgo))
            .collect(Collectors.toList());
        System.out.println("Employees hired in the last 2 years: " + recentHires);
    }

    public static void printTotalSalaryExpense(List<Employee> employees) {
        double totalSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum();
        System.out.println("Total salary expense: $" + totalSalary);
    }

    public static void printImprovedEmployees(List<Employee> employees, List<PerformanceMetric> performanceMetrics) {
        List<Employee> improvedEmployees = employees.stream()
            .filter(e -> {
                List<PerformanceMetric> metrics = performanceMetrics.stream()
                    .filter(m -> m.getEmployeeId() == e.getId())
                    .sorted((m1, m2) -> {
                        if (m1.getYear() != m2.getYear()) {
                            return Integer.compare(m1.getYear(), m2.getYear());
                        }
                        return Integer.compare(m1.getQuarter(), m2.getQuarter());
                    })
                    .collect(Collectors.toList());
                return metrics.size() > 1 &&
                    metrics.get(metrics.size() - 1).getRating() > metrics.get(0).getRating();
            })
            .collect(Collectors.toList());
        System.out.println("Employees with performance improvement: " + improvedEmployees);
    }
}
