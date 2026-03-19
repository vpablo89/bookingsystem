package verapablodaniel.ToDoApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

