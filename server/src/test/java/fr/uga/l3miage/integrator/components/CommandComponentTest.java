package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.repositories.CommandeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static java.util.Optional.of;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CommandComponentTest {
    @Autowired
    CommandeComponent commandeComponent;
    @MockBean
    CommandeRepository commandeRepository;

    @Test
    void getCommandeByReferenceTest(){

        CommandeEntity commandeEntity = CommandeEntity
                .builder()
                .reference("aaa")
                .build();
        CommandeEntity commandeEntity1 = CommandeEntity
                .builder()
                .reference("bbb")
                .build();

        //Given
        when(commandeRepository.findById("aaa")).thenReturn(Optional.of(commandeEntity));
        //when
        CommandeEntity result = commandeComponent.getCommandeByReference("aaa");
        //then
        assertThat(result).isEqualTo(commandeEntity);

        //Given
        when(commandeRepository.findById("bbb")).thenReturn(Optional.empty());
        //when
        CommandeEntity result2 = commandeComponent.getCommandeByReference("bbb");
        //then
        assertThat(result2).isNull();
    }
}
