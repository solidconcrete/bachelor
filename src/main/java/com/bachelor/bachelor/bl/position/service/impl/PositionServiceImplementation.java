package com.bachelor.bachelor.bl.position.service.impl;

import com.bachelor.bachelor.bl.position.repository.PositionRepository;
import com.bachelor.bachelor.bl.position.service.PositionService;
import com.bachelor.bachelor.model.position.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PositionServiceImplementation implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public List<Position> findAllpositions() {
        return positionRepository.findAll();
    }

    @Override
    public void upsertPosition(Position position) {
        positionRepository.save(position);
    }
}
