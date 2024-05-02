package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CSVImporter {

    private final EmployeRepository employeRepository;
    private final EntrepotRepository entrepotRepository;


    @PostConstruct
    public void importEmployeData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Employes.csv";
        String line;
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignorer la ligne d'en-tête

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSeparator);

                EmployeEntity employe = new EmployeEntity();
                employe.setTrigramme(fields[0]);
                employe.setPrenom(fields[1]);
                employe.setNom(fields[2]);
                employe.setPhoto(fields[3]);
                employe.setTelephone(fields[4]);
                employe.setEmploi(Emploi.valueOf(fields[5]));
                //employe.setEntrepot(fields[6]);
                //employe.setTournees(fields[7]);



                employeRepository.save(employe);
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

