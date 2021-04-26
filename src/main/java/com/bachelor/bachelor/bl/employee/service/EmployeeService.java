package com.bachelor.bachelor.bl.employee.service;

import com.bachelor.bachelor.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    void upsertEmployee(Employee employee);
}
