package kz.petsclinic.clinic.exception;

/**
 * Реализует свой класс исключений
 * наследуется от Exception
 */
public class UserException extends Exception {
    public UserException(final String message) {
        super(message);
    }

}
