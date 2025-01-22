package br.com.almavivasolutions.carro_api.model;

import br.com.almavivasolutions.carro_api.model.enums.EstadoBateria;

public class SistemaEletrico {
	private EstadoBateria estadoBateria;
	private Boolean faroisAcesos;

	public EstadoBateria getEstadoBateria() {
		return estadoBateria;
	}

	public void setEstadoBateria(EstadoBateria estadoBateria) {
		this.estadoBateria = estadoBateria;
	}

	public Boolean getFaroisAcesos() {
		return faroisAcesos;
	}

	public void setFaroisAcesos(Boolean faroisAcesos) {
		this.faroisAcesos = faroisAcesos;
	}

}
