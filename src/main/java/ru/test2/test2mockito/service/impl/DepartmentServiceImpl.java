package ru.test2.test2mockito.service.impl;

import org.springframework.stereotype.Service;
import ru.test2.test2mockito.employees.Employee;
import ru.test2.test2mockito.service.DepartmentService;
import ru.test2.test2mockito.service.EmployeeService;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> departmentId == null || employee.getDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
