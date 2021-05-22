package com.bachelor.bachelor.bl.user.repository;

import com.bachelor.bachelor.model.CustomUser.CustomUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<CustomUser, String> {
    CustomUser findByUsername(String username);
}
