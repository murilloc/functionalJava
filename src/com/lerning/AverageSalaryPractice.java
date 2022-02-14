package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryPractice {

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        StreamPractice.Employee[] employeesArr = {
                new StreamPractice.Employee("John", 34, "developer", 80000f),
                new StreamPractice.Employee("Hannah", 24, "developer", 95000f),
                new StreamPractice.Employee("Bart", 50, "sales executive", 100000f),
                new StreamPractice.Employee("Sophie", 49, "construction worker", 40000f),
                new StreamPractice.Employee("Darren", 38, "writer", 50000f),
                new StreamPractice.Employee("Nancy", 29, "developer", 75000f),
        };

        List<StreamPractice.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));


        // Mapa com a média de salários por emprego
        Map<String, Float> averageSlrariesMap = employees
                .stream()
                .collect(Collectors.groupingBy(
                        (employee -> employee.jobTitle)
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  //(entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map((employee -> employee.salary))
                                .reduce(0f, Float::sum) / entry.getValue().size()
                ));

        System.out.println(averageSlrariesMap);


    }
}
