package verapablodaniel.ToDoApp.exceptions.service;

import org.springframework.http.HttpStatus;
import verapablodaniel.ToDoApp.exceptions.ApiException;

public class InvalidReservationException extends ApiException {

    public InvalidReservationException(String code, String message) {
        super(code, HttpStatus.BAD_REQUEST, message);
    }
}

