package verapablodaniel.ToDoApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import verapablodaniel.ToDoApp.exceptions.service.UserNotFoundException;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.persistence.entities.Reservation;
import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.persistence.repositories.CourtRepository;
import verapablodaniel.ToDoApp.persistence.repositories.ReservationRepository;
import verapablodaniel.ToDoApp.persistence.repositories.UserRepository;
import verapablodaniel.ToDoApp.service.dto.ReservationCreateDTO;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CourtRepository courtRepository;

    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        reservationService = new ReservationService(reservationRepository, userRepository, courtRepository);
    }

    @Test
    void createReservation_whenUserAndCourtExist_savesAndReturnsReservation() {
        User user = new User("Alice");
        user.setId(1L);

        Court court = new Court("Court A", "Location A");
        court.setId(10L);

        ReservationCreateDTO dto = new ReservationCreateDTO();
        dto.setUserId(1L);
        dto.setCourtId(10L);
        dto.setStartTime(LocalDateTime.of(2026, 3, 19, 10, 0));
        dto.setEndTime(LocalDateTime.of(2026, 3, 19, 11, 0));

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(courtRepository.findById(10L)).thenReturn(Optional.of(court));

        Reservation saved = new Reservation(user, court, dto.getStartTime(), dto.getEndTime());
        saved.setId(100L);
        Mockito.when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(saved);

        Reservation result = reservationService.createReservation(dto);

        assertNotNull(result);
        assertEquals(100L, result.getId());
        assertEquals("Alice", result.getUser().getName());
        assertEquals("Court A", result.getCourt().getName());

        Mockito.verify(reservationRepository).save(Mockito.any(Reservation.class));
    }

    @Test
    void createReservation_whenUserMissing_throwsNotFoundException() {
        ReservationCreateDTO dto = new ReservationCreateDTO();
        dto.setUserId(999L);
        dto.setCourtId(10L);
        dto.setStartTime(LocalDateTime.of(2026, 3, 19, 10, 0));
        dto.setEndTime(LocalDateTime.of(2026, 3, 19, 11, 0));

        Mockito.when(userRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> reservationService.createReservation(dto));
        Mockito.verify(reservationRepository, Mockito.never()).save(Mockito.any());
    }
}

