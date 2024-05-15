package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.DataType.GeoPosition;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundCamionEntityException;
import fr.uga.l3miage.integrator.models.CamionEntity;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.CamionRepository;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
//@DependsOn(EntrepotComponent)
public class CamionComponent {

    private final CamionRepository camionRepository;
    private final EntrepotRepository entrepotRepository;

    public List<CamionEntity> getAllCamions() throws NotFoundCamionEntityException{

        try {
            return camionRepository.findAll();
        }catch (Exception e){
            throw new NotFoundCamionEntityException(String.format("Aucun camion trouvé"));
        }

    }



    @PostConstruct
    public void importCamionsDepuisCSV() {
        String csvFileName = "/Export_Camions.csv";
        List<CamionEntity> camions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFileName)))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                CamionEntity camion = mapLigneVersCamionEntity(line);
                camions.add(camion);
                camionRepository.save(camion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CamionEntity mapLigneVersCamionEntity(String ligne) {
        String[] fields = ligne.split(",");
        if (fields.length < 4) {
            throw new IllegalArgumentException("Données CSV incomplètes : " + ligne);
        }
        CamionEntity camion = new CamionEntity();
        camion.setImmatriculation(fields[0].trim());
        GeoPosition position = new GeoPosition();
        if (!fields[1].trim().isEmpty()) {
            position.setLatitude(Double.parseDouble(fields[1].trim()));
        }
        if (!fields[2].trim().isEmpty()) {
            position.setLongitude(Double.parseDouble(fields[2].trim()));
        }
        camion.setPosition(position);
        String name = fields[3].trim();
        EntrepotEntity entrepot = entrepotRepository.findByName(name);
        if (entrepot != null) {
            camion.setEntrepotEntity(entrepot);
        } else {
            System.err.println("Entrepot not found with name : " + fields[3]);
        }
        return camion;
    }
}
