package com.bachelor.bachelor.bl.employee.repository;

import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepositoryCustom {

    List<Employee> searchEmployees(EmployeeSearch search);
}
