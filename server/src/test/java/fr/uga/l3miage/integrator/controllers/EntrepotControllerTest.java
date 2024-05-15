package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.components.EntrepotComponent;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundEntrepotEntityException;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import fr.uga.l3miage.integrator.services.EntrepotService;
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
public class EntrepotControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    EntrepotRepository entrepotRepository;

    @SpyBean
    EntrepotComponent entrepotComponent;
    @SpyBean
    EntrepotService entrepotService;

    @AfterEach
    public void clear() {
        entrepotRepository.deleteAll();
    }

    @Test
    void getAllEntrepots() throws NotFoundEntrepotEntityException {
        final HttpHeaders headers = new HttpHeaders();

        ParameterizedTypeReference<List<EntrepotResponseDTO>> responseType = new ParameterizedTypeReference<List<EntrepotResponseDTO>>() {};

        //sert pour preciser le type de l'objet renvoyé lors de la requete
        ResponseEntity<List<EntrepotResponseDTO>> response = testRestTemplate.exchange("/entrepots/getAll", HttpMethod.GET, new HttpEntity<>(headers), responseType);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(entrepotComponent, times(1)).getAllEntrepots(); //****!!!*
        verify(entrepotService, times(1)).getAllEntrepots();
    }

}
