package br.com.almavivasolutions.carro_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almavivasolutions.carro_api.model.SistemaEletrico;
import br.com.almavivasolutions.carro_api.model.enums.EstadoBateria;
import br.com.almavivasolutions.carro_api.repository.CarroRepository;
import br.com.almavivasolutions.carro_api.service.validator.SistemaEletricoValidator;

@Service
public class SistemaEletricoService {

    private static final Logger Log = LogManager.getLogger(SistemaEletricoService.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private SistemaEletricoValidator sistemaEletricoValidator;

    public Boolean buscarEstadoFarois() {
        Log.info("Recebida requisição para buscar estado dos faróis.");
        SistemaEletrico sistemaEletrico = carroRepository.getCarro().getChassi().getSistemaEletrico();
        Boolean estado = sistemaEletrico.getFaroisAcesos();
        Log.debug("Estado dos faróis buscado com sucesso: {}.", estado);
        return estado;
    }

    public void atualizarEstadoFarois(Boolean aceso) {
        Log.info("Recebida requisição para atualizar estado dos faróis para aceso={}.", aceso);
        sistemaEletricoValidator.validarEstadoFarois(aceso);

        SistemaEletrico sistemaEletrico = carroRepository.getCarro().getChassi().getSistemaEletrico();
        sistemaEletrico.setFaroisAcesos(aceso);

        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado dos faróis atualizado com sucesso para aceso={}.", aceso);
    }

    public EstadoBateria buscarEstadoBateria() {
        Log.info("Recebida requisição para buscar estado da bateria.");
        SistemaEletrico sistemaEletrico = carroRepository.getCarro().getChassi().getSistemaEletrico();
        EstadoBateria estado = sistemaEletrico.getEstadoBateria();
        Log.debug("Estado da bateria buscado com sucesso: {}.", estado);
        return estado;
    }

    public void atualizarEstadoBateria(EstadoBateria estado) {
        Log.info("Recebida requisição para atualizar estado da bateria para {}.", estado);
        sistemaEletricoValidator.validarEstadoBateria(estado);

        SistemaEletrico sistemaEletrico = carroRepository.getCarro().getChassi().getSistemaEletrico();
        sistemaEletrico.setEstadoBateria(estado);

        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado da bateria atualizado com sucesso para {}.", estado);
    }
}
