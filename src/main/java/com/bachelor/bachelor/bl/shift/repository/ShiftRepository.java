package com.bachelor.bachelor.bl.shift.repository;

import com.bachelor.bachelor.model.shift.Shift;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShiftRepository extends MongoRepository<Shift, String > {
}
