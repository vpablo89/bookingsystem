package verapablodaniel.ToDoApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import verapablodaniel.ToDoApp.persistence.entities.Court;

public interface CourtRepository extends JpaRepository<Court, Long> {
}

