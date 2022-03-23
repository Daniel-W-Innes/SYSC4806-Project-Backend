package ca.group20.sysc4806project.exception;

public class InvalidRoleException extends Exception {

    public InvalidRoleException() {
        super();
    }


    public InvalidRoleException(String message) {
        super(message);
    }


    public InvalidRoleException(String message, Throwable cause) {
        super(message, cause);
    }

}
