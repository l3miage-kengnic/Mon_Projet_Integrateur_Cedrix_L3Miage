package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.components.JourneeComponent;
import fr.uga.l3miage.integrator.mappers.JourneeMapper;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import fr.uga.l3miage.integrator.requests.JourneeCreationRequest;
import fr.uga.l3miage.integrator.responses.JourneeResponseDTO;
import fr.uga.l3miage.integrator.services.JourneeService;
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
public class JourneeControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JourneeRepository journeeRepository;
    @SpyBean
    private JourneeService journeeService;
    @SpyBean
    private JourneeComponent journeeComponent;
    @SpyBean
    JourneeMapper journeeMapper;

    @AfterEach
    public void clear() {
        journeeRepository.deleteAll();
    }

    @Test
    void getJourneeTest(){

        final HttpHeaders headers = new HttpHeaders();

        JourneeEntity journeeEntity = JourneeEntity
                .builder()
                .reference("aaa")
                .build();
        journeeRepository.save(journeeEntity);

        ResponseEntity<JourneeResponseDTO> response = testRestTemplate.exchange("/journees/aaa", HttpMethod.GET, new HttpEntity<>(headers), JourneeResponseDTO.class);

        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(journeeService, times(1)).getJournee("aaa"); // verifier que getJournee("aaa") a bien été appelé 1 fois dans la classe JourneeService, pour cette requete
        verify(journeeComponent, times(1)).getJournee("aaa");
        //verify(journeeRepository, times(1)).findById("aaa");
    }


    @Test
    void creatJourneeTest(){
        final HttpHeaders headers = new HttpHeaders();

        final JourneeCreationRequest request = JourneeCreationRequest
                .builder()
                .reference("aaa")
                .build();

        ParameterizedTypeReference<Void> responseType = new ParameterizedTypeReference<Void>() {};
        ResponseEntity<Void> response = testRestTemplate.exchange("/journees/create", HttpMethod.POST, new HttpEntity<>(request,headers), responseType );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(journeeService, times(1)).createJournee(request); // verifier que creatJournee("aaa") a bien été appelé 1 fois dans la classe JourneeService, pour cette requete
        verify(journeeComponent, times(1)).createJournee(journeeMapper.createRequestToEntity(request));

    }

}
