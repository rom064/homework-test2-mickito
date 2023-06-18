package ru.test2.test2mockito.employees;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private  String firstName;
    private  String lastName;
    private Integer salary;
    private Integer department;

    public Employee(String firstName, String lastName, Integer salary, Integer department) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
