package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.exceptions.technical.NotFoundJourneeEntityException;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import fr.uga.l3miage.integrator.requests.JourneeUpdateRequest;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class JourneeComponentTest {
    @Autowired
    JourneeComponent journeeComponent;
    @MockBean
    JourneeRepository journeeRepository;


    @Test
    void getJourneeNotFoundTest(){
        RuntimeException exception = new RuntimeException("");
        JourneeEntity journeeEntity = JourneeEntity
                .builder()
                .reference("bbb")
                .build();

        when(journeeRepository.findById("aaa")).thenThrow(exception);
        Assertions.assertThrows(NotFoundJourneeEntityException.class, ()->journeeComponent.getJournee("aaa"));
        Assertions.assertThrows(RuntimeException.class, ()->journeeComponent.updateJournee("aaa", journeeEntity));
    }


    @Test
    void getJourneeByReferenceTest() throws NotFoundJourneeEntityException {
        //Given
        JourneeEntity journeeEntity = JourneeEntity
                .builder()
                .reference("aaa")
                .build();


        when(journeeRepository.findById("aaa")).thenReturn(Optional.ofNullable(journeeEntity));
        //when
        Optional<JourneeEntity> result = journeeComponent.getJournee("aaa");
        //then
        OptionalAssert<JourneeEntity> equalTo = assertThat(result).isEqualTo(journeeEntity);
        Assertions.assertDoesNotThrow(()->journeeComponent.getJournee("aaa"));
    }

    @Test
    void creatJourneeTest(){
        //Given
        JourneeEntity journeeEntity = JourneeEntity
                .builder()
                .reference("aaa")
                .build();
        //Mock: uniquement lorsque la requete journeeRepository.save(journeeEntity) est faite, renvoyer journeeEntity
        when(journeeRepository.save(journeeEntity)).thenReturn(journeeEntity);
        //when
        JourneeEntity result = journeeComponent.createJournee(journeeEntity); // enregistrer en BD la nouvelle JourneeEntity
          //une implémentation juste de journeeComponent.createJournee(journeeEntity) doit faire appèle à journeeRepository.save(journeeEntity)
        //then
        assertThat(result).isEqualTo(journeeEntity);
          //si la méthode journeeComponent.createJournee(journeeEntity) est bien implémenter, elle doit retourner journeeEntity
    }


    @Test
    void updateJourneeTest() throws NotFoundJourneeEntityException{
        //Given
        Optional<JourneeEntity> journeeEntity = Optional.ofNullable(JourneeEntity
                .builder()
                .reference("aaa")
                .montant(15.0)
                .build());
        JourneeEntity journeeEntity1 =JourneeEntity
                .builder()
                .reference("bbb")
                .montant(20.0)
                .build();
        String reference = journeeEntity.get().getReference();

        when(journeeRepository.findById(reference)).thenReturn(journeeEntity);

        Optional<JourneeEntity> journeeEntityExp = Optional.ofNullable(JourneeEntity
                .builder()
                .reference("aaa")
                .montant(20.0)
                .build());

        when(journeeRepository.save(journeeEntity.get())).thenReturn(journeeEntityExp.get());

        //when
        Optional<JourneeEntity> result = journeeComponent.updateJournee(reference, journeeEntity1);
        //then
        assertThat(result).isEqualTo(journeeEntityExp);
        Assertions.assertDoesNotThrow(()->journeeComponent.updateJournee(reference, journeeEntity1));
    }


    /*********void updateJourneeTest(){
     //Given
     Optional<JourneeEntity> journeeEntity = Optional.ofNullable(JourneeEntity
     .builder()
     .reference("aaa")
     .montant(15.0)
     .build());
     JourneeEntity journeeEntity1 =JourneeEntity
     .builder()
     .reference("bbb")
     .montant(20.0)
     .build();
     String reference = journeeEntity.get().getReference();

     when(journeeRepository.findById(reference)).thenReturn(journeeEntity);
     journeeEntity1.setMontant(20.0);

     Optional<JourneeEntity> journeeEntityExp = Optional.ofNullable(JourneeEntity
     .builder()
     .reference("aaa")
     .montant(0.0)
     .build());

     double montant=20.0;
     when(journeeEntity.get().setMontant(20.0)).then( journeeEntityExp.get().setMontant(20.0));

     when(journeeRepository.save(journeeEntity.get())).thenReturn(journeeEntityExp.get());

     //when
     Optional<JourneeEntity> result = journeeComponent.updateJournee(reference, journeeEntity1);
     //then
     assertThat(result).isEqualTo(journeeEntityExp);
     }*********/



}
