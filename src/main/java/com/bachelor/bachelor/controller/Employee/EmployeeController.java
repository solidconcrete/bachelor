package com.bachelor.bachelor.controller.Employee;

import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.service.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @PostMapping()
    public void insertOrUpdateEmployee(@RequestBody Employee employee) {
        employeeService.upsertEmployee(employee);
    }
}
