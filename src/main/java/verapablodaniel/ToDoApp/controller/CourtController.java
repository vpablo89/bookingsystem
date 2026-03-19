package verapablodaniel.ToDoApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.service.CourtService;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;

import java.util.List;

@RestController
@RequestMapping("/courts")
public class CourtController {

    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @PostMapping
    public ResponseEntity<Court> createCourt(@RequestBody CourtCreateDTO dto) {
        Court created = courtService.createCourt(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Court> getCourts() {
        return courtService.getCourts();
    }
}

