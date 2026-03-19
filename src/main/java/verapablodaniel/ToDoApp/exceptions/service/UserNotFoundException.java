package verapablodaniel.ToDoApp.exceptions.service;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String message) {
        super("USER_NOT_FOUND", message);
    }
}

