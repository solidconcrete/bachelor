package com.bachelor.bachelor.service.employee.repository;

import com.bachelor.bachelor.model.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {


}
