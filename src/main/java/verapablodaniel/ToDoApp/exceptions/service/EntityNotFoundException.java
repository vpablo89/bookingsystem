package verapablodaniel.ToDoApp.exceptions.service;

import org.springframework.http.HttpStatus;
import verapablodaniel.ToDoApp.exceptions.ApiException;

public class EntityNotFoundException extends ApiException {

    public EntityNotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND, message);
    }
}

