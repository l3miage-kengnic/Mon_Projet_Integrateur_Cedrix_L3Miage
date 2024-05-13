package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.CommandeComponent;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.mappers.CommandeMapper;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.repositories.CommandeRepository;
import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CommandeServiceTest {

    @Autowired
    CommandeService commandeService;
    @MockBean
    CommandeComponent commandeComponent;
    @SpyBean
    CommandeMapper commandeMapper;
    @MockBean
    CommandeRepository commandeRepository;



    @Test
    void getAllCommandesTest(){
        //Given
        CommandeResponseDTO commandeResponseDTO = CommandeResponseDTO
                .builder()
                .reference("aaa")
                .build();
        CommandeResponseDTO commandeResponseDTO1 = CommandeResponseDTO
                .builder()
                .reference("bbb")
                .build();
        //Given
        CommandeResponseDTO commandeResponseDTO2 = CommandeResponseDTO
                .builder()
                .reference("ccc")
                .build();

        List<CommandeResponseDTO> commandeResponseDTOList = new ArrayList<>(Arrays.asList(commandeResponseDTO, commandeResponseDTO1, commandeResponseDTO2));


        List<CommandeEntity> commandeEntities =
                commandeResponseDTOList
                        .stream()
                        .map(commandeMapper::DtoToEntity) // transformer chaque élément de la liste de CommandeResponseDTO
                        .collect(Collectors.toList());      // en CommandeEntity

        when(commandeComponent.getAllCommandes()).thenReturn(commandeEntities);

        List<CommandeResponseDTO> result = commandeService.getAllCommandes();
        assertThat(result).hasSize(3);
        assertThat(result).contains(commandeResponseDTO);
        assertThat(result).contains(commandeResponseDTO1);
        assertThat(result).contains(commandeResponseDTO2);

    }


    @Test
    void getCommandeByReferenceTest(){

        //Given
        CommandeResponseDTO commandeResponseDTO = CommandeResponseDTO
                .builder()
                .reference("aaa")
                .build();
        CommandeResponseDTO commandeResponseDTO1 = CommandeResponseDTO
                .builder()
                .reference("bbb")
                .build();

        CommandeEntity commandeEntity = commandeMapper.DtoToEntity(commandeResponseDTO);
        when(commandeComponent.getCommandeByReference("aaa")).thenReturn(commandeEntity);
        //when
        CommandeResponseDTO result = commandeService.getCommandeByReference("aaa");
        //then
        assertThat(result).isEqualTo( commandeResponseDTO);


        when(commandeComponent.getCommandeByReference("bbb")).thenReturn(null);
        //when
        CommandeResponseDTO result2 = commandeService.getCommandeByReference("bbb");
        //then
        assertThat(result2).isNull();
    }


    @Test
    void  updateCommandeTest(){
        //Given

        CommandeResponseDTO commandeResponseDTO = CommandeResponseDTO
                .builder()
                .reference("aaa")
                .etat(EtatsDeCommande.PLANIFIEE)
                .commentaire("belle")
                .build();
        CommandeResponseDTO commandeResponseDTOExp = CommandeResponseDTO
                .builder()
                .reference("aaa")
                .etat(EtatsDeCommande.ENLIVRAISON)
                .commentaire("belle")
                .build();



        CommandeResponseDTO commandeResponseDT1 = CommandeResponseDTO
                .builder()
                .reference("bbb")
                .etat(EtatsDeCommande.PLANIFIEE)
                .commentaire("lavie")
                .build();
        CommandeResponseDTO commandeResponseDT1Exp = CommandeResponseDTO
                .builder()
                .reference("bbb")
                .etat(EtatsDeCommande.PLANIFIEE)
                .commentaire("admise")
                .build();
        CommandeResponseDTO commandeResponseDT1Exp3 = CommandeResponseDTO
                .builder()
                .reference("eee")
                .etat(EtatsDeCommande.LIVREE)
                .commentaire("ajournee")
                .build();



        CommandeUpdateRequest commandeUpdateRequest0 = CommandeUpdateRequest
                .builder()
                .reference("aaa")
                .etat(EtatsDeCommande.ENLIVRAISON)
                .build();

        CommandeUpdateRequest commandeUpdateRequest2 = CommandeUpdateRequest
                .builder()
                .reference("ccc")
                .etat(EtatsDeCommande.ENLIVRAISON)
                .build();

        CommandeUpdateRequest commandeUpdateRequest1 = CommandeUpdateRequest
                .builder()
                .reference("ddd")
                .commentaire("admise")
                .build();

        CommandeUpdateRequest commandeUpdateRequest3 = CommandeUpdateRequest
                .builder()
                .reference("eee")
                .etat(EtatsDeCommande.LIVREE)
                .commentaire("ajournee")
                .build();

        CommandeEntity commandeEntityRequest = commandeMapper.updateRequestToEntity(commandeUpdateRequest0);
        CommandeEntity commandeEntityGet = commandeMapper.DtoToEntity(commandeResponseDTO);
        String referenceCommande = commandeResponseDTO.getReference();
        CommandeEntity commandeEntityResponse = commandeMapper.DtoToEntity(commandeResponseDTOExp);

        when(  commandeComponent.updateCommande( referenceCommande, commandeEntityRequest ) )
                .thenReturn(commandeEntityResponse);
        when(commandeComponent.getCommandeByReference(referenceCommande)).thenReturn(commandeEntityGet);
        //when
        CommandeResponseDTO result0 = commandeService.updateCommande(referenceCommande, commandeUpdateRequest0);
        //then
        assertThat(result0.getEtat()).isEqualTo(EtatsDeCommande.ENLIVRAISON);


        CommandeEntity commandeEntityRequest2 = commandeMapper.updateRequestToEntity(commandeUpdateRequest2);
        CommandeEntity commandeEntityGet2 = commandeMapper.DtoToEntity(commandeResponseDTO);
        String referenceCommande2 = commandeResponseDTO.getReference();
        CommandeEntity commandeEntityResponse2 = commandeMapper.DtoToEntity(commandeResponseDTOExp);
        when(  commandeComponent.updateCommande(referenceCommande2, commandeEntityRequest2 ) )
                .thenReturn(commandeEntityResponse2);
        when(commandeComponent.getCommandeByReference(referenceCommande2)).thenReturn(commandeEntityGet2);
        //when
        CommandeResponseDTO result2 = commandeService.updateCommande(referenceCommande2, commandeUpdateRequest2);
        //then
        assertThat(result2.getReference()).isEqualTo("aaa");
        assertThat(result2.getEtat()).isEqualTo(EtatsDeCommande.ENLIVRAISON);


        CommandeEntity commandeEntityRequest1 = commandeMapper.updateRequestToEntity(commandeUpdateRequest1);
        CommandeEntity commandeEntityGet1 = commandeMapper.DtoToEntity(commandeResponseDTO);
        String referenceCommande1 = commandeResponseDT1.getReference();
        CommandeEntity commandeEntityResponse1 = commandeMapper.DtoToEntity(commandeResponseDT1Exp);
        when(  commandeComponent.updateCommande(referenceCommande1, commandeEntityRequest1 ) )
                .thenReturn(commandeEntityResponse1);
        when(commandeComponent.getCommandeByReference(referenceCommande1)).thenReturn(commandeEntityGet1);
        //when
        CommandeResponseDTO result1 = commandeService.updateCommande(referenceCommande1, commandeUpdateRequest1);
        //then
        assertThat(result1.getCommentaire()).isEqualTo("admise");


        CommandeEntity commandeEntityRequest3 = commandeMapper.updateRequestToEntity(commandeUpdateRequest3);
        CommandeEntity commandeEntityGet3 = commandeMapper.DtoToEntity(commandeResponseDTO);
        String referenceCommande3 = commandeResponseDT1.getReference();
        CommandeEntity commandeEntityResponse3 = commandeMapper.DtoToEntity(commandeResponseDT1Exp3);
        when(  commandeComponent.updateCommande(referenceCommande3, commandeEntityResponse3 ) )
                .thenReturn(commandeEntityResponse3);
        when(commandeComponent.getCommandeByReference(referenceCommande3)).thenReturn(commandeEntityGet3);
        //when
        CommandeResponseDTO result3 = commandeService.updateCommande(commandeMapper.DtoToEntity(commandeResponseDT1).getReference(), commandeUpdateRequest3);
        //then
        assertThat(result3).isEqualTo(commandeResponseDT1Exp3);

    }



}
