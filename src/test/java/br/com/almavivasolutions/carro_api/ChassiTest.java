package br.com.almavivasolutions.carro_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
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

import br.com.almavivasolutions.carro_api.model.enums.EstadoPedal;
import br.com.almavivasolutions.carro_api.model.enums.EstadoPneu;
import br.com.almavivasolutions.carro_api.model.enums.EstadoTanque;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChassiTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/api/carro/chassi";

    @Test
    @Order(1)
    void deveBuscarEstadoTanqueComSucesso() {
        String urlGet = baseUrl + "/estado-tanque";

        ResponseEntity<EstadoTanque> response = restTemplate.getForEntity(urlGet, EstadoTanque.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(2)
    void deveAtualizarEstadoTanqueComSucesso() {
        String urlPut = baseUrl + "/estado-tanque/CHEIO";
        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tanque atualizado com sucesso.", response.getBody());
    }

    @Test
    @Order(3)
    @DisplayName("Deve buscar o estado do pneu no lugar especificado com sucesso")
    void deveBuscarEstadoPneuComSucesso() {
        String urlGet = baseUrl + "/pneus/DIANTEIRO_ESQUERDO";

        ResponseEntity<EstadoPneu> response = restTemplate.getForEntity(urlGet, EstadoPneu.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void deveAtualizarEstadoPneuComSucesso() {
        String urlPut = baseUrl + "/pneus/DIANTEIRO_ESQUERDO/CHEIO";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pneu atualizado com sucesso.", response.getBody());
    }
    
    @Test
    @Order(5)
    void deveBuscarEstadoDoPedal() {
        String url = baseUrl + "/pedais/ACELERADOR";

        ResponseEntity<EstadoPedal> response = restTemplate.getForEntity(url, EstadoPedal.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(6)
    void deveAtualizarEstadoDoPedal() {
        String url = baseUrl + "/pedais/ACELERADOR/PRESSIONADO";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pedal atualizado com sucesso.", response.getBody());
    }
}
