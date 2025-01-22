package br.com.almavivasolutions.carro_api.model;

import java.util.Map;

import br.com.almavivasolutions.carro_api.model.enums.EstadoRetrovisores;
import br.com.almavivasolutions.carro_api.model.enums.EstadoVidro;
import br.com.almavivasolutions.carro_api.model.enums.EstadoBanco;
import br.com.almavivasolutions.carro_api.model.enums.LugarBanco;

public class Carroceria {

    private Boolean portasFechadas;
    private EstadoVidro estadoVidro;
    private EstadoRetrovisores estadoRetrovisores;
    private Map<LugarBanco, EstadoBanco> bancos;

    public Boolean getPortasFechadas() {
        return portasFechadas;
    }

    public void setPortasFechadas(Boolean portasFechadas) {
        this.portasFechadas = portasFechadas;
    }

    public EstadoVidro getEstadoVidro() {
        return estadoVidro;
    }

    public void setEstadoVidro(EstadoVidro estadoVidro) {
        this.estadoVidro = estadoVidro;
    }

    public EstadoRetrovisores getEstadoRetrovisores() {
        return estadoRetrovisores;
    }

    public void setEstadoRetrovisores(EstadoRetrovisores estadoRetrovisores) {
        this.estadoRetrovisores = estadoRetrovisores;
    }

    public Map<LugarBanco, EstadoBanco> getBancos() {
        return bancos;
    }

    public void setBancos(Map<LugarBanco, EstadoBanco> bancos) {
        this.bancos = bancos;
    }
}
