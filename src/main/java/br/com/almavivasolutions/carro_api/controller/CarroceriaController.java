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

import br.com.almavivasolutions.carro_api.model.enums.EstadoBanco;
import br.com.almavivasolutions.carro_api.model.enums.EstadoRetrovisores;
import br.com.almavivasolutions.carro_api.model.enums.EstadoVidro;
import br.com.almavivasolutions.carro_api.model.enums.LugarBanco;
import br.com.almavivasolutions.carro_api.service.CarroceriaService;

@RestController
@RequestMapping("/api/carro/carroceria")
public class CarroceriaController {

    private static final Logger Log = LogManager.getLogger(CarroceriaController.class);

    @Autowired
    private CarroceriaService carroceriaService;

    @GetMapping("/estado-retrovisores")
    public ResponseEntity<EstadoRetrovisores> buscarEstadoRetrovisores() {
        Log.info("Recebida requisição para buscar estado dos retrovisores.");
        EstadoRetrovisores estadoRetrovisores = carroceriaService.buscarEstadoRetrovisores();
        return ResponseEntity.ok(estadoRetrovisores);
    }

    @PutMapping("/estado-retrovisores/{estado}")
    public ResponseEntity<String> atualizarEstadoRetrovisores(@PathVariable EstadoRetrovisores estado) {
        Log.info("Recebida requisição para atualizar estado dos retrovisores para {}.", estado);
        carroceriaService.atualizarEstadoRetrovisores(estado);
        return ResponseEntity.ok("Retrovisores atualizados com sucesso!");
    }

    @GetMapping("/estado-vidro")
    public ResponseEntity<EstadoVidro> buscarEstadoVidro() {
        Log.info("Recebida requisição para buscar estado do vidro.");
        EstadoVidro estadoVidro = carroceriaService.buscarEstadoVidro();
        return ResponseEntity.ok(estadoVidro);
    }

    @PutMapping("/estado-vidro/{estado}")
    public ResponseEntity<String> atualizarEstadoVidro(@PathVariable EstadoVidro estado) {
        Log.info("Recebida requisição para atualizar estado do vidro para {}.", estado);
        carroceriaService.atualizarEstadoVidro(estado);
        return ResponseEntity.ok("Vidro atualizado com sucesso.");
    }

    @GetMapping("/portas-fechadas")
    public ResponseEntity<Boolean> buscarPortasFechadas() {
        Log.info("Recebida requisição para buscar estado das portas.");
        Boolean portasFechadas = carroceriaService.buscarPortasFechadas();
        return ResponseEntity.ok(portasFechadas);
    }

    @PutMapping("/portas-fechadas/{estado}")
    public ResponseEntity<String> atualizarPortasFechadas(@PathVariable Boolean estado) {
        Log.info("Recebida requisição para atualizar estado das portas para {}.", estado);
        carroceriaService.atualizarPortasFechadas(estado);
        return ResponseEntity.ok("Porta atualizada com sucesso!");
    }

    @GetMapping("/banco/{lugar}")
    public ResponseEntity<EstadoBanco> buscarEstadoBanco(@PathVariable LugarBanco lugar) {
        Log.info("Recebida requisição para buscar estado do banco no lugar {}.", lugar);
        EstadoBanco estadoBanco = carroceriaService.buscarEstadoBanco(lugar);
        return ResponseEntity.ok(estadoBanco);
    }

    @PutMapping("/banco/{lugar}/{estado}")
    public ResponseEntity<String> atualizarEstadoBanco(@PathVariable LugarBanco lugar, @PathVariable EstadoBanco estado) {
        Log.info("Recebida requisição para atualizar estado do banco no lugar {} para {}.", lugar, estado);
        carroceriaService.atualizarEstadoBanco(lugar, estado);
        return ResponseEntity.ok("Banco atualizado com sucesso!");
    }
}
