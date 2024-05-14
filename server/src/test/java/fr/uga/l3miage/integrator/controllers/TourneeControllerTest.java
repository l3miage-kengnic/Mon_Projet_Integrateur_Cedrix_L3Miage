package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.components.TourneeComponent;
import fr.uga.l3miage.integrator.mappers.TourneeMapper;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
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
import org.springframework.core.ParameterizedTypeReference;
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
    @SpyBean
    private TourneeMapper tourneeMapper;

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



    @Test
    void createTourneeTest(){
        final HttpHeaders headers = new HttpHeaders();

        final TourneeCreationRequest request = TourneeCreationRequest
                .builder()
                .reference("aaa")
                .build();

        ParameterizedTypeReference<TourneeResponseDTO> responseType = new ParameterizedTypeReference<TourneeResponseDTO>() {};

        ResponseEntity<TourneeResponseDTO> response = testRestTemplate.exchange("/tournees/create", HttpMethod.POST, new HttpEntity<>(request, headers), responseType);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(tourneeService, times(1)).createTournee(request);
        verify(tourneeComponent, times(1)).createTournee( tourneeMapper.createRequestToEntity(request));
    }


}
