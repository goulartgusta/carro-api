package br.com.almavivasolutions.carro_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.model.enums.TipoMotor;
import br.com.almavivasolutions.carro_api.repository.CarroRepository;
import br.com.almavivasolutions.carro_api.service.validator.MotorValidator;

@Service
public class MotorService {

    private static final Logger Log = LogManager.getLogger(MotorService.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotorValidator motorValidator;

    public TipoMotor buscarTipoMotor() {
        Log.info("Buscando tipo do motor.");
        TipoMotor tipoMotor = carroRepository.getCarro().getChassi().getMotor().getTipoMotor();
        Log.debug("Tipo do motor obtido: {}.", tipoMotor);
        return tipoMotor;
    }

    public void atualizarTipoMotor(TipoMotor tipo) {
        Log.info("Atualizando tipo do motor para {}.", tipo);
        Carro carro = carroRepository.getCarro();
        motorValidator.validarTipoMotor(tipo);
        carro.getChassi().getMotor().setTipoMotor(tipo);
        carroRepository.salvarCarro(carro);
        Log.debug("Tipo do motor atualizado com sucesso.");
    }

    public Double buscarPotencia() {
        Log.info("Buscando potência do motor.");
        Double potencia = carroRepository.getCarro().getChassi().getMotor().getPotencia();
        Log.debug("Potência do motor obtida: {}.", potencia);
        return potencia;
    }

    public void atualizarPotencia(Double potencia) {
        Log.info("Atualizando potência do motor para {}.", potencia);
        Carro carro = carroRepository.getCarro();
        motorValidator.validarPotencia(potencia);
        carro.getChassi().getMotor().setPotencia(potencia);
        carroRepository.salvarCarro(carro);
        Log.debug("Potência do motor atualizada com sucesso.");
    }

    public Boolean buscarEstadoLigado() {
        Log.info("Buscando estado ligado do motor.");
        Boolean ligado = carroRepository.getCarro().getChassi().getMotor().getLigado();
        Log.debug("Estado ligado do motor obtido: {}.", ligado);
        return ligado;
    }

    public void atualizarEstadoLigado(Boolean ligado) {
        Log.info("Atualizando estado ligado do motor para {}.", ligado);
        Carro carro = carroRepository.getCarro();
        motorValidator.validarEstadoLigado(ligado);
        carro.getChassi().getMotor().setLigado(ligado);
        carroRepository.salvarCarro(carro);
        Log.debug("Estado ligado do motor atualizado com sucesso.");
    }
}
