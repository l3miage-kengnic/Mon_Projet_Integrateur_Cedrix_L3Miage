package fr.uga.l3miage.integrator.controllers;


import fr.uga.l3miage.integrator.components.CamionComponent;
import fr.uga.l3miage.integrator.repositories.CamionRepository;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AutoConfigureWebClient
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class CamionControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CamionRepository camionRepository;
    @SpyBean
    private CamionComponent camionComponent;

    @AfterEach
    public void clear() {
        camionRepository.deleteAll();
    }


    @Test
    void getAllCamionsTest(){
        final HttpHeaders headers = new HttpHeaders();

        //when
        ResponseEntity<CamionResponseDTO> response = testRestTemplate.exchange("http://localhost:8080/camions/getAll", HttpMethod.GET, new HttpEntity<>(headers), CamionResponseDTO.class);
    }
}
