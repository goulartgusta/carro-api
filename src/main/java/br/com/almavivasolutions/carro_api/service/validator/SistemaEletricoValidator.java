package br.com.almavivasolutions.carro_api.service.validator;

import org.springframework.stereotype.Component;

import br.com.almavivasolutions.carro_api.exception.SistemaEletricoValidationException;
import br.com.almavivasolutions.carro_api.model.enums.EstadoBateria;

@Component
public class SistemaEletricoValidator {

    public void validarEstadoFarois(Boolean aceso) {
        if (aceso == null) {
            throw new SistemaEletricoValidationException("O estado dos faróis não pode ser nulo.");
        }
    }

    public void validarEstadoBateria(EstadoBateria estado) {
        if (estado == null) {
            throw new SistemaEletricoValidationException("O estado da bateria não pode ser nulo.");
        }
        if (estado != EstadoBateria.CARREGADA && estado != EstadoBateria.DESCARREGADA) {
            throw new SistemaEletricoValidationException("Estado da bateria inválido.");
        }
    }
}
