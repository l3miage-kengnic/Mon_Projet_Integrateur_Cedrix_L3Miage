package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
@Component
@RequiredArgsConstructor
public class EntrepotCSVImporter {
    private final EntrepotRepository entrepotRepository;

    @PostConstruct
    public void importEntrepotData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Entrepôts.csv";
        String line;
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignorer la ligne d'en-tête

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSeparator);

                // Vérifiez que la ligne contient toutes les données nécessaires
                if (fields.length < 8) {
                    continue; // Ignorer les lignes incomplètes
                }

                Adresse adresse = new Adresse(fields[3], fields[4], fields[5]); // Adresse, code postal, ville
                double latitude = Double.parseDouble(fields[6]);
                double longitude = Double.parseDouble(fields[7]);
                GeoPosition position = new GeoPosition(latitude, longitude);

                EntrepotEntity entrepot = new EntrepotEntity();
                entrepot.setName(fields[0]); // Identifiant unique de l'entrepôt
                entrepot.setLettre(fields[1]); // Lettre d'identification
                entrepot.setPhoto(fields[2]); // Photo de l'entrepôt
                entrepot.setAdresse(adresse); // Assigner l'objet Adresse
                entrepot.setPosition(position); // Assigner l'objet GeoPosition

                entrepotRepository.save(entrepot); // Sauvegarder l'entrepôt

                System.out.println("Entrepôt ajouté : " + fields[0]); // Ajout d'un log pour le suivi
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gérer les exceptions liées au fichier
        }
    }


}
