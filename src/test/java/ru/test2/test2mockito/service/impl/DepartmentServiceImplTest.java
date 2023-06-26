package ru.test2.test2mockito.service.impl;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.test2.test2mockito.employees.Employee;

import java.util.*;
;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Иван", "Иванов", 246662, 1));
        add(new Employee("Петр", "Петров", 156754, 1));
        add(new Employee("Роман", "Романов", 345643, 1));
    }};

    DepartmentServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeMap.put(employees.get(i).getFirstName() + employees.get(i).getLastName(), employees.get(i));
        }
        when(employeeService.getEmployees()).thenReturn(employeeMap);


        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        assertEquals(employees.get(2), employeeWithMaxSalary);

    }


    @Test
    void shouldReturnEmployeeWithMinSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeMap.put(employees.get(i).getFirstName() + employees.get(i).getLastName(), employees.get(i));
        }
        when(employeeService.getEmployees()).thenReturn(employeeMap);


        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);

        assertEquals(employees.get(1), employeeWithMinSalary);

    }

    @Test
    void testGetGroupedByDepartmentEmployees() {


        final Map<String, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeMap.put(String.valueOf(employees.get(i).getDepartment()), employees.get(i));
        }
            when(employeeService.getEmployees()).thenReturn(employeeMap);

       Map<Integer, List<Employee>> groupedByDepartmentEmployees = departmentService.getGroupedByDepartmentEmployees();

        assertEquals(employeeMap, groupedByDepartmentEmployees);

    }
}