package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import org.assertj.core.api.OptionalAssert;
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
    void getJourneeByReferenceTest(){
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
}
