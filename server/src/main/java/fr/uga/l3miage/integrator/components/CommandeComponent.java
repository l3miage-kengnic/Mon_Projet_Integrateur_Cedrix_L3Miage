package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.models.ClientEntity;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.repositories.ClientRepository;
import fr.uga.l3miage.integrator.repositories.CommandeRepository;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.DependsOn;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor



@DependsOn("importClientsDepuisCSV")

public class CommandeComponent {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;

    public List<CommandeEntity> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public CommandeEntity getCommandeByReference(String reference) {
        return commandeRepository.findById(reference).orElse(null);
    }

    public CommandeEntity updateCommande(String reference, CommandeEntity commande) {
        return commandeRepository.save(commande);
    }

    /*public void deleteCommande(String reference) {
        commandeRepository.deleteById(reference);
    }*/


    @PostConstruct
    public void importCommandesDepuisCSV() {
        String csvFileName = "/Export_Commandes.csv";
        List<CommandeEntity> commandes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFileName)))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                CommandeEntity commande = mapLigneVersCommandeEntity(line);
                commandes.add(commande);
                commandeRepository.save(commande);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String supprimerGuillemets(String s) {
        return s.replaceAll("^\"|\"$", "");
    }

    private String supprimerAccents(String str) {
        String decomposed = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(decomposed).replaceAll("");
    }

    private Date parseDate(String dateString) {
        dateString = supprimerGuillemets(dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return java.sql.Date.valueOf(localDate);
    }

    private CommandeEntity mapLigneVersCommandeEntity(String ligne) {
        String[] fields = ligne.split(",");
        if (fields.length < 7) {
            throw new IllegalArgumentException("Données CSV incomplètes : " + ligne);
        }
        CommandeEntity commande = new CommandeEntity();
        commande.setReference(fields[0].trim());
        try {
            commande.setEtat(EtatsDeCommande.valueOf(supprimerAccents(fields[1].trim().toUpperCase())));
        } catch (IllegalArgumentException e) {
            System.err.println("Valeur d'énumération incorrecte : " + fields[1]);
        }
        commande.setDateDeCommande(parseDate(fields[2]));
        // Add other fields as per your requirement

        String email = fields[6].trim();
        //System.out.println("Email extracted: " + email);
        ClientEntity client = clientRepository.findByEmail(email);
        if (client != null) {
            commande.setClientEntity(client);
        } else {
            System.err.println("Client not found with email : " + email);
        }

        return commande;
    }


}

