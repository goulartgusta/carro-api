package br.com.almavivasolutions.carro_api.exception;

public class CarroValidationException extends CarroException {

    public CarroValidationException(String message) {
        super(message);
    }

    public CarroValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
