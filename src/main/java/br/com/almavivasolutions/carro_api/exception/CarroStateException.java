package br.com.almavivasolutions.carro_api.exception;

public class CarroStateException extends CarroException {
	public CarroStateException(String message) {
		super(message);
	}

	public CarroStateException(String message, Throwable cause) {
		super(message, cause);
	}
}
