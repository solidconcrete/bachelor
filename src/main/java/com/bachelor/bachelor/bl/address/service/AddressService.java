package com.bachelor.bachelor.bl.address.service;

import com.bachelor.bachelor.model.address.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAllAddresses();
    void upsertAddress(Address address);
}
