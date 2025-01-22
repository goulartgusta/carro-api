package br.com.almavivasolutions.carro_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CarroValidationException.class)
	public ResponseEntity<ErroDetalhado> handleCarroValidationException(CarroValidationException e) {
		ErroDetalhado erro = new ErroDetalhado(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(CarroStateException.class)
	public ResponseEntity<ErroDetalhado> handleCarroStateException(CarroStateException e) {
		ErroDetalhado erro = new ErroDetalhado(e.getMessage(), HttpStatus.CONFLICT.value());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(FileOperationException.class)
	public ResponseEntity<ErroDetalhado> handleCarroException(FileOperationException e) {
		ErroDetalhado erro = new ErroDetalhado("Erro genérico no carro: " + e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}

	@ExceptionHandler(CarroException.class)
	public ResponseEntity<ErroDetalhado> handleCarroException(CarroException e) {
		ErroDetalhado erro = new ErroDetalhado("Erro genérico no carro: " + e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}

}
