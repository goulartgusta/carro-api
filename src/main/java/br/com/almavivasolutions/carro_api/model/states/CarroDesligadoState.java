package br.com.almavivasolutions.carro_api.model.states;

import br.com.almavivasolutions.carro_api.exception.CarroStateException;
import br.com.almavivasolutions.carro_api.model.Carro;

public class CarroDesligadoState implements CarroState {

    @Override
    public void ligar(Carro carro) {
        if (Boolean.TRUE.equals(carro.getLigado())) {
            throw new CarroStateException("O carro já está ligado.");
        }
        carro.setLigado(true);
        carro.setEstadoAtual(new CarroLigadoParadoState());
    }

    @Override
    public void desligar(Carro carro) {
        throw new CarroStateException("O carro já está desligado.");
    }

    @Override
    public void andar(Carro carro) {
        throw new CarroStateException("Não pode andar com o carro desligado.");
    }

    @Override
    public void frear(Carro carro, Integer intensidadeFreio) {
        throw new CarroStateException("Não pode frear com o carro desligado.");
    }
}
