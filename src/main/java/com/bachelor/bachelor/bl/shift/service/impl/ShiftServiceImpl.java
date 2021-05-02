package com.bachelor.bachelor.bl.shift.service.impl;

import com.bachelor.bachelor.bl.shift.repository.ShiftRepository;
import com.bachelor.bachelor.bl.shift.service.ShiftService;
import com.bachelor.bachelor.model.shift.Shift;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;

    @Override
    public List<Shift> findAllShifts() {
        return shiftRepository.findAll();
    }

    @Override
    public void upsertShift(Shift shift) {
        shiftRepository.save(shift);
    }
}
