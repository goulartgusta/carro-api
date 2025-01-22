package br.com.almavivasolutions.carro_api.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.almavivasolutions.carro_api.exception.FileOperationException;
import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.util.factory.CarroFactory;

@Repository
public class CarroRepository {

    private static final String JSON_FILE = "src/main/resources/arquivos/carro.json";
    private static final String TXT_FILE = "src/main/resources/arquivos/carro_estado.txt";

    private Carro carro;

    public CarroRepository() {
        this.carro = CarroFactory.criarCarroPadrao("Fusca", 1980);
    }

    public Carro getCarro() {
        return carro;
    }

    public void salvarCarro(Carro carroSalvo) {
        this.carro = carroSalvo;
        salvarJson();
        salvarTxt();
    }

    private void salvarJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE), carro);
        } catch (IOException e) {
            throw new FileOperationException("Erro ao salvar JSON do carro.");
        }
    }

    private void salvarTxt() {
        try (FileWriter fw = new FileWriter(TXT_FILE)) {
            fw.write("Estado do Carro:\n");
            fw.write("Ligado: " + carro.getLigado() + "\n");
            fw.write("Modelo: " + carro.getModelo() + "\n");
            fw.write("Ano: " + carro.getAno() + "\n");
            fw.write("Velocidade Atual: " + carro.getVelocidadeAtual() + "\n");
            fw.write("Distância Percorrida: " + carro.getDistanciaPercorrida() + "\n");
            fw.write("Acelerando: " + carro.getAcelerando() + "\n");
            fw.write("Inicio da Corrida: " + carro.getInicioAceleracao() + "\n");
            fw.write("Estado Interno (State): " + carro.getEstadoAtual().getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            throw new FileOperationException("Erro ao salvar TXT do carro.");
        }
    }

}
