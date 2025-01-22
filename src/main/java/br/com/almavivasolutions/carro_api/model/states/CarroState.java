package br.com.almavivasolutions.carro_api.model.states;

import br.com.almavivasolutions.carro_api.model.Carro;

public interface CarroState {
    void ligar(Carro carro);
    void desligar(Carro carro);
    void andar(Carro carro);
    void frear(Carro carro, Integer intensidadeFreio);
}
