package verapablodaniel.ToDoApp.exceptions.controller;

import org.springframework.http.HttpStatus;
import verapablodaniel.ToDoApp.exceptions.ApiException;

public class BadRequestException extends ApiException {

    public BadRequestException(String code, String message) {
        super(code, HttpStatus.BAD_REQUEST, message);
    }
}

