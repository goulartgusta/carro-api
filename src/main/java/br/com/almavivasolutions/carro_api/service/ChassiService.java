package br.com.almavivasolutions.carro_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPedal;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPneu;
import br.com.almavivasolutions.carro_api.model.enums.EstadoTanque;
import br.com.almavivasolutions.carro_api.model.enums.LugarPneu;
import br.com.almavivasolutions.carro_api.model.enums.TipoPedal;
import br.com.almavivasolutions.carro_api.repository.CarroRepository;
import br.com.almavivasolutions.carro_api.service.validator.ChassiValidator;

@Service
public class ChassiService {

    private static final Logger Log = LogManager.getLogger(ChassiService.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ChassiValidator chassiValidator;

    public EstadoTanque buscarEstadoTanque() {
        Log.info("Buscando estado do tanque.");
        EstadoTanque estadoTanque = carroRepository.getCarro().getChassi().getEstadoTanque();
        Log.debug("Estado do tanque obtido: {}.", estadoTanque);
        return estadoTanque;
    }

    public void atualizarEstadoTanque(EstadoTanque estadoTanque) {
        Log.info("Atualizando estado do tanque para: {}.", estadoTanque);
        chassiValidator.validarEstadoTanque(estadoTanque);
        Carro carro = carroRepository.getCarro();
        carro.getChassi().setEstadoTanque(estadoTanque);
        carroRepository.salvarCarro(carro);
        Log.debug("Estado do tanque atualizado com sucesso para: {}.", estadoTanque);
    }

    public EstadoPneu buscarEstadoPneu(LugarPneu lugar) {
        Log.info("Buscando estado do pneu no lugar: {}.", lugar);
        Carro carro = carroRepository.getCarro();
        EstadoPneu estadoPneu = carro.getChassi().getPneus().get(lugar);
        Log.debug("Estado do pneu no lugar {} obtido: {}.", lugar, estadoPneu);
        return estadoPneu;
    }

    public void atualizarEstadoPneu(LugarPneu lugar, EstadoPneu estadoPneu) {
        Log.info("Atualizando estado do pneu no lugar {} para: {}.", lugar, estadoPneu);
        Carro carro = carroRepository.getCarro();
        chassiValidator.validarEstadoPneu(carro.getChassi(), lugar, estadoPneu);
        carro.getChassi().getPneus().put(lugar, estadoPneu);
        carroRepository.salvarCarro(carro);
        Log.debug("Estado do pneu no lugar {} atualizado com sucesso para: {}.", lugar, estadoPneu);
    }

    public EstadoPedal buscarEstadoPedal(TipoPedal tipo) {
        Log.info("Buscando estado do pedal do tipo: {}.", tipo);
        Carro carro = carroRepository.getCarro();
        EstadoPedal estadoPedal = carro.getChassi().getPedais().get(tipo);
        Log.debug("Estado do pedal do tipo {} obtido: {}.", tipo, estadoPedal);
        return estadoPedal;
    }

    public void atualizarEstadoPedal(TipoPedal tipo, EstadoPedal estadoPedal) {
        Log.info("Atualizando estado do pedal do tipo {} para: {}.", tipo, estadoPedal);
        Carro carro = carroRepository.getCarro();
        chassiValidator.validarEstadoPedal(carro.getChassi(), tipo, estadoPedal);
        carro.getChassi().getPedais().put(tipo, estadoPedal);
        carroRepository.salvarCarro(carro);
        Log.debug("Estado do pedal do tipo {} atualizado com sucesso para: {}.", tipo, estadoPedal);
    }
}
