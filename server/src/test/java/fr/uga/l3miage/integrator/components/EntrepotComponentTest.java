package fr.uga.l3miage.integrator.components;


import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EntrepotComponentTest {
    @Autowired
    EntrepotComponent entrepotComponent;
    @MockBean
    EntrepotRepository entrepotRepository;

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

        when(entrepotRepository.findAll()).thenReturn(entrepotEntities);
        //when
        List<EntrepotEntity> result  = entrepotComponent.getAllEntrepots();
        //then
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo(entrepotEntity);
        assertThat(result.get(1)).isEqualTo(entrepotEntity1);

    }
}
