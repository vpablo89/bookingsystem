package verapablodaniel.ToDoApp.service.ports;

import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;

import java.util.List;

public interface ReservationServicePort {
    Reservation createReservation(ReservationCreateDTO dto);

    List<Reservation> getReservations();
}

