package br.com.almavivasolutions.carro_api.exception;

public class CarroceriaValidationException extends RuntimeException{
    public CarroceriaValidationException(String message) {
        super(message);
    }

    public CarroceriaValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
