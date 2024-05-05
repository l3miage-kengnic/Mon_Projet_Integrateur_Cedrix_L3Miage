package fr.uga.l3miage.integrator.controllers;

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
public class TourneeController {

    private final TourneeService tourneeService;

    Set<TourneeResponseDTO> getTourneeByReference(@RequestParam String reference){
        return tourneeService
    }
}
