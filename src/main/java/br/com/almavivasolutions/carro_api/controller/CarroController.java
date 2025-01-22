package br.com.almavivasolutions.carro_api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.almavivasolutions.carro_api.model.Carro;
import br.com.almavivasolutions.carro_api.model.Carroceria;
import br.com.almavivasolutions.carro_api.model.Chassi;
import br.com.almavivasolutions.carro_api.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    private static final Logger Log = LogManager.getLogger(CarroController.class);

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<Carro> buscarCarro() {
        Log.info("Recebida requisição para buscar informações do carro.");
        Carro carro = carroService.buscarCarro();
        return ResponseEntity.ok(carro);
    }

    @PutMapping("/ligar")
    public ResponseEntity<String> ligarCarro() {
        Log.info("Recebida requisição para ligar o carro.");
        carroService.ligarCarro();
        return ResponseEntity.ok("Carro ligado com sucesso!");
    }

    @PutMapping("/desligar")
    public ResponseEntity<String> desligarCarro() {
        Log.info("Recebida requisição para desligar o carro.");
        carroService.desligarCarro();
        return ResponseEntity.ok("Carro Desligado com sucesso.");
    }

    @PutMapping("/acelerar")
    public ResponseEntity<String> acelerarCarro() {
        Log.info("Recebida requisição para acelerar o carro.");
        carroService.acelerarCarro();
        return ResponseEntity.ok("Carro acelerando com sucesso.");
    }

    @PutMapping("/frear/{forcaDoFreio}")
    public ResponseEntity<String> frearCarro(@PathVariable Integer forcaDoFreio) {
        Log.info("Recebida requisição para frear o carro com intensidade {}.", forcaDoFreio);
        carroService.frearCarro(forcaDoFreio);
        return ResponseEntity.ok("Carro freou com sucesso.");
    }
}
