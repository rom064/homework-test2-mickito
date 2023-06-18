package ru.test2.test2mockito.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.test2.test2mockito.employees.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Иван1", "Иванов1", 246662, 1));
        add(new Employee("Иван2", "Иванов2", 156754, 1));
        add(new Employee("Иван3", "Иванов3", 345643, 1));
        add(new Employee("Иван4", "Иванов4", 400000, 1));

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

        Assertions.assertEquals(employees.get(2), employeeWithMaxSalary);

    }


    @Test
    void getEmployeeWithMinSalary() {
    }

    @Test
    void getGroupedByDepartmentEmployees() {
    }
}