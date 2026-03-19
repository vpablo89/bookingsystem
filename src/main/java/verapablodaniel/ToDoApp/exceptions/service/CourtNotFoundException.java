package verapablodaniel.ToDoApp.exceptions.service;

public class CourtNotFoundException extends EntityNotFoundException {
    public CourtNotFoundException(String message) {
        super("COURT_NOT_FOUND", message);
    }
}

