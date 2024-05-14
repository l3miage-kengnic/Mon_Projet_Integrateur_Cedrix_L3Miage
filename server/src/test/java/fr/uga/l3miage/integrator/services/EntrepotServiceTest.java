package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EntrepotComponent;
import fr.uga.l3miage.integrator.mappers.EntrepotMapper;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EntrepotServiceTest {
    @Autowired
    EntrepotService entrepotService;
    @MockBean
    EntrepotComponent entrepotComponent;
    @SpyBean
    EntrepotMapper entrepotMapper;

    @Test
    void getAllEntrepotsTest(){
        //Given
        EntrepotEntity entrepotEntity = EntrepotEntity
                .builder()
                .name("Grenis")
                .build();
        EntrepotEntity entrepotEntity1 = EntrepotEntity
                .builder()
                .name("Lyonis")
                .build();

        List<EntrepotEntity> entrepotEntities=List.of(entrepotEntity, entrepotEntity1);
        when(entrepotComponent.getAllEntrepots()).thenReturn(entrepotEntities);
        //when
        List<EntrepotResponseDTO> result = entrepotService.getAllEntrepots();
        //then
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo(entrepotMapper.entityToDto(entrepotEntity));
        assertThat(result.get(1)).isEqualTo(entrepotMapper.entityToDto(entrepotEntity1));

    }
}
