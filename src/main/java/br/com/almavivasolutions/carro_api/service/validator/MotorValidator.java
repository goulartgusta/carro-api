package br.com.almavivasolutions.carro_api.service.validator;

import org.springframework.stereotype.Component;

import br.com.almavivasolutions.carro_api.exception.MotorValidationException;
import br.com.almavivasolutions.carro_api.model.enums.TipoMotor;

@Component
public class MotorValidator {

    public void validarTipoMotor(TipoMotor tipoMotor) {
        if (tipoMotor == null) {
            throw new MotorValidationException("O tipo do motor não pode ser nulo.");
        }
    }

    public void validarPotencia(Double potencia) {
        if (potencia == null) {
            throw new MotorValidationException("A potência do motor não pode ser nula.");
        }
        if (potencia <= 0) {
            throw new MotorValidationException("A potência do motor deve ser maior que zero.");
        }
    }

    public void validarEstadoLigado(Boolean ligado) {
        if (ligado == null) {
            throw new MotorValidationException("O estado ligado do motor não pode ser nulo.");
        }
    }
}
