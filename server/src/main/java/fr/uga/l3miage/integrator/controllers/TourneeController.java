package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.TourneeEndpoints;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEntityRestException;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import fr.uga.l3miage.integrator.services.TourneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class TourneeController implements TourneeEndpoints {

    private final TourneeService tourneeService;

    @Override
    public TourneeResponseDTO getTourneeByReference(String reference){
        return tourneeService.getTourneeByReference(reference);
    }

    @Override
    public creatTournee(String reference){

    }
}
