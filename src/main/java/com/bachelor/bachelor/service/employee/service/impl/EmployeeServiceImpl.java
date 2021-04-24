package com.bachelor.bachelor.service.employee.service.impl;

import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.service.employee.repository.EmployeeRepository;
import com.bachelor.bachelor.service.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
}
