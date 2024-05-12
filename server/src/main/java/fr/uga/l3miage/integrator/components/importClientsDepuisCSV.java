package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import fr.uga.l3miage.integrator.models.ClientEntity;
import fr.uga.l3miage.integrator.repositories.ClientRepository;
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
public class importClientsDepuisCSV {

    private final ClientRepository clientRepository;

    @PostConstruct
    public void importClientsDepuisCSV() {
        String csvFileName = "/Export_Clients.csv";
        List<ClientEntity> clients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFileName)))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                ClientEntity client = mapLigneVersClientEntity(line);
                clients.add(client);
                clientRepository.save(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ClientEntity mapLigneVersClientEntity(String ligne) {
        String[] fields = ligne.split(",");
        if (fields.length < 8) {//9 probleme de commande
            throw new IllegalArgumentException("Données CSV incomplètes : " + ligne);
        }
        ClientEntity client = new ClientEntity();
        client.setEmail(fields[0].trim());
        client.setPrenom(fields[1].trim());
        client.setNom(fields[2].trim());
        Adresse adresse = new Adresse(fields[3].trim(), fields[4].trim(), fields[5].trim());
        client.setAdresse(adresse);
        GeoPosition position = new GeoPosition(Double.parseDouble(fields[6]), Double.parseDouble(fields[7]));
        client.setPosition(position);
        // Add other fields as per your requirement
        return client;
    }
}
