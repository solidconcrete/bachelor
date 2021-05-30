package com.bachelor.bachelor.controller.address;

import com.bachelor.bachelor.TenantProvider;
import com.bachelor.bachelor.bl.address.service.AddressService;
import com.bachelor.bachelor.model.address.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> findAllAddresses() {
        return addressService.findAllAddresses();
    }

    @PostMapping("/admin/addresses")
    public void upsertAddress(@RequestBody @Valid Address address) {
        addressService.upsertAddress(address);
    }
}
