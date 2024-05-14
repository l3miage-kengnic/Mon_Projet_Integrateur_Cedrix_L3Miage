package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TourComponentTest {
    @Autowired
    TourneeComponent tourneeComponent;
    @MockBean
    TourneeRepository tourneeRepository;

    @Test
    void getAllTourneesTest(){
        //Given
        TourneeEntity tourneeEntity = TourneeEntity
                .builder()
                .reference("aaa")
                .build();
        TourneeEntity tourneeEntity1 = TourneeEntity
                .builder()
                .reference("bbb")
                .build();

        List<TourneeEntity> tourneeEntities = List.of(tourneeEntity, tourneeEntity1);

        when(tourneeRepository.findAll()).thenReturn(tourneeEntities);
        //when
        List<TourneeEntity> result = tourneeComponent.getAllTournees();
        //Then
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo(tourneeEntity);
        assertThat(result.get(1)).isEqualTo(tourneeEntity1);

    }


    @Test
    void getTourneeByReferenceTest(){
        //Given
        TourneeEntity tourneeEntity = TourneeEntity
                .builder()
                .reference("aaa")
                .build();

        String reference = tourneeEntity.getReference();
        when(tourneeRepository.findById(reference)).thenReturn(Optional.of(tourneeEntity));
        //when
        TourneeEntity result = tourneeComponent.getTourneeByReference(reference);
        //Then
        assertThat(result).isEqualTo(tourneeEntity);
    }

}
