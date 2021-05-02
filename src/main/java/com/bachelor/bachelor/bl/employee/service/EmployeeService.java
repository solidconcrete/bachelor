package com.bachelor.bachelor.bl.employee.service;

import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.employee.EmployeeSearch;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee findEmployeeById(String id);
    List<Employee> searchEmployee(EmployeeSearch search);
    void upsertEmployee(Employee employee);
}
