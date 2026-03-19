package verapablodaniel.ToDoApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import verapablodaniel.ToDoApp.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

