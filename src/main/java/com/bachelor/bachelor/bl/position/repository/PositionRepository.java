package com.bachelor.bachelor.bl.position.repository;

import com.bachelor.bachelor.model.position.Position;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PositionRepository extends MongoRepository<Position, String> {
}
