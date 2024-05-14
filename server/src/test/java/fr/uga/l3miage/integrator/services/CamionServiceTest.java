package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.CamionComponent;
import fr.uga.l3miage.integrator.mappers.CamionMapper;
import fr.uga.l3miage.integrator.models.CamionEntity;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CamionServiceTest {
    @Autowired
    private CamionService camionService;
    @MockBean
    private CamionComponent camionComponent;
    @SpyBean
    private CamionMapper camionMapper;

    @Test
    void getAllCamionsTest(){
        //Given
        CamionEntity camionEntity = CamionEntity
                .builder()
                .immatriculation("12a12a")
                .build();
        CamionEntity camionEntity1 = CamionEntity
                .builder()
                .immatriculation("12b12b")
                .build();
        List<CamionEntity> camionEntities = List.of(camionEntity, camionEntity1);

        when(camionComponent.getAllCamions()).thenReturn(camionEntities);
        //when
        List<CamionResponseDTO> result = camionService.getAllCamions();

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo( camionMapper.entityToDto(camionEntity));
        assertThat(result.get(1)).isEqualTo( camionMapper.entityToDto(camionEntity1));


    }
}
