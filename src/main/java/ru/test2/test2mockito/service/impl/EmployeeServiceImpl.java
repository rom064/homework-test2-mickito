package ru.test2.test2mockito.service.impl;

import org.springframework.stereotype.Service;
import ru.test2.test2mockito.employees.Employee;
import ru.test2.test2mockito.exception.ArrayIsFull;
import ru.test2.test2mockito.exception.EmployeeAlreadyAdded;
import ru.test2.test2mockito.exception.EmployeeNotFound;
import ru.test2.test2mockito.service.EmployeeService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 5;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAdded("Сотрудник уже есть в стиске!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new ArrayIsFull("Список заполнен!");
        }
        employees.put(employeeKey, new Employee(firstName, lastName, salary, department));
        return employees.get(employeeKey);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAdded("Такой сотрудник есть в списке!");
        }
        employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFound("Такого сотрудника нет в списке!");
        }
        return employees.get(employeeKey);
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
