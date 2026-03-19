package verapablodaniel.ToDoApp.service.ports;

import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.service.dto.UserCreateDTO;

public interface UserServicePort {
    User createUser(UserCreateDTO dto);
}

