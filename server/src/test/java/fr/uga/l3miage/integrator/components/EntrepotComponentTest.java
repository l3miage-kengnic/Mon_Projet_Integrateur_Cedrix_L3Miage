package fr.uga.l3miage.integrator.components;


import fr.uga.l3miage.integrator.exceptions.technical.NotFoundEntrepotEntityException;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import org.junit.jupiter.api.Assertions;
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
    void getEntrepotNotFoundTest(){
        RuntimeException exception = new RuntimeException("");
        when(entrepotRepository.findAll()).thenThrow(exception);
        Assertions.assertThrows(NotFoundEntrepotEntityException.class, ()->entrepotComponent.getAllEntrepots());
    }


    @Test
    void getAllEntrepotsTest() throws NotFoundEntrepotEntityException {
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
        assertThat(result.get(1)).isEqualTo(entrepotEntity1);
        //Ne doit renvoyer aucune exception en condition normale
        Assertions.assertDoesNotThrow(()->entrepotComponent.getAllEntrepots());

    }
}
