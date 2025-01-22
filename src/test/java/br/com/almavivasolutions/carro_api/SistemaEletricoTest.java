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

import br.com.almavivasolutions.carro_api.model.enums.EstadoBateria;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SistemaEletricoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/api/carro/sistema-eletrico";

    @Test
    @Order(1)
    void deveBuscarEstadoFaroisComSucesso() {
        String urlGet = baseUrl + "/farois-acesos";

        ResponseEntity<Boolean> response = restTemplate.getForEntity(urlGet, Boolean.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(2)
    void deveAtualizarEstadoFaroisComSucesso() {
        String urlPut = baseUrl + "/farois-acesos/true";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Farois atualizados.", response.getBody());
    }

    @Test
    @Order(3)
    void deveBuscarEstadoBateriaComSucesso() {
        String urlGet = baseUrl + "/estado-bateria";

        ResponseEntity<EstadoBateria> response = restTemplate.getForEntity(urlGet, EstadoBateria.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void deveAtualizarEstadoBateriaComSucesso() {
        String urlPut = baseUrl + "/estado-bateria/CARREGADA";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Bateria atualizada.", response.getBody());
    }
}
