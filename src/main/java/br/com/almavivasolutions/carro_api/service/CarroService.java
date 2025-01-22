package br.com.almavivasolutions.carro_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.model.states.CarroState;
import br.com.almavivasolutions.carro_api.repository.CarroRepository;
import br.com.almavivasolutions.carro_api.service.validator.CarroValidator;

@Service
public class CarroService {

    private static final Logger Log = LogManager.getLogger(CarroService.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroValidator carroValidator;

    public Carro buscarCarro() {
        Log.info("Buscando informações do carro.");
        Carro carro = carroRepository.getCarro();
        Log.debug("Informações do carro obtidas com sucesso.");
        return carro;
    }

    public void ligarCarro() {
        Log.info("Tentando ligar o carro.");
        Carro carro = carroRepository.getCarro();
        carroValidator.validarCarroParaLigar(carro);
        CarroState estadoAtual = carro.getEstadoAtual();
        estadoAtual.ligar(carro);
        carroRepository.salvarCarro(carro);
        Log.debug("Carro ligado com sucesso.");
    }

    public void desligarCarro() {
        Log.info("Tentando desligar o carro.");
        Carro carro = carroRepository.getCarro();
        carroValidator.validarCarroParaDesligar(carro);
        CarroState estadoAtual = carro.getEstadoAtual();
        estadoAtual.desligar(carro);
        carroRepository.salvarCarro(carro);
        Log.debug("Carro desligado com sucesso.");
    }

    public void acelerarCarro() {
        Log.info("Tentando acelerar o carro.");
        Carro carro = carroRepository.getCarro();
        carroValidator.validarCarroParaAcelerar(carro);
        CarroState estadoAtual = carro.getEstadoAtual();
        estadoAtual.andar(carro);
        carroRepository.salvarCarro(carro);
        Log.debug("Carro acelerado com sucesso.");
    }

    public void frearCarro(Integer intensidadeFreio) {
        Log.info("Tentando frear o carro com intensidade {}.", intensidadeFreio);
        Carro carro = carroRepository.getCarro();
        carroValidator.validarCarroParaFrear(carro);
        CarroState estadoAtual = carro.getEstadoAtual();
        estadoAtual.frear(carro, intensidadeFreio);
        carroRepository.salvarCarro(carro);
        Log.debug("Carro freado com sucesso.");
    }
}
