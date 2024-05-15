package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.exceptions.technical.NotFoundCamionEntityException;
import fr.uga.l3miage.integrator.models.CamionEntity;
import fr.uga.l3miage.integrator.repositories.CamionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CamionComponentTest {
    @Autowired
    private CamionComponent camionComponent;
    @MockBean
    private CamionRepository camionRepository;


    @Test
    void getCamionsNoFoundTest(){

        RuntimeException exception = new RuntimeException("");
        when(camionRepository.findAll()).thenThrow(exception);//simule le renvoie d'une exception venant de camionRepository.findAll()

        Assertions.assertThrows(NotFoundCamionEntityException.class, ()->camionComponent.getAllCamions());
        //si camionComponent.getAllCamions() reçoit une exception et ce qui est le cas d'àprès notre simulation,
         //alors elle doit renvoyer une NotFoundCamionEntityException.class
    }


    @Test
    void getAllCamionsTest() throws NotFoundCamionEntityException {
        //Given
        CamionEntity camionEntity = CamionEntity
                .builder()
                .immatriculation("12a12a")
                .build();
        CamionEntity camionEntity1 = CamionEntity
                .builder()
                .immatriculation("12b12b")
                .build();
        CamionEntity camionEntity2 = CamionEntity
                .builder()
                .immatriculation("12c12c")
                .build();

        List<CamionEntity> camionEntities = List.of(camionEntity, camionEntity1, camionEntity2);

        when(camionRepository.findAll()).thenReturn(camionEntities);
        //when
        List<CamionEntity> result = camionComponent.getAllCamions();

        assertThat(result).hasSize(3);
        assertThat(result).contains(camionEntity2);
        assertThat(result).contains(camionEntity1);
        assertThat(result).contains(camionEntity);
        Assertions.assertDoesNotThrow(()->camionComponent.getAllCamions());

    }
}
