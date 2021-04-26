package com.bachelor.bachelor.bl.employee.repository;

import com.bachelor.bachelor.model.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {


}
