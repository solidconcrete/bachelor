package com.bachelor.bachelor.controller.shift;

import com.bachelor.bachelor.TenantProvider;
import com.bachelor.bachelor.bl.shift.service.ShiftService;
import com.bachelor.bachelor.model.shift.Shift;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ShiftController {

    private final ShiftService shiftService;

    @GetMapping("/shifts")
    public List<Shift> findShifts() {
        return shiftService.findAllShifts();
    }

    @PostMapping("/internal/shifts")
    public void upsertShift(@RequestBody @Valid Shift shift) {
        shiftService.upsertShift(shift);
    }

}
