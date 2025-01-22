package br.com.almavivasolutions.carro_api.model.states;

import java.time.Duration;
import java.time.LocalDateTime;

import br.com.almavivasolutions.carro_api.exception.CarroStateException;
import br.com.almavivasolutions.carro_api.model.Carro;

public class CarroEmMovimentoState implements CarroState {

    @Override
    public void ligar(Carro carro) {
        throw new CarroStateException("O carro já está em movimento (portanto ligado).");
    }

    @Override
    public void desligar(Carro carro) {
        throw new CarroStateException("Não pode desligar o carro em movimento!");
    }

    @Override
    public void andar(Carro carro) {
        if (Boolean.TRUE.equals(carro.getAcelerando()) && carro.getInicioAceleracao() != null) {
            long segDecorridos = Duration.between(carro.getInicioAceleracao(), LocalDateTime.now()).getSeconds();
            double distancia = carro.getVelocidadeAtual() * segDecorridos;
            carro.adicionarDistancia(distancia);
        }
        carro.setInicioAceleracao(LocalDateTime.now());
        carro.setAcelerando(true);
    }

    @Override
    public void frear(Carro carro, Integer forcaDoFreio) {
        if (Boolean.TRUE.equals(carro.getAcelerando()) && carro.getInicioAceleracao() != null) {
            long segDecorridos = Duration.between(carro.getInicioAceleracao(), LocalDateTime.now()).getSeconds();
            double distancia = carro.getVelocidadeAtual() * segDecorridos;
            carro.adicionarDistancia(distancia);
        }

        if (forcaDoFreio > 5) {
            carro.setVelocidadeAtual(0.0);
            carro.setAcelerando(false);
            carro.setInicioAceleracao(null);
            carro.setEstadoAtual(new CarroLigadoParadoState());
        } else {
            carro.setVelocidadeAtual(5.0);
            carro.setInicioAceleracao(LocalDateTime.now());
        }
    }
}
