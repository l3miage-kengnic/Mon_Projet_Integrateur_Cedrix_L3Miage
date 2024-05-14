package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.TourneeComponent;
import fr.uga.l3miage.integrator.mappers.TourneeMapper;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TourneeServiceTest {
    @Autowired
    TourneeService tourneeService;
    @MockBean
    TourneeComponent tourneeComponent;
    @SpyBean
    TourneeMapper tourneeMapper;

    @Test
    void getTourneeByReferenceTest(){
        //Given
        TourneeEntity tourneeEntity = TourneeEntity
                .builder()
                .reference("aaa")
                .build();
        String reference = tourneeEntity.getReference();
        when(tourneeComponent.getTourneeByReference(reference)).thenReturn(tourneeEntity);
        //when
        TourneeResponseDTO result = tourneeService.getTournee(reference);
        //then
        assertThat(result).isEqualTo(tourneeMapper.entityToDto(tourneeEntity));
    }


    @Test
    void  creatTourneeTest(){
        //Given
        TourneeCreationRequest tourneeCreationRequest = TourneeCreationRequest
                .builder()
                .reference("aaa")
                .build();
        TourneeEntity tourneeEntity = tourneeMapper.createRequestToEntity(tourneeCreationRequest);
        when(tourneeComponent.createTournee(tourneeEntity)).thenReturn(tourneeEntity);
        //when
        TourneeResponseDTO result = tourneeService.createTournee(tourneeCreationRequest);
        //then
        assertThat(result).isEqualTo( tourneeMapper.entityToDto(tourneeEntity));
    }

}
