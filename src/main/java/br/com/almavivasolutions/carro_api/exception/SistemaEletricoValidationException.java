package br.com.almavivasolutions.carro_api.exception;

public class SistemaEletricoValidationException extends RuntimeException {
    public SistemaEletricoValidationException(String message) {
        super(message);
    }

    public SistemaEletricoValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
