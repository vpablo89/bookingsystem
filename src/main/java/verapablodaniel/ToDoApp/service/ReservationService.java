package verapablodaniel.ToDoApp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import verapablodaniel.ToDoApp.exceptions.repository.RepositoryException;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.persistence.repositories.CourtRepository;
import verapablodaniel.ToDoApp.persistence.repositories.ReservationRepository;
import verapablodaniel.ToDoApp.persistence.repositories.UserRepository;
import verapablodaniel.ToDoApp.exceptions.service.CourtNotFoundException;
import verapablodaniel.ToDoApp.exceptions.service.InvalidReservationException;
import verapablodaniel.ToDoApp.exceptions.service.UserNotFoundException;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;
import verapablodaniel.ToDoApp.service.ports.ReservationServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ReservationService implements ReservationServicePort {

    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

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
        log.info("Creating reservation userId={} courtId={}", dto.getUserId(), dto.getCourtId());
        if (dto.getEndTime() != null && dto.getStartTime() != null && !dto.getEndTime().isAfter(dto.getStartTime())) {
            throw new InvalidReservationException(
                    "INVALID_RESERVATION_TIME",
                    "endTime must be after startTime"
            );
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found: " + dto.getUserId()));

        Court court = courtRepository.findById(dto.getCourtId())
                .orElseThrow(() -> new CourtNotFoundException("Court not found: " + dto.getCourtId()));

        Reservation reservation = new Reservation(user, court, dto.getStartTime(), dto.getEndTime());
        try {
            return reservationRepository.save(reservation);
        } catch (DataAccessException ex) {
            log.error("DB error creating reservation", ex);
            throw new RepositoryException("DB_ERROR", "Database error while creating reservation");
        }
    }

    public List<Reservation> getReservations() {
        log.info("Fetching all reservations");
        return reservationRepository.findAll();
    }
}

