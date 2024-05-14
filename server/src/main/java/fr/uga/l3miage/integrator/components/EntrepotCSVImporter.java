package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/***************************************Cedrix****





@Component
@RequiredArgsConstructor
@DependsOn("entrepotCSVImporter")
public class CSVImporter {

    private final EmployeRepository employeRepository;
    private final EntrepotRepository entrepotRepository; // Ajouter le dépôt pour les entrepôts



    @PostConstruct

    public void importEmployeData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie1\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Employes.csv";

    public void importEntrepotData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Entrepôts.csv";
        SpringTest
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
                employe.setEmploi(Emploi.valueOf(fields[5].toUpperCase()));
                //employe.setEntrepot(fields[6]);
                //employe.setTournees(fields[7]);
                // Search for warehouse by name
                //String entrepotName = fields[6];
                //EntrepotEntity entrepot = entrepotRepository.findByName(entrepotName);
                //employe.setEntrepotEntity(entrepot);
                employe.setEntrepotEntity(entrepotRepository.findByName(fields[6]));//a revoir pourquoi quand j´ajoute ca ca m´affiche plus livreur et plann







                employeRepository.save(employe);
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}



/*
@Component
@RequiredArgsConstructor
@DependsOn("entrepotCSVImporter")
public class CSVImporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVImporter.class);
    private final EmployeRepository employeRepository;
    private final EntrepotRepository entrepotRepository; // Ajouter le dépôt pour les entrepôts

    @PostConstruct
    public void importEmployeData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Employes.csv"; // Assurez-vous que le chemin est correct

    }***********/





/***************************Cedrix


import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.models.EntrepotEntity;

import javax.annotation.PostConstruct;//private final EmployeRepository employeRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.data.jpa.repository.JpaRepository;


@PostConstruct
    public void importEntrepotData() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie1\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Entrepôts.csv";

>>>>>>> SpringTest
        String line;
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignore the header line

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSeparator);

<<<<<<< HEAD
                EmployeEntity employe = new EmployeEntity();
                employe.setTrigramme(fields[0]);
                employe.setPrenom(fields[1]);
                employe.setNom(fields[2]);
                employe.setPhoto(fields[3]);
                employe.setTelephone(fields[4]);
                employe.setEmploi(Emploi.valueOf(fields[5]));

                // Search for warehouse by name
                if (fields.length > 6 && fields[6] != null && !fields[6].isEmpty()) {
                    String entrepotName = fields[6];
                    System.out.println("Searching for warehouse: " + entrepotName);

                    EntrepotEntity entrepot = entrepotRepository.findByName(entrepotName);

                    if (entrepot != null) {
                        employe.setEntrepotEntity(entrepot);
                    } else {
                        System.out.println("Warehouse not found: " + entrepotName);
                    }
                }

                employeRepository.save(employe); // Save the employee
=======
                // Check that the line contains all the necessary data


                if (fields.length < 10) {

                if (fields.length < 8) {


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


                /**
                // Search for employee by trigramme
                String employeeTrigramme = fields[8];
                EmployeEntity employe = employeRepository.findByTrigramme(employeeTrigramme);
                entrepot.setEmployeEntity(employe); // Set the employee entity

                entrepotRepository.save(entrepot); // Save the warehouse

                entrepotRepository.save(entrepot); // Save the warehouse

                System.out.println("Warehouse added: " + fields[0]); // Add a log for tracking

                entrepotRepository.save(entrepot); // Save the warehouse

>>>>>>> SpringTest
            }
        } catch (IOException e) {
            LOGGER.error("Failed to read CSV file at path: " + csvFilePath, e);
            throw new RuntimeException("Failed to import employee data", e);
        }
    }
<<<<<<< HEAD
}*/
