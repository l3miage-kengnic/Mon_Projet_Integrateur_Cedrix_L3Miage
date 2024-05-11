package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
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

    /*@PostConstruct
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
    }*/
    private final EmployeRepository employeRepository;
    @PostConstruct
    public void importEntrepotData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie1\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Entrepôts.csv";
        String line;
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignore the header line

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSeparator);

                // Check that the line contains all the necessary data
                if (fields.length < 10) {
                    continue; // Ignore incomplete lines
                }

                Adresse adresse = new Adresse(fields[3], fields[4], fields[5]); // Address, postal code, city
                double latitude = Double.parseDouble(fields[6]);
                double longitude = Double.parseDouble(fields[7]);
                GeoPosition position = new GeoPosition(latitude, longitude);

                EntrepotEntity entrepot = new EntrepotEntity();
                entrepot.setName(fields[0]); // Unique warehouse identifier
                entrepot.setLettre(fields[1]); // Identification letter
                entrepot.setPhoto(fields[2]); // Warehouse photo
                entrepot.setAdresse(adresse); // Assign the Adresse object
                entrepot.setPosition(position); // Assign the GeoPosition object

                // Search for employee by trigramme
                String employeeTrigramme = fields[8];
                EmployeEntity employe = employeRepository.findByTrigramme(employeeTrigramme);
                entrepot.setEmployeEntity(employe); // Set the employee entity

                entrepotRepository.save(entrepot); // Save the warehouse
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file-related exceptions
        }
    }


}

