package br.com.almavivasolutions.carro_api.model;

import br.com.almavivasolutions.carro_api.model.enums.TipoMotor;

public class Motor {
    private TipoMotor tipoMotor;
    private Double potencia;  
    private Boolean ligado;

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }
}
