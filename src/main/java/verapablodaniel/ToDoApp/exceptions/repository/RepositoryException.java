package verapablodaniel.ToDoApp.exceptions.repository;

import org.springframework.http.HttpStatus;
import verapablodaniel.ToDoApp.exceptions.ApiException;

public class RepositoryException extends ApiException {

    public RepositoryException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}

