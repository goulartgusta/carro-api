package br.com.almavivasolutions.carro_api.exception;

public class CarroException extends RuntimeException{
    public CarroException(String message) {
        super(message);
    }

    public CarroException(String message, Throwable cause) {
        super(message, cause);
    }
}
