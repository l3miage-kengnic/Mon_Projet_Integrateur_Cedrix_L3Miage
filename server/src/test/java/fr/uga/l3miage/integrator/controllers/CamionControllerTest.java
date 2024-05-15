package fr.uga.l3miage.integrator.controllers;


import fr.uga.l3miage.integrator.components.CamionComponent;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundCamionEntityException;
import fr.uga.l3miage.integrator.repositories.CamionRepository;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import fr.uga.l3miage.integrator.services.CamionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
    @SpyBean
    private CamionService camionService;

    @AfterEach
    public void clear() {
        camionRepository.deleteAll();
    }


    @Test
    void getAllCamionsTest() throws NotFoundCamionEntityException {
        final HttpHeaders headers = new HttpHeaders();

        //sert pour preciser le type de l'objet renvoyé lors de la requete
        ParameterizedTypeReference<List<CamionResponseDTO>> responseType = new ParameterizedTypeReference<List<CamionResponseDTO>>() {};

        //when
        ResponseEntity<List<CamionResponseDTO>> response = testRestTemplate.exchange("/camions/getAll", HttpMethod.GET, new HttpEntity<>(headers), responseType);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(camionRepository.count()).isEqualTo(1);
        verify(camionComponent, times(1)).getAllCamions();
        verify(camionService, times(1)).getAllCamions();

    }
}
