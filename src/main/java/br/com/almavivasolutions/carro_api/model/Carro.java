package br.com.almavivasolutions.carro_api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.almavivasolutions.carro_api.model.states.CarroState;

public class Carro {
    private Boolean ligado;
    private String modelo;
    private Integer ano;
    private Double velocidadeAtual;  // m/s
    private Double distanciaPercorrida;  // em metros
    private Double peso;  // em kg
    private Boolean acelerando;
    
    @JsonIgnore
    private LocalDateTime inicioAceleracao;
    private Chassi chassi;
    private Carroceria carroceria;

    @JsonIgnore
    private CarroState estadoAtual;

    public void adicionarDistancia(Double metros) {
        if (distanciaPercorrida == null) {
            distanciaPercorrida = 0.0;
        }
        distanciaPercorrida += metros;
    }
    
    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(Double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public Double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(Double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getAcelerando() {
        return acelerando;
    }

    public void setAcelerando(Boolean acelerando) {
        this.acelerando = acelerando;
    }

    public LocalDateTime getInicioAceleracao() {
        return inicioAceleracao;
    }

    public void setInicioAceleracao(LocalDateTime inicioAceleracao) {
        this.inicioAceleracao = inicioAceleracao;
    }

    public Chassi getChassi() {
        return chassi;
    }

    public void setChassi(Chassi chassi) {
        this.chassi = chassi;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public CarroState getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(CarroState estadoAtual) {
        this.estadoAtual = estadoAtual;
    }
}
