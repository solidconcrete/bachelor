package com.bachelor.bachelor.bl.address.service.impl;

import com.bachelor.bachelor.model.address.Address;
import com.bachelor.bachelor.bl.address.repository.AddressRepository;
import com.bachelor.bachelor.bl.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void upsertAddress(Address address) {
        addressRepository.save(address);
    }
}
