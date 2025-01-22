package br.com.almavivasolutions.carro_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.almavivasolutions.carro_api.model.enums.TipoMotor;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MotorControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private final String baseUrl = "/api/carro/motor";

	@Test
	@Order(1)
	void deveBuscarTipoMotorComSucesso() {
		String urlGet = baseUrl + "/tipo";

		ResponseEntity<TipoMotor> response = restTemplate.getForEntity(urlGet, TipoMotor.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	@Order(2)
	void deveAtualizarTipoMotorComSucesso() {
		String urlPut = baseUrl + "/tipo/HIBRIDO";

		ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Motor atualizado com sucesso", response.getBody());
	}

	@Test
	@Order(3)
	void deveBuscarPotenciaComSucesso() {
		String urlGet = baseUrl + "/potencia";

		ResponseEntity<Double> response = restTemplate.getForEntity(urlGet, Double.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	@Order(4)
	void deveAtualizarPotenciaComSucesso() {
		String urlPut = baseUrl + "/potencia/120.0";

		ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Potencia atualizada com sucesso", response.getBody());
	}

	@Test
	@Order(5)
	void deveBuscarEstadoLigadoComSucesso() {
		String urlGet = baseUrl + "/ligado";

		ResponseEntity<Boolean> response = restTemplate.getForEntity(urlGet, Boolean.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	@Order(6)
	void deveAtualizarEstadoLigadoComSucesso() {
		String urlPut = baseUrl + "/ligado/true";

		ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Estado do motor atualizado com sucesso.", response.getBody());
	}
}
