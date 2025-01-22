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

import br.com.almavivasolutions.carro_api.model.enums.EstadoBanco;
import br.com.almavivasolutions.carro_api.model.enums.EstadoRetrovisores;
import br.com.almavivasolutions.carro_api.model.enums.EstadoVidro;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarroceriaTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/api/carro/carroceria";

    
    @Test
    @Order(1)
    void deveBuscarEstadoRetrovisoresComSucesso() {
        String urlGet = baseUrl + "/estado-retrovisores";

        ResponseEntity<EstadoRetrovisores> response = restTemplate.getForEntity(urlGet, EstadoRetrovisores.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(2)
    void deveAtualizarEstadoRetrovisoresComSucesso() {
        String urlPut = baseUrl + "/estado-retrovisores/ALINHADO";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Retrovisores atualizados com sucesso!", response.getBody());
    }

    @Test
    @Order(3)
    void deveBuscarEstadoVidroComSucesso() {
        String urlGet = baseUrl + "/estado-vidro";

        ResponseEntity<EstadoVidro> response = restTemplate.getForEntity(urlGet, EstadoVidro.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void deveAtualizarEstadoVidroComSucesso() {
        String urlPut = baseUrl + "/estado-vidro/LIMPO";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Vidro atualizado com sucesso.", response.getBody());
    }

    @Test
    @Order(5)
    void deveBuscarEstadoBancoComSucesso() {
        String urlGet = baseUrl + "/banco/MOTORISTA";

        ResponseEntity<EstadoBanco> response = restTemplate.getForEntity(urlGet, EstadoBanco.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(6)
    void deveAtualizarEstadoBancoComSucesso() {
        String urlPut = baseUrl + "/banco/MOTORISTA/OCUPADO";

        ResponseEntity<String> response = restTemplate.exchange(urlPut, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Banco atualizado com sucesso!", response.getBody());
    }
    
    @Test
    @Order(7)
    void deveBuscarEstadoDasPortas() {
        String url = baseUrl + "/portas-fechadas";

        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(8)
    void deveAtualizarEstadoDasPortas() {
        String url = baseUrl + "/portas-fechadas/true";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Porta atualizada com sucesso!", response.getBody());
    }
}
