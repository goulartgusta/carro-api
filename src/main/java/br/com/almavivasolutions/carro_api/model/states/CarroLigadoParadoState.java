package br.com.almavivasolutions.carro_api.model.states;

import java.time.LocalDateTime;

import br.com.almavivasolutions.carro_api.exception.CarroStateException;
import br.com.almavivasolutions.carro_api.model.Carro;

public class CarroLigadoParadoState implements CarroState {

	@Override
	public void ligar(Carro carro) {
		throw new CarroStateException("O carro já está ligado e parado.");
	}

	@Override
	public void desligar(Carro carro) {
		carro.setLigado(false);
		carro.setEstadoAtual(new CarroDesligadoState());
	}

	@Override
	public void andar(Carro carro) {
		carro.setAcelerando(true);
		carro.setInicioAceleracao(LocalDateTime.now());
		carro.setVelocidadeAtual(10.0);

		carro.setEstadoAtual(new CarroEmMovimentoState());
	}

	@Override
	public void frear(Carro carro, Integer intensidadeFreio) {
		throw new CarroStateException("O carro está parado, não há movimento para frear.");
	}
}
