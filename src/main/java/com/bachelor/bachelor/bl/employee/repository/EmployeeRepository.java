package com.bachelor.bachelor.bl.employee.repository;

import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String>, EmployeeRepositoryCustom {
//    @Query("{user.}")
//    @Query("{'name' : ?0, 'surname' : ?1}")
//    List<Employee> searchEmployees(String name, String surname);
}
