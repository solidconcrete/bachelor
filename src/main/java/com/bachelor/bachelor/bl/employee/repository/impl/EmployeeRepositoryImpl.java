package com.bachelor.bachelor.bl.employee.repository.impl;

import com.bachelor.bachelor.bl.employee.repository.EmployeeRepository;
import com.bachelor.bachelor.bl.employee.repository.EmployeeRepositoryCustom;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public EmployeeRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Employee> searchEmployees(EmployeeSearch search) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (!search.getName().isEmpty()) {
            criteria.add(Criteria.where("name").regex(Objects.requireNonNull(MongoRegexCreator.INSTANCE.toRegularExpression(
                    search.getName(), MongoRegexCreator.MatchMode.LIKE
            )), "i"));
        }
        query.addCriteria(criteria.get(0));
        return mongoTemplate.find(query, Employee.class);
    }

}
