package com.bachelor.bachelor.bl.position.service;

import com.bachelor.bachelor.model.position.Position;

import java.util.List;

public interface PositionService {

    List<Position> findAllpositions();
    void upsertPosition(Position position);
}
