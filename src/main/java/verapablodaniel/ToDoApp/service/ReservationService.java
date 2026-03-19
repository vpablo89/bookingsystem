package verapablodaniel.ToDoApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import verapablodaniel.ToDoApp.exceptions.NotFoundException;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.persistence.repositories.CourtRepository;
import verapablodaniel.ToDoApp.persistence.repositories.ReservationRepository;
import verapablodaniel.ToDoApp.persistence.repositories.UserRepository;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final CourtRepository courtRepository;

    public ReservationService(
            ReservationRepository reservationRepository,
            UserRepository userRepository,
            CourtRepository courtRepository
    ) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.courtRepository = courtRepository;
    }

    @Transactional
    public Reservation createReservation(ReservationCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found: " + dto.getUserId()));

        Court court = courtRepository.findById(dto.getCourtId())
                .orElseThrow(() -> new NotFoundException("Court not found: " + dto.getCourtId()));

        Reservation reservation = new Reservation(user, court, dto.getStartTime(), dto.getEndTime());
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}

