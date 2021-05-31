package com.bachelor.bachelor.bl.employee.repository.impl;

import com.bachelor.bachelor.bl.employee.repository.EmployeeRepository;
import com.bachelor.bachelor.bl.employee.repository.EmployeeRepositoryCustom;
import com.bachelor.bachelor.model.employee.Employee;
import com.bachelor.bachelor.model.employee.EmployeeSearch;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
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
        if (search.getName() != null && !search.getName().isEmpty()) {
            criteria.add(Criteria.where("name").regex(MongoRegexCreator.INSTANCE.toRegularExpression(
                    search.getName(), MongoRegexCreator.MatchMode.LIKE
            ), "i"));
        }

        if (search.getSurname() != null && !search.getSurname().isEmpty()) {
            criteria.add(Criteria.where("surname").regex(MongoRegexCreator.INSTANCE.toRegularExpression(
                    search.getSurname(), MongoRegexCreator.MatchMode.LIKE
            ), "i"));
        }

        if (search.getPositionId() != null && !search.getPositionId().isEmpty()) {
            criteria.add(Criteria.where("position.id").is(search.getPositionId()));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, Employee.class);
    }

}
