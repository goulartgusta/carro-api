package br.com.almavivasolutions.carro_api.exception;

public class ChassiValidationException extends RuntimeException {
    public ChassiValidationException(String message) {
        super(message);
    }

    public ChassiValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
