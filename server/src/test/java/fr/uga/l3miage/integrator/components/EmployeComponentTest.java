package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.AssertionsKt.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeComponentTest {
    @Autowired
    private  EmployeComponent employeComponent;
    @MockBean
    private EmployeRepository employeRepository;

    @Test
    void findByEmploiTest(){
        //given
        EmployeEntity employeEntity = EmployeEntity
                .builder()
                .emploi(Emploi.LIVREUR)
                .trigramme("aaa")
                .build();
        EmployeEntity employeEntity1 = EmployeEntity
                .builder()
                .trigramme("bbb")
                .emploi(Emploi.LIVREUR)
                .build();
        EmployeEntity employeEntity2 = EmployeEntity
                .builder()
                .trigramme("ccc")
                .emploi(Emploi.PLANIFICATEUR)
                .build();


        Set<EmployeEntity> employeEntities= Set.of(employeEntity, employeEntity1);
        when(employeRepository.findAllByEmploi(Emploi.LIVREUR)).thenReturn(employeEntities);
        //when   // lorsque lla méthode employeComponent.findByEmploi est appelée, la requete employeRepository.findAllByEmploi(Emploi.LIVREUR) doit l'etre aussi
         Set<EmployeEntity> result = employeComponent.findByEmploi(Emploi.LIVREUR);
         //then
        assertThat(result).hasSize(2);
        assertThat(result.contains(employeEntity));
        assertThat(result.contains(employeEntity1));



        Set<EmployeEntity> employeEntities2= Set.of(employeEntity2);
        when(employeRepository.findAllByEmploi(Emploi.PLANIFICATEUR)).thenReturn(employeEntities2);
        //when   // lorsque lla méthode employeComponent.findByEmploi est appelée, la requete employeRepository.findAllByEmploi(Emploi.LIVREUR) doit l'etre aussi
        Set<EmployeEntity> result2 = employeComponent.findByEmploi(Emploi.PLANIFICATEUR);
        //then
        assertThat(result2).hasSize(1);
        assertThat(result2.contains(employeEntity2));
        //assertDoesNotThrow(() -> employeComponent.findByEmploi(Emploi.LIVREUR));

        //Simulation de la réponse de la BD:
        // lorsque la requete employeRepository.findAllByEmploi(Emploi.LIVREUR) est appelée, alors renvoyer un Set vide
        when(employeRepository.findAllByEmploi(Emploi.PRODEUR)).thenReturn(Set.of());
        //when   // lorsque la méthode employeComponent.findByEmploi est appelée, la requete employeRepository.findAllByEmploi(Emploi.LIVREUR) doit l'etre aussi
        Set<EmployeEntity> result3 = employeComponent.findByEmploi(Emploi.PRODEUR);
        //then
        assertThat(result3).hasSize(0);

    }


    @Test
    void creatEmploye(){
        //Given
        EmployeEntity employeEntity = EmployeEntity
                .builder()
                .emploi(Emploi.LIVREUR)
                .trigramme("aaa")
                .build();
        EmployeEntity employeEntity1 = EmployeEntity
                .builder()
                .trigramme("bbb")
                .emploi(Emploi.LIVREUR)
                .build();

        when(employeRepository.save(employeEntity)).thenReturn(employeEntity);
        //when
        EmployeEntity result = employeComponent.creatEmploye(employeEntity);
        //then /********************************


    }


}
