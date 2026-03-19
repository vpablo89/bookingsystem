package verapablodaniel.ToDoApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.service.ports.CourtServicePort;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/courts")
public class CourtController {

    private static final Logger log = LoggerFactory.getLogger(CourtController.class);

    private final CourtServicePort courtService;

    public CourtController(CourtServicePort courtService) {
        this.courtService = courtService;
    }

    @PostMapping
    public ResponseEntity<Court> createCourt(@Valid @RequestBody CourtCreateDTO dto) {
        log.debug("POST /courts");
        Court created = courtService.createCourt(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Court> getCourts() {
        log.debug("GET /courts");
        return courtService.getCourts();
    }
}

