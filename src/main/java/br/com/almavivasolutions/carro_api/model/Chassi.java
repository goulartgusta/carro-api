package br.com.almavivasolutions.carro_api.model;

import java.util.Map;

import br.com.almavivasolutions.carro_api.model.enums.EstadoPedal;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPneu;
import br.com.almavivasolutions.carro_api.model.enums.EstadoTanque;
import br.com.almavivasolutions.carro_api.model.enums.LugarPneu;
import br.com.almavivasolutions.carro_api.model.enums.TipoPedal;

public class Chassi {

	private EstadoTanque estadoTanque;
	private Motor motor;
	private SistemaEletrico sistemaEletrico;

	private Map<LugarPneu, EstadoPneu> pneus;

	private Map<TipoPedal, EstadoPedal> pedais;

	public EstadoTanque getEstadoTanque() {
		return estadoTanque;
	}

	public void setEstadoTanque(EstadoTanque estadoTanque) {
		this.estadoTanque = estadoTanque;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public SistemaEletrico getSistemaEletrico() {
		return sistemaEletrico;
	}

	public void setSistemaEletrico(SistemaEletrico sistemaEletrico) {
		this.sistemaEletrico = sistemaEletrico;
	}

	public Map<LugarPneu, EstadoPneu> getPneus() {
		return pneus;
	}

	public void setPneus(Map<LugarPneu, EstadoPneu> pneus) {
		this.pneus = pneus;
	}

	public Map<TipoPedal, EstadoPedal> getPedais() {
		return pedais;
	}

	public void setPedais(Map<TipoPedal, EstadoPedal> pedais) {
		this.pedais = pedais;
	}
}
