package com.bachelor.bachelor.controller.cabinet;

import com.bachelor.bachelor.bl.cabinet.service.CabinetService;
import com.bachelor.bachelor.model.cabinet.Cabinet;
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
@RequestMapping("cabinets")
public class CabinetController {

    private final CabinetService cabinetService;

    @GetMapping
    public List<Cabinet> findAllCabinets() {
        return cabinetService.findAllCabinets();
    }

    @PostMapping
    public void upsertCabinet(@RequestBody @Valid Cabinet cabinet) {
        cabinetService.upsertCabinet(cabinet);
    }
}
