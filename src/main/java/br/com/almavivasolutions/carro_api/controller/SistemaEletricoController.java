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

import br.com.almavivasolutions.carro_api.model.enums.EstadoBateria;
import br.com.almavivasolutions.carro_api.service.SistemaEletricoService;

@RestController
@RequestMapping("/api/carro/sistema-eletrico")
public class SistemaEletricoController {

	private static final Logger Log = LogManager.getLogger(SistemaEletricoController.class);

	@Autowired
	private SistemaEletricoService sistemaEletricoService;

	@GetMapping("/farois-acesos")
	public ResponseEntity<Boolean> buscarEstadoFarois() {
		Log.info("Recebida requisição para buscar estado dos faróis.");
		Boolean estadoFarois = sistemaEletricoService.buscarEstadoFarois();
		return ResponseEntity.ok(estadoFarois);
	}

	@PutMapping("/farois-acesos/{aceso}")
	public ResponseEntity<String> atualizarEstadoFarois(@PathVariable Boolean aceso) {
		Log.info("Recebida requisição para atualizar estado dos faróis para {}.", aceso);
		sistemaEletricoService.atualizarEstadoFarois(aceso);
		return ResponseEntity.ok("Farois atualizados.");
	}

	@GetMapping("/estado-bateria")
	public ResponseEntity<EstadoBateria> buscarEstadoBateria() {
		Log.info("Recebida requisição para buscar estado da bateria.");
		EstadoBateria estadoBateria = sistemaEletricoService.buscarEstadoBateria();
		return ResponseEntity.ok(estadoBateria);
	}

	@PutMapping("/estado-bateria/{estado}")
	public ResponseEntity<String> atualizarEstadoBateria(@PathVariable EstadoBateria estado) {
		Log.info("Recebida requisição para atualizar estado da bateria para {}.", estado);
		sistemaEletricoService.atualizarEstadoBateria(estado);
		return ResponseEntity.ok("Bateria atualizada.");
	}
}