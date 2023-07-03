package ru.test2.test2mockito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test2.test2mockito.employees.Employee;
import ru.test2.test2mockito.service.EmployeeService;
import ru.test2.test2mockito.validator.EmployeeValidator;

import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department
    ) {
        if (EmployeeValidator.validate(firstName, lastName)) {
            return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName, salary, department));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/remove")
    public void removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Map<String, Employee> getEmployees() {
        return employeeService.getEmployees();
    }



}
