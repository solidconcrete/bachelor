package com.bachelor.bachelor.controller.address;

import com.bachelor.bachelor.bl.address.service.AddressService;
import com.bachelor.bachelor.model.address.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> findAllAddresses() {
        return addressService.findAllAddresses();
    }

    @PostMapping
    public void upsertAddress(@RequestBody Address address) {
        addressService.upsertAddress(address);
    }
}
