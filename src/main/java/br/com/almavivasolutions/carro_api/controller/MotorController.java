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

import br.com.almavivasolutions.carro_api.model.enums.TipoMotor;
import br.com.almavivasolutions.carro_api.service.MotorService;

@RestController
@RequestMapping("/api/carro/motor")
public class MotorController {

    private static final Logger Log = LogManager.getLogger(MotorController.class);

    @Autowired
    private MotorService motorService;

    @GetMapping("/tipo")
    public ResponseEntity<TipoMotor> buscarTipoMotor() {
        Log.info("Recebida requisição para buscar tipo do motor.");
        TipoMotor tipoMotor = motorService.buscarTipoMotor();
        Log.debug("Tipo do motor obtido: {}.", tipoMotor);
        return ResponseEntity.ok(tipoMotor);
    }

    @PutMapping("/tipo/{tipo}")
    public ResponseEntity<String> atualizarTipoMotor(@PathVariable TipoMotor tipo) {
        Log.info("Recebida requisição para atualizar tipo do motor para {}.", tipo);
        motorService.atualizarTipoMotor(tipo);
        Log.debug("Tipo do motor atualizado com sucesso.");
        return ResponseEntity.ok("Motor atualizado com sucesso");
    }

    @GetMapping("/potencia")
    public ResponseEntity<Double> buscarPotencia() {
        Log.info("Recebida requisição para buscar potência do motor.");
        Double potencia = motorService.buscarPotencia();
        Log.debug("Potência do motor obtida: {}.", potencia);
        return ResponseEntity.ok(potencia);
    }

    @PutMapping("/potencia/{potencia}")
    public ResponseEntity<String> atualizarPotencia(@PathVariable Double potencia) {
        Log.info("Recebida requisição para atualizar potência do motor para {}.", potencia);
        motorService.atualizarPotencia(potencia);
        Log.debug("Potência do motor atualizada com sucesso.");
        return ResponseEntity.ok("Potencia atualizada com sucesso");
    }

    @GetMapping("/ligado")
    public ResponseEntity<Boolean> buscarEstadoLigado() {
        Log.info("Recebida requisição para buscar estado ligado do motor.");
        Boolean ligado = motorService.buscarEstadoLigado();
        Log.debug("Estado ligado do motor obtido: {}.", ligado);
        return ResponseEntity.ok(ligado);
    }

    @PutMapping("/ligado/{estado}")
    public ResponseEntity<String> atualizarEstadoLigado(@PathVariable Boolean estado) {
        Log.info("Recebida requisição para atualizar estado ligado do motor para {}.", estado);
        motorService.atualizarEstadoLigado(estado);
        Log.debug("Estado ligado do motor atualizado com sucesso.");
        return ResponseEntity.ok("Estado do motor atualizado com sucesso.");
    }
}
