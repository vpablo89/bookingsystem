package verapablodaniel.ToDoApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.service.ports.ReservationServicePort;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationServicePort reservationService;

    public ReservationController(ReservationServicePort reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody ReservationCreateDTO dto) {
        log.debug("POST /reservations");
        Reservation created = reservationService.createReservation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Reservation> getReservations() {
        log.debug("GET /reservations");
        return reservationService.getReservations();
    }
}

