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

import br.com.almavivasolutions.carro_api.model.Carro;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarroTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private final String baseUrl = "/api/carro";

	@Test
	@Order(1)
	void deveLancarExcecaoCarroDesligado() {
		String urlPutAcelerar = baseUrl + "/acelerar";

		ResponseEntity<String> response = restTemplate.exchange(urlPutAcelerar, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	@Order(2)
	void deveBuscarCarroComSucesso() {
		ResponseEntity<Carro> response = restTemplate.getForEntity(baseUrl, Carro.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	@Order(3)
	void deveLigarCarroComSucesso() {
		String urlPut = baseUrl + "/ligar";

		ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Carro ligado com sucesso!", response.getBody());
	}

	@Test
	@Order(4)
	void deveLancarExcecaoAoLigarCarroJaLigado() {
		String urlPut = baseUrl + "/ligar";

		ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	@Order(5)
	void deveLancarExcecaoAceleradorNaoPressionado() {
		String urlPutAcelerar = baseUrl + "/acelerar";

		ResponseEntity<String> response = restTemplate.exchange(urlPutAcelerar, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	@Order(6)
	void deveAcelerarCarroComSucesso() {
		String urlPutPressionarAcelerador = baseUrl + "/chassi/pedais/ACELERADOR/PRESSIONADO";
		String urlPutAcelerar = baseUrl + "/acelerar";

		restTemplate.exchange(urlPutPressionarAcelerador, HttpMethod.PUT, null, String.class);

		ResponseEntity<String> response = restTemplate.exchange(urlPutAcelerar, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Carro acelerando com sucesso.", response.getBody());
	}

	@Test
	@Order(7)
	void deveFrearCarroComSucesso() {
		String urlPutSoltarAcelerador = baseUrl + "/chassi/pedais/ACELERADOR/NAO_PRESSIONADO";
		String urlPutPressionarFreio = baseUrl + "/chassi/pedais/FREIO/PRESSIONADO";
		String urlPutFrear = baseUrl + "/frear/10";
		String urlPutSoltarFreio = baseUrl + "/chassi/pedais/FREIO/NAO_PRESSIONADO";

		restTemplate.exchange(urlPutSoltarAcelerador, HttpMethod.PUT, null, String.class);
		restTemplate.exchange(urlPutPressionarFreio, HttpMethod.PUT, null, String.class);

		ResponseEntity<String> response = restTemplate.exchange(urlPutFrear, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Carro freou com sucesso.", response.getBody());

		restTemplate.exchange(urlPutSoltarFreio, HttpMethod.PUT, null, String.class);
	}

	@Test
	@Order(8)
	void deveDesligarCarroComSucesso() {
		String urlPutDesligar = baseUrl + "/desligar";

		ResponseEntity<String> response = restTemplate.exchange(urlPutDesligar, HttpMethod.PUT, null, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Carro Desligado com sucesso.", response.getBody());
	}
}
