package com.bachelor.bachelor.bl.shift.service;

import com.bachelor.bachelor.model.shift.Shift;

import javax.validation.Valid;
import java.util.List;

public interface ShiftService {

    List<Shift> findAllShifts();
    void upsertShift(Shift shift);
}
