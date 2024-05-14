package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.components.TourneeComponent;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import fr.uga.l3miage.integrator.services.TourneeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@AutoConfigureWebClient
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class TourneeControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TourneeRepository tourneeRepository;
    @SpyBean
    private TourneeService tourneeService;
    @SpyBean
    private TourneeComponent tourneeComponent;

    @AfterEach
    public void clear() {
        tourneeRepository.deleteAll();
    }

    @Test
    void getTournee(){
        final HttpHeaders headers = new HttpHeaders();

        TourneeEntity tourneeEntity = TourneeEntity
                .builder()
                .reference("aaa")
                .build();
        tourneeRepository.save(tourneeEntity);

        String reference = "aaa";

        ResponseEntity<TourneeResponseDTO> response = testRestTemplate.exchange("/tournees/reference", HttpMethod.GET, new HttpEntity<>(headers), TourneeResponseDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(tourneeService, times(1)).getTournee(reference);
        verify(tourneeComponent, times(1)).getTourneeByReference(reference);
    }
}
