package ru.test2.test2mockito.service;


import ru.test2.test2mockito.employees.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> getEmployees();


}
