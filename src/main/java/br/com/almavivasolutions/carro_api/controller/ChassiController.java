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

import br.com.almavivasolutions.carro_api.model.enums.EstadoPedal;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPneu;
import br.com.almavivasolutions.carro_api.model.enums.EstadoTanque;
import br.com.almavivasolutions.carro_api.model.enums.LugarPneu;
import br.com.almavivasolutions.carro_api.model.enums.TipoPedal;
import br.com.almavivasolutions.carro_api.service.ChassiService;

@RestController
@RequestMapping("/api/carro/chassi")
public class ChassiController {

    private static final Logger Log = LogManager.getLogger(ChassiController.class);

    @Autowired
    private ChassiService chassiService;

    @GetMapping("/estado-tanque")
    public ResponseEntity<EstadoTanque> buscarEstadoTanque() {
        Log.info("Recebida requisição para buscar estado do tanque.");
        EstadoTanque estadoTanque = chassiService.buscarEstadoTanque();
        return ResponseEntity.ok(estadoTanque);
    }

    @PutMapping("/estado-tanque/{estado}")
    public ResponseEntity<String> atualizarEstadoTanque(@PathVariable EstadoTanque estado) {
        Log.info("Recebida requisição para atualizar estado do tanque para {}.", estado);
        chassiService.atualizarEstadoTanque(estado);
        return ResponseEntity.ok("Tanque atualizado com sucesso.");
    }

    @GetMapping("/pneus/{lugar}")
    public ResponseEntity<EstadoPneu> buscarEstadoPneu(@PathVariable LugarPneu lugar) {
        Log.info("Recebida requisição para buscar estado do pneu em {}.", lugar);
        EstadoPneu estadoPneu = chassiService.buscarEstadoPneu(lugar);
        return ResponseEntity.ok(estadoPneu);
    }

    @PutMapping("/pneus/{lugar}/{estado}")
    public ResponseEntity<String> atualizarEstadoPneu(@PathVariable LugarPneu lugar, @PathVariable EstadoPneu estado) {
        Log.info("Recebida requisição para atualizar estado do pneu no lugar {} para {}.", lugar, estado);
        chassiService.atualizarEstadoPneu(lugar, estado);
        return ResponseEntity.ok("Pneu atualizado com sucesso.");
    }

    @GetMapping("/pedais/{tipo}")
    public ResponseEntity<EstadoPedal> buscarEstadoPedal(@PathVariable TipoPedal tipo) {
        Log.info("Recebida requisição para buscar estado do pedal {}.", tipo);
        EstadoPedal estadoPedal = chassiService.buscarEstadoPedal(tipo);
        return ResponseEntity.ok(estadoPedal);
    }

    @PutMapping("/pedais/{tipo}/{estado}")
    public ResponseEntity<String> atualizarEstadoPedal(@PathVariable TipoPedal tipo, @PathVariable EstadoPedal estado) {
        Log.info("Recebida requisição para atualizar estado do pedal {} para {}.", tipo, estado);
        chassiService.atualizarEstadoPedal(tipo, estado);
        return ResponseEntity.ok("Pedal atualizado com sucesso.");
    }
}
