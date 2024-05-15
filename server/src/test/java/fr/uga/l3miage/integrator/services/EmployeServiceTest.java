package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EmployeComponent;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEntityRestException;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundEmployeEntityException;
import fr.uga.l3miage.integrator.mappers.EmployeMapper;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Set;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeServiceTest {
    @Autowired
    private EmployeService employeService;
    @MockBean
    private EmployeComponent employeComponent;
    @SpyBean
    private EmployeMapper employeMapper;


    @Test
    void getEmployeNotFoundTest() throws NotFoundEmployeEntityException{
        when(employeComponent.findByEmploi(Emploi.PRODEUR)).thenThrow(new NotFoundEntityRestException("Aucun employé trouvé"));
        when(employeComponent.getAllEmployes()).thenThrow(new NotFoundEntityRestException("Aucun employé trouvé"));

        Assertions.assertThrows(NotFoundEntityRestException.class, ()-> employeService.getEmployesByEmploi(Emploi.PRODEUR));
        Assertions.assertThrows(NotFoundEntityRestException.class, ()->employeService.getAllEmployes());
    }


    @Test
    void getEmployeByEmploisTest() throws NotFoundEmployeEntityException {

        EmployeResponseDTO employeResponseDTO = EmployeResponseDTO
                .builder()
                .emploi(Emploi.LIVREUR)
                .trigramme("aaa")
                .build();
        EmployeResponseDTO employeResponseDTO1 = EmployeResponseDTO
                .builder()
                .emploi(Emploi.LIVREUR)
                .trigramme("bbb")
                .build();
        EmployeResponseDTO employeResponseDTO2 = EmployeResponseDTO
                .builder()
                .emploi(Emploi.PLANIFICATEUR)
                .trigramme("ccc")
                .build();

        Set<EmployeEntity> employeEntities = Set.of(employeMapper.dtoToEntity(employeResponseDTO), employeMapper.dtoToEntity(employeResponseDTO1));

        //when
        when(employeComponent.findByEmploi(Emploi.LIVREUR)).thenReturn(employeEntities);
        Set<EmployeResponseDTO> result = employeService.getEmployesByEmploi(Emploi.LIVREUR);
        assertThat(result).hasSize(2);
        assertThat(result).contains(employeResponseDTO);
        assertThat(result).contains(employeResponseDTO1);

        //Given
        Set<EmployeEntity> employeEntities2 = Set.of(employeMapper.dtoToEntity(employeResponseDTO2));
        when(employeComponent.findByEmploi(Emploi.PLANIFICATEUR)).thenReturn(employeEntities2);
        //when
        Set<EmployeResponseDTO> result2 = employeService.getEmployesByEmploi(Emploi.PLANIFICATEUR);
        //then
        assertThat(result2).hasSize(1);
        assertThat(result2).contains(employeResponseDTO2);

        Assertions.assertDoesNotThrow(()->employeService.getEmployesByEmploi(Emploi.LIVREUR));

    }

}
