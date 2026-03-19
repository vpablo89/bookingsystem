package verapablodaniel.ToDoApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.service.ReservationService;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationCreateDTO dto) {
        Reservation created = reservationService.createReservation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }
}

