package com.bachelor.bachelor.bl.employee.service.impl;

import com.bachelor.bachelor.bl.employee.repository.EmployeeRepositoryCustom;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.bl.employee.repository.EmployeeRepository;
import com.bachelor.bachelor.bl.employee.service.EmployeeService;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void upsertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("employee with id " + id + " not found"));
    }

    @Override
    public List<Employee> searchEmployee(EmployeeSearch search) {
        return employeeRepository.searchEmployees(search);
    }
}
