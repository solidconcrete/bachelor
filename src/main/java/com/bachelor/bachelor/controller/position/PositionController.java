package com.bachelor.bachelor.controller.position;

import com.bachelor.bachelor.bl.position.service.PositionService;
import com.bachelor.bachelor.model.position.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public List<Position> findAllPositions() {
        return positionService.findAllpositions();
    }

    @PostMapping
    public void upsertPosition(@RequestBody @Valid Position position) {
        log.info(position.toString());
        positionService.upsertPosition(position);
    }
}
