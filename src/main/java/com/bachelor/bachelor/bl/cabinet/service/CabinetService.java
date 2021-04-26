package com.bachelor.bachelor.bl.cabinet.service;

import com.bachelor.bachelor.model.cabinet.Cabinet;

import java.util.List;

public interface CabinetService {

    List<Cabinet> findAllCabinets();
    void upsertCabinet(Cabinet cabinet);
}
