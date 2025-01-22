package br.com.almavivasolutions.carro_api.exception;

public class MotorValidationException extends RuntimeException {
    public MotorValidationException(String message) {
        super(message);
    }

    public MotorValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
