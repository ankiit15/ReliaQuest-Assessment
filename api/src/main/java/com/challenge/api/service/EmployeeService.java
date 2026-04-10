package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.challenge.api.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }
}
