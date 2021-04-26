package com.bachelor.bachelor.bl.cabinet.repository;

import com.bachelor.bachelor.model.cabinet.Cabinet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CabinetRepository extends MongoRepository<Cabinet, String> {
}
