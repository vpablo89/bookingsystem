package verapablodaniel.ToDoApp.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.persistence.repositories.CourtRepository;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;
import verapablodaniel.ToDoApp.service.ports.CourtServicePort;
import verapablodaniel.ToDoApp.exceptions.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CourtService implements CourtServicePort {

    private static final Logger log = LoggerFactory.getLogger(CourtService.class);

    private final CourtRepository courtRepository;

    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public Court createCourt(CourtCreateDTO dto) {
        log.info("Creating court name='{}'", dto.getName());
        Court court = new Court(dto.getName(), dto.getLocation());
        try {
            return courtRepository.save(court);
        } catch (DataAccessException ex) {
            log.error("DB error creating court", ex);
            throw new RepositoryException("DB_ERROR", "Database error while creating court");
        }
    }

    public List<Court> getCourts() {
        log.info("Fetching all courts");
        return courtRepository.findAll();
    }
}

