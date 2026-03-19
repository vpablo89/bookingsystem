package verapablodaniel.ToDoApp.service.ports;

import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;

import java.util.List;

public interface CourtServicePort {
    Court createCourt(CourtCreateDTO dto);

    List<Court> getCourts();
}

