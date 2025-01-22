package br.com.almavivasolutions.carro_api.service.validator;

import org.springframework.stereotype.Component;

import br.com.almavivasolutions.carro_api.exception.CarroValidationException;
import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.model.enums.*;

@Component
public class CarroValidator {

    public void validarCarroParaLigar(Carro carro) {
        if (Boolean.TRUE.equals(carro.getLigado())) {
            throw new CarroValidationException("O carro já está ligado.");
        }
        validarEstadoBateria(carro.getChassi().getSistemaEletrico().getEstadoBateria(), EstadoBateria.CARREGADA);
        validarEstadoTanque(carro.getChassi().getEstadoTanque(), EstadoTanque.CHEIO);
        validarEstadoBanco(carro, LugarBanco.MOTORISTA, EstadoBanco.OCUPADO);
    }

    public void validarCarroParaDesligar(Carro carro) {
        if (Boolean.FALSE.equals(carro.getLigado())) {
            throw new CarroValidationException("O carro já está desligado.");
        }
        if (Boolean.TRUE.equals(carro.getAcelerando())) {
            throw new CarroValidationException("O carro está em movimento. Pare antes de desligar.");
        }
    }

    public void validarCarroParaAcelerar(Carro carro) {
        if (Boolean.FALSE.equals(carro.getLigado())) {
            throw new CarroValidationException("O carro está desligado. Ligue antes de acelerar.");
        }
        validarEstadoTanque(carro.getChassi().getEstadoTanque(), EstadoTanque.CHEIO);
        validarEstadoPedal(carro, TipoPedal.ACELERADOR, EstadoPedal.PRESSIONADO);
    }

    public void validarCarroParaFrear(Carro carro) {
        if (Boolean.FALSE.equals(carro.getLigado())) {
            throw new CarroValidationException("O carro está desligado. Não é possível frear.");
        }
        validarEstadoPedal(carro, TipoPedal.ACELERADOR, EstadoPedal.NAO_PRESSIONADO);
        validarEstadoPedal(carro, TipoPedal.FREIO, EstadoPedal.PRESSIONADO);
    }

    public void validarCarroParaAndar(Carro carro) {
        if (Boolean.FALSE.equals(carro.getLigado())) {
            throw new CarroValidationException("O carro está desligado. Ligue antes de andar.");
        }
        validarBoolean(carro.getCarroceria().getPortasFechadas(), "As portas do carro devem estar fechadas para andar.");
        validarEstadoVidro(carro.getCarroceria().getEstadoVidro(), EstadoVidro.LIMPO);
        validarEstadoRetrovisores(carro.getCarroceria().getEstadoRetrovisores(), EstadoRetrovisores.ALINHADO);
        validarEstadoBanco(carro, LugarBanco.MOTORISTA, EstadoBanco.OCUPADO);
        validarEstadoPneus(carro);
        validarEstadoPedal(carro, TipoPedal.ACELERADOR, EstadoPedal.PRESSIONADO);
    }

    private void validarEstadoBateria(EstadoBateria estadoAtual, EstadoBateria estadoEsperado) {
        if (estadoAtual == null || estadoAtual != estadoEsperado) {
            throw new CarroValidationException("A bateria do carro não está carregada.");
        }
    }

    private void validarEstadoTanque(EstadoTanque estadoAtual, EstadoTanque estadoEsperado) {
        if (estadoAtual == null || estadoAtual != estadoEsperado) {
            throw new CarroValidationException("O tanque do carro não está cheio.");
        }
    }

    private void validarEstadoVidro(EstadoVidro estadoAtual, EstadoVidro estadoEsperado) {
        if (estadoAtual == null || estadoAtual != estadoEsperado) {
            throw new CarroValidationException("Os vidros devem estar limpos para andar.");
        }
    }

    private void validarEstadoRetrovisores(EstadoRetrovisores estadoAtual, EstadoRetrovisores estadoEsperado) {
        if (estadoAtual == null || estadoAtual != estadoEsperado) {
            throw new CarroValidationException("Os retrovisores devem estar alinhados para andar.");
        }
    }

    private void validarEstadoBanco(Carro carro, LugarBanco lugar, EstadoBanco estadoEsperado) {
        EstadoBanco estadoBanco = carro.getCarroceria().getBancos().get(lugar);
        if (estadoBanco == null || estadoBanco != estadoEsperado) {
            throw new CarroValidationException("O banco do motorista não está ocupado.");
        }
    }

    private void validarEstadoPneus(Carro carro) {
        if (carro.getChassi().getPneus().containsValue(EstadoPneu.VAZIO)) {
            throw new CarroValidationException("Todos os pneus devem estar cheios para andar.");
        }
    }

    private void validarEstadoPedal(Carro carro, TipoPedal tipo, EstadoPedal estadoEsperado) {
        EstadoPedal estadoPedal = carro.getChassi().getPedais().get(tipo);
        if (estadoPedal == null || estadoPedal != estadoEsperado) {
            throw new CarroValidationException("O estado do pedal " + tipo + " não é válido.");
        }
    }

    private void validarBoolean(Boolean valor, String mensagemErro) {
        if (valor == null || !valor) {
            throw new CarroValidationException(mensagemErro);
        }
    }
}
