package br.com.almavivasolutions.carro_api.service.validator;

import org.springframework.stereotype.Component;

import br.com.almavivasolutions.carro_api.exception.CarroValidationException;
import br.com.almavivasolutions.carro_api.model.enums.EstadoBanco;
import br.com.almavivasolutions.carro_api.model.enums.EstadoRetrovisores;
import br.com.almavivasolutions.carro_api.model.enums.EstadoVidro;
import br.com.almavivasolutions.carro_api.model.enums.LugarBanco;

@Component
public class CarroceriaValidator {

    public void validarEstadoRetrovisores(EstadoRetrovisores estado) {
        if (estado == null) {
            throw new CarroValidationException("O estado dos retrovisores não pode ser nulo.");
        }
    }

    public void validarEstadoVidro(EstadoVidro estado) {
        if (estado == null) {
            throw new CarroValidationException("O estado do vidro não pode ser nulo.");
        }
    }

    public void validarPortasFechadas(Boolean estado) {
        if (estado == null) {
            throw new CarroValidationException("O estado das portas não pode ser nulo.");
        }
    }

    public void validarEstadoBanco(LugarBanco lugar, EstadoBanco estado) {
        if (lugar == null || estado == null) {
            throw new CarroValidationException("Lugar ou estado do banco não podem ser nulos.");
        }
    }
}
