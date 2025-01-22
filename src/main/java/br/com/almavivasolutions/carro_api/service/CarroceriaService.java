package br.com.almavivasolutions.carro_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.almavivasolutions.carro_api.model.enums.EstadoBanco;
import br.com.almavivasolutions.carro_api.model.enums.EstadoRetrovisores;
import br.com.almavivasolutions.carro_api.model.enums.EstadoVidro;
import br.com.almavivasolutions.carro_api.model.enums.LugarBanco;
import br.com.almavivasolutions.carro_api.repository.CarroRepository;
import br.com.almavivasolutions.carro_api.service.validator.CarroceriaValidator;

@Service
public class CarroceriaService {

    private static final Logger Log = LogManager.getLogger(CarroceriaService.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroceriaValidator carroceriaValidator;

    public EstadoRetrovisores buscarEstadoRetrovisores() {
        Log.info("Buscando estado dos retrovisores.");
        return carroRepository.getCarro().getCarroceria().getEstadoRetrovisores();
    }

    public void atualizarEstadoRetrovisores(EstadoRetrovisores estado) {
        Log.info("Atualizando estado dos retrovisores para {}.", estado);
        carroceriaValidator.validarEstadoRetrovisores(estado);
        carroRepository.getCarro().getCarroceria().setEstadoRetrovisores(estado);
        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado dos retrovisores atualizado com sucesso.");
    }

    public EstadoVidro buscarEstadoVidro() {
        Log.info("Buscando estado do vidro.");
        return carroRepository.getCarro().getCarroceria().getEstadoVidro();
    }

    public void atualizarEstadoVidro(EstadoVidro estado) {
        Log.info("Atualizando estado do vidro para {}.", estado);
        carroceriaValidator.validarEstadoVidro(estado);
        carroRepository.getCarro().getCarroceria().setEstadoVidro(estado);
        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado do vidro atualizado com sucesso.");
    }

    public Boolean buscarPortasFechadas() {
        Log.info("Buscando estado das portas.");
        return carroRepository.getCarro().getCarroceria().getPortasFechadas();
    }

    public void atualizarPortasFechadas(Boolean estado) {
        Log.info("Atualizando estado das portas para {}.", estado);
        carroceriaValidator.validarPortasFechadas(estado);
        carroRepository.getCarro().getCarroceria().setPortasFechadas(estado);
        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado das portas atualizado com sucesso.");
    }

    public EstadoBanco buscarEstadoBanco(LugarBanco lugar) {
        Log.info("Buscando estado do banco no lugar {}.", lugar);
        return carroRepository.getCarro().getCarroceria().getBancos().get(lugar);
    }

    public void atualizarEstadoBanco(LugarBanco lugar, EstadoBanco estado) {
        Log.info("Atualizando estado do banco no lugar {} para {}.", lugar, estado);
        carroceriaValidator.validarEstadoBanco(lugar, estado);
        carroRepository.getCarro().getCarroceria().getBancos().put(lugar, estado);
        carroRepository.salvarCarro(carroRepository.getCarro());
        Log.debug("Estado do banco atualizado com sucesso no lugar {}.", lugar);
    }
}
