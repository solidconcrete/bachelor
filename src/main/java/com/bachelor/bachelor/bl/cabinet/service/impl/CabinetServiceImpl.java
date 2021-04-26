package com.bachelor.bachelor.bl.cabinet.service.impl;

import com.bachelor.bachelor.bl.cabinet.repository.CabinetRepository;
import com.bachelor.bachelor.bl.cabinet.service.CabinetService;
import com.bachelor.bachelor.model.cabinet.Cabinet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CabinetServiceImpl implements CabinetService {

    private final CabinetRepository cabinetRepository;

    @Override
    public List<Cabinet> findAllCabinets() {
        return cabinetRepository.findAll();
    }

    @Override
    public void upsertCabinet(Cabinet cabinet) {
        cabinetRepository.save(cabinet);
    }
}
