package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.JourneeComponent;
import fr.uga.l3miage.integrator.mappers.JourneeMapper;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class JourneeServiceTest {
    @Autowired
    JourneeService journeeService;
    @MockBean
    JourneeComponent journeeComponent;
    @SpyBean
    JourneeMapper journeeMapper;

    @Test
    void getJournee(){  //"test à revoir, car selon moi un DTO doit ètre renvoyé par le Service, et non un Entity": Cedrix
        //Given
        Optional<JourneeEntity> journeeEntity = Optional.ofNullable(JourneeEntity
                .builder()
                .reference("aaa")
                .build());
        when(journeeComponent.getJournee("aaa")).thenReturn(journeeEntity);
        //when
        Optional<JourneeEntity> result = journeeService.getJournee("aaa");
        //then
        assertThat(result).isEqualTo(journeeEntity);
    }
}
