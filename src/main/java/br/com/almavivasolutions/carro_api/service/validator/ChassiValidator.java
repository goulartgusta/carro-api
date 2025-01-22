package br.com.almavivasolutions.carro_api.service.validator;

import org.springframework.stereotype.Component;

import br.com.almavivasolutions.carro_api.exception.ChassiValidationException;
import br.com.almavivasolutions.carro_api.model.Chassi;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPedal;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPneu;
import br.com.almavivasolutions.carro_api.model.enums.EstadoTanque;
import br.com.almavivasolutions.carro_api.model.enums.LugarPneu;
import br.com.almavivasolutions.carro_api.model.enums.TipoPedal;

@Component
public class ChassiValidator {

    public void validarEstadoTanque(EstadoTanque estadoTanque) {
        if (estadoTanque == null) {
            throw new ChassiValidationException("O estado do tanque não pode ser nulo.");
        }
    }

    public void validarEstadoPneu(Chassi chassi, LugarPneu lugar, EstadoPneu estadoPneu) {
        if (lugar == null) {
            throw new ChassiValidationException("O lugar do pneu não pode ser nulo.");
        }
        if (estadoPneu == null) {
            throw new ChassiValidationException("O estado do pneu não pode ser nulo.");
        }
    }

    public void validarEstadoPedal(Chassi chassi, TipoPedal tipo, EstadoPedal estadoPedal) {
        if (tipo == null) {
            throw new ChassiValidationException("O tipo de pedal não pode ser nulo.");
        }
        if (estadoPedal == null) {
            throw new ChassiValidationException("O estado do pedal não pode ser nulo.");
        }
    }
}
