package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.repositories.CommandeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

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
    void getAllCommandesTest(){
        //Given
        CommandeEntity commandeEntity = CommandeEntity
                .builder()
                .reference("aaa")
                .build();
        CommandeEntity commandeEntity1 = CommandeEntity
                .builder()
                .reference("bbb")
                .build();
        CommandeEntity commandeEntity2 = CommandeEntity
                .builder()
                .reference("ccc")
                .build();

        List<CommandeEntity> commandeEntities = new ArrayList<CommandeEntity>(Arrays.asList(commandeEntity, commandeEntity1, commandeEntity2));
        when(commandeRepository.findAll()).thenReturn(commandeEntities);
        //when
        List<CommandeEntity> result = commandeComponent.getAllCommandes();
        //then
        assertThat(result).hasSize(3);
        assertThat(result).contains(commandeEntity);
        assertThat(result).contains(commandeEntity1);
        assertThat(result).contains(commandeEntity2);

    }


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


    @Test
    void updateCommandeTest(){

        //Given
        CommandeEntity commandeEntity = CommandeEntity
                .builder()
                .reference("aaa")
                .build();
        CommandeEntity commandeEntity1 = CommandeEntity
                .builder()
                .reference("bbb")
                .build();
        CommandeEntity commandeEntity2 = CommandeEntity
                .builder()
                .reference("aaa")
                .build();
        CommandeEntity commandeEntity3 = CommandeEntity
                .builder()
                .reference("bbb")
                .build();

        when(commandeRepository.save(commandeEntity1)).thenReturn(commandeEntity1);
        //when
        CommandeEntity result = commandeComponent.updateCommande(commandeEntity.getReference(), commandeEntity1);
        //then
        assertThat(commandeEntity.getReference()).isEqualTo(result.getReference());// tester en boite noire
        //on veriifie bien que la modifiacation d'un attribut de la commande(update) ne change pas la référence de la commande

        assertThat(result).isEqualTo(commandeEntity1);//tester en boite blanche:
        // je vois dans le code qu'il est fait juste un save sur le repository. Bien cette implementation n'est pas juste,
        // je vérifie tout de mème s'elle retourner ce qu'elle doit retourner.


    }


}
