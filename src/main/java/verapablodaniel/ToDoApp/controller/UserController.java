package verapablodaniel.ToDoApp.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import verapablodaniel.ToDoApp.persistence.entities.User;
import verapablodaniel.ToDoApp.service.UserService;
import verapablodaniel.ToDoApp.service.dto.UserCreateDTO;
import verapablodaniel.ToDoApp.service.ports.UserServicePort;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserServicePort userService;

    public UserController(UserServicePort userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDTO dto) {
        log.debug("POST /users");
        User created = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

