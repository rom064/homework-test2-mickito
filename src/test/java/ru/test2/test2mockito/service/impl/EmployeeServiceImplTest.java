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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Иван", "Иванов", 246662, 1));
        add(new Employee("Петр", "Петров", 156754, 1));
        add(new Employee("Роман", "Романов", 345643, 1));
    }};

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployeeTest() {
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {

            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getEmployees()).willReturn(employeeMap);

        Map<String, Employee> addEmployee = employeeService.getEmployees();

        Assertions.assertEquals(employeeMap,addEmployee);
        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    void removeEmployee() {
    }

    @Test
    void findEmployee() {
    }

    @Test
    void getEmployees() {
    }
}