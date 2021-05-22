package com.bachelor.bachelor.controller.employee;

import com.bachelor.bachelor.TenantProvider;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.bl.employee.service.EmployeeService;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable ("id") String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/search")
    public List<Employee> searchEmployees(@RequestBody EmployeeSearch search) {
        return employeeService.searchEmployee(search);
    }

    @PostMapping()
    public void insertOrUpdateEmployee(@RequestBody @Valid Employee employee) {
        employeeService.upsertEmployee(employee);
    }
}
