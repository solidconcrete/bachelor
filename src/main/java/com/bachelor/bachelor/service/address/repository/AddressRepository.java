package com.bachelor.bachelor.service.address.repository;

import com.bachelor.bachelor.model.address.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
