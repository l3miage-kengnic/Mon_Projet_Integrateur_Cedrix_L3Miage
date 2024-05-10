package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform= org.hibernate.dialect.H2Dialect")
public class EmployeRepositoryTest {
    @Autowired
    private EmployeRepository employeRepository;

    @Test
    void testRequestfindAllByEmploi(){
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

        employeRepository.save(employeEntity);
        employeRepository.save(employeEntity1);
        employeRepository.save(employeEntity2);

        // when
        Set<EmployeEntity> employeEntitiesResponse = employeRepository.findAllByEmploi(Emploi.LIVREUR);
        Set<EmployeEntity> employeEntitiesResponse1 = employeRepository.findAllByEmploi(Emploi.PLANIFICATEUR);
        Set<EmployeEntity> employeEntitiesResponse2 = employeRepository.findAllByEmploi(Emploi.PRODEUR);

        // Then
        assertThat(employeEntitiesResponse).hasSize(2);
        assertThat(employeEntitiesResponse1).hasSize(1);
        assertThat(employeEntitiesResponse2).hasSize(0);

        assertThat(employeEntitiesResponse.stream().findFirst().get().getEmploi()).isEqualTo(Emploi.LIVREUR);
        assertThat(employeEntitiesResponse1.stream().findFirst().get().getEmploi()).isEqualTo(Emploi.PLANIFICATEUR);

    }

}
