package br.com.almavivasolutions.carro_api.util.factory;

import java.util.EnumMap;

import br.com.almavivasolutions.carro_api.model.*;
import br.com.almavivasolutions.carro_api.model.enums.*;
import br.com.almavivasolutions.carro_api.model.states.CarroDesligadoState;

public class CarroFactory {

    public static Carro criarCarroPadrao(String modelo, Integer ano) {
        Carro carro = new Carro();
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setLigado(false);
        carro.setVelocidadeAtual(0.0);
        carro.setDistanciaPercorrida(0.0);
        carro.setPeso(800.0);
        carro.setAcelerando(false);
        carro.setEstadoAtual(new CarroDesligadoState());

        carro.setChassi(criarChassi());
        carro.setCarroceria(criarCarroceria());

        return carro;
    }

    private static Chassi criarChassi() {
        Chassi chassi = new Chassi();
        chassi.setEstadoTanque(EstadoTanque.CHEIO);
        chassi.setSistemaEletrico(criarSistemaEletrico());
        chassi.setPneus(criarMapaPneus());
        chassi.setPedais(criarMapaPedais());
        chassi.setMotor(criarMotor());
        return chassi;
    }

    private static SistemaEletrico criarSistemaEletrico() {
        SistemaEletrico sistemaEletrico = new SistemaEletrico();
        sistemaEletrico.setEstadoBateria(EstadoBateria.CARREGADA);
        sistemaEletrico.setFaroisAcesos(false);
        return sistemaEletrico;
    }

    private static EnumMap<LugarPneu, EstadoPneu> criarMapaPneus() {
        EnumMap<LugarPneu, EstadoPneu> mapaPneus = new EnumMap<>(LugarPneu.class);
        for (LugarPneu lugar : LugarPneu.values()) {
            mapaPneus.put(lugar, EstadoPneu.CHEIO);
        }
        return mapaPneus;
    }

    private static EnumMap<TipoPedal, EstadoPedal> criarMapaPedais() {
        EnumMap<TipoPedal, EstadoPedal> mapaPedais = new EnumMap<>(TipoPedal.class);
        for (TipoPedal tipo : TipoPedal.values()) {
            mapaPedais.put(tipo, EstadoPedal.NAO_PRESSIONADO);
        }
        return mapaPedais;
    }

    private static Motor criarMotor() {
        Motor motor = new Motor();
        motor.setTipoMotor(TipoMotor.HIBRIDO);
        motor.setPotencia(150.0); 
        motor.setLigado(false);
        return motor;
    }

    private static Carroceria criarCarroceria() {
        Carroceria carroceria = new Carroceria();
        carroceria.setPortasFechadas(true);
        carroceria.setEstadoVidro(EstadoVidro.LIMPO);
        carroceria.setEstadoRetrovisores(EstadoRetrovisores.ALINHADO);
        carroceria.setBancos(criarMapaBancos());
        return carroceria;
    }

    private static EnumMap<LugarBanco, EstadoBanco> criarMapaBancos() {
        EnumMap<LugarBanco, EstadoBanco> mapaBancos = new EnumMap<>(LugarBanco.class);
        for (LugarBanco lugar : LugarBanco.values()) {
            if (lugar == LugarBanco.MOTORISTA) {
                mapaBancos.put(lugar, EstadoBanco.OCUPADO);
            } else {
                mapaBancos.put(lugar, EstadoBanco.LIVRE);
            }
        }
        return mapaBancos;
    }
}
