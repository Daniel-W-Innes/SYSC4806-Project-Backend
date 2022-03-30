package ca.group20.sysc4806project.exception;

public class SurveyorAlreadyExistsException extends Exception {

    public SurveyorAlreadyExistsException() {
        super();
    }


    public SurveyorAlreadyExistsException(String message) {
        super(message);
    }


    public SurveyorAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
