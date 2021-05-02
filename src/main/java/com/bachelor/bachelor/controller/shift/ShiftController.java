package com.bachelor.bachelor.controller.shift;

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
@RequestMapping("/shifts")
public class ShiftController {

    @GetMapping
    public List<Shift> findShifts() {
        return null;
    }

    @PostMapping
    public void upsertShift(@RequestBody @Valid Shift shift) {
        log.info(shift.toString());
    }

}
