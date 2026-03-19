package verapablodaniel.ToDoApp.service;

import org.springframework.stereotype.Service;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.persistence.repositories.CourtRepository;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;

import java.util.List;

@Service
public class CourtService {

    private final CourtRepository courtRepository;

    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public Court createCourt(CourtCreateDTO dto) {
        Court court = new Court(dto.getName(), dto.getLocation());
        return courtRepository.save(court);
    }

    public List<Court> getCourts() {
        return courtRepository.findAll();
    }
}

