package verapablodaniel.ToDoApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import verapablodaniel.ToDoApp.exceptions.repository.RepositoryException;
import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.persistence.repositories.UserRepository;
import verapablodaniel.ToDoApp.service.dto.UserCreateDTO;
import verapablodaniel.ToDoApp.service.ports.UserServicePort;

@Service
public class UserService implements UserServicePort {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserCreateDTO dto) {
        log.info("Creating user name='{}'", dto.getName());
        User user = new User(dto.getName());
        try {
            return userRepository.save(user);
        } catch (DataAccessException ex) {
            log.error("DB error creating user", ex);
            throw new RepositoryException("DB_ERROR", "Database error while creating user");
        }
    }
}

