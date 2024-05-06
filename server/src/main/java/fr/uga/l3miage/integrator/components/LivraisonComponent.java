/*package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.repositories.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LivraisonComponent {

    private final LivraisonRepository livraisonRepository;

    public List<LivraisonEntity> getAllLivraisons() {
        return livraisonRepository.findAll();
    }
    public EtatsDeCommande convertToEtatsDeCommande(String csvValue) {
        switch (csvValue.trim().toUpperCase()) {
            case "OUVERTE":
                return EtatsDeCommande.OUVERTE;
            case "PLANIFIEE":
                return EtatsDeCommande.PLANIFIEE;
            case "ENLIVRAISON":
                return EtatsDeCommande.ENLIVRAISON;
            case "LIVREE":
                return EtatsDeCommande.LIVREE;
            case "NOTEE":
                return EtatsDeCommande.NOTEE;
            default:
                throw new IllegalArgumentException("Valeur d'énumération incorrecte: " + csvValue);
        }
    }

    @PostConstruct
    public void importCommandesDepuisCSV() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Commandes.csv";
        String csvSeparator = ",";
        String line; // Déclarez la variable `line` ici

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // Ajustez le format des dates

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignorer la ligne d'en-tête

            // Début du bloc de lecture des lignes
            while ((line = br.readLine()) != null) { // Utilisez `line` ici
                String[] fields = line.split(csvSeparator);

                LivraisonEntity livraison = new LivraisonEntity();
                livraison.setReference(fields[0]);

                // Gestion des exceptions pour les énumérations
                try {
                    EtatsDeLivraison etat = EtatsDeLivraison.valueOf(fields[1].toUpperCase());
                    livraison.setEtat(etat);
                } catch (IllegalArgumentException e) {
                    System.err.println("Valeur d'énumération incorrecte: " + fields[1]);
                    continue; // Passer à la ligne suivante
                }

                livraison.setMontant(Float.parseFloat(fields[2]));
                livraison.setDistanceAParcourir(Float.parseFloat(fields[3]));

                // Gestion des exceptions pour le formatage des dates
                try {
                    Date heureDeLivraisonTheorique = dateFormat.parse(fields[4]);
                    livraison.setHeureDeLivraisonTheorique(heureDeLivraisonTheorique);
                } catch (ParseException e) {
                    System.err.println("Erreur de formatage de date: " + fields[4]);
                    continue; // Passer à la ligne suivante
                }

                livraisonRepository.save(livraison);
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}







package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.repositories.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.text.Normalizer;

@Component
@RequiredArgsConstructor
public class LivraisonComponent {

    private final LivraisonRepository livraisonRepository;

    public List<LivraisonEntity> getAllLivraisons() {
        return livraisonRepository.findAll();
    }


    // Fonction pour supprimer les accents des chaînes
    private String supprimerAccents(String str) {
        String decomposed = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(decomposed).replaceAll("");
    }

    // Fonction pour parser une date à partir d'une chaîne
    private Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return dateFormat.parse(dateString);
    }

    // Fonction pour mapper une ligne de CSV vers une entité Commande
    private CommandeEntity mapLigneVersCommandeEntity(String ligne) {
        String[] fields = ligne.split(",");

        if (fields.length < 7) { // S'assurer que la ligne a suffisamment de données
            throw new IllegalArgumentException("Données CSV incomplètes : " + ligne);
        }

        CommandeEntity commande = new CommandeEntity();
        commande.setReference(fields[0]);

        try {
            commande.setEtat(EtatsDeCommande.valueOf(supprimerAccents(fields[1].trim().toUpperCase())));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur d'énumération incorrecte : " + fields[1]);
        }

        try {
            commande.setDateDeCommande(parseDate(fields[2].trim() + " " + fields[3].trim()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Erreur de formatage de date : " + fields[2] + " " + fields[3]);
        }

        // Autres champs de CommandeEntity à mapper ici...

        return commande;
    }

    @PostConstruct
    public void importCommandesDepuisCSV() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Commandes.csv"; // Ajustez le chemin vers votre CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignorer la ligne d'en-tête
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println("Ligne du CSV : " + line);

                try {
                    CommandeEntity commande = mapLigneVersCommandeEntity(line);
                    // Effectuer des opérations avec commande, par exemple, la conversion en LivraisonEntity
                    // et la sauvegarde dans livraisonRepository
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier CSV : " + e.getMessage());
            e.printStackTrace(); // Pour un traçage détaillé de l'erreur
        }
    }
}



*/
//fonctionne bien

package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.repositories.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.text.Normalizer;

@Component
@RequiredArgsConstructor
public class LivraisonComponent {

    private final LivraisonRepository livraisonRepository;

    public List<LivraisonEntity> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    // Supprimer les guillemets doubles
    private String supprimerGuillemets(String s) {
        return s.replaceAll("^\"|\"$", ""); // Supprimez les guillemets au début et à la fin
    }

    // Supprimer les accents des chaînes
   /* private String supprimerAccents(String str) {
        String decomposed = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(decomposed).replaceAll("");
    }

    // Fonction pour parser une date à partir d'une chaîne
    private LocalDateTime parseDate(String dateString) {
        dateString = dateString.replaceAll("^\"|\"$", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(dateString, formatter);
    }

    // Mapper une ligne de CSV vers une entité Commande
    private CommandeEntity mapLigneVersCommandeEntity(String ligne) {
        String[] fields = ligne.split(","); // Séparateur de CSV

        if (fields.length < 7) { // Assurez-vous qu'il y a suffisamment de données
            throw new IllegalArgumentException("Données CSV incomplètes : " + ligne);
        }

        CommandeEntity commande = new CommandeEntity();
        commande.setReference(fields[0].trim());

        try {
            commande.setEtat(EtatsDeCommande.valueOf(supprimerAccents(fields[1].trim().toUpperCase())));
        } catch (IllegalArgumentException e) {
            System.err.println("Valeur d'énumération incorrecte : " + fields[1]);
        }



        // Ajoutez d'autres champs à mapper si nécessaire

        return commande;
    }*/
    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";
    private static final String QUOTES_REGEX = "^\"|\"$";

    private String supprimerAccents(String str) {
        String decomposed = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(decomposed).replaceAll("");
    }

    private LocalDateTime parseDate(String dateString) {
        dateString = dateString.replaceAll(QUOTES_REGEX, "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDateTime.parse(dateString, formatter);
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
            throw new IllegalArgumentException("Valeur d'énumération incorrecte : " + fields[1], e);
        }

        // Map other fields here...

        return commande;
    }


    @PostConstruct
    public void importCommandesDepuisCSV() {
        String csvFilePath = "C:\\Users\\Pc\\OneDrive\\Bureau\\ana\\projet-integrateur-2024-serveur-springboot-l3miage-elbouchi - Copie\\server\\src\\main\\java\\fr\\uga\\l3miage\\integrator\\CSV\\Export_Commandes.csv"; // Ajustez le chemin

        /*try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignorer la ligne d'en-tête
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    CommandeEntity commande = mapLigneVersCommandeEntity(line);

                    // Vous pouvez créer des livraisons à partir des commandes
                    List<LivraisonEntity> livraisons = createLivraisonsFromCommande(commande);
                    for (LivraisonEntity livraison : livraisons) {
                        livraisonRepository.save(livraison); // Sauvegardez les livraisons
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier CSV : " + e.getMessage());
            e.printStackTrace(); // Affichez le stack trace complet
        }*/
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Ignore the header line
            String line;

            List<CommandeEntity> commandes = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                try {
                    CommandeEntity commande = mapLigneVersCommandeEntity(line);
                    commandes.add(commande);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            // You can create livraisons from the commandes
            List<LivraisonEntity> livraisons = createLivraisonsFromCommande(commandes);
            for (LivraisonEntity livraison : livraisons) {
                livraisonRepository.save(livraison); // Save the livraisons
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace(); // Display the full stack trace
        }
    }

    // Méthode pour générer des livraisons à partir d'une commande
    /*private List<LivraisonEntity> createLivraisonsFromCommande(CommandeEntity commande) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Par exemple, vous pouvez créer des livraisons à partir des références de commande
        // C'est juste une idée, adaptez selon vos besoins
        LivraisonEntity livraison = new LivraisonEntity();
        livraison.setReference(commande.getReference());
        livraison.setMontant(100.0f); // Définir des valeurs aléatoires ou des valeurs par défaut
        livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Définir l'état de la livraison
        livraisons.add(livraison);

        return livraisons;
    }*/
    /*private List<LivraisonEntity> createLivraisonsFromCommande(CommandeEntity commande) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Generate a random number between 1 and 19
        int numberOfLivraisons = new Random().nextInt(19) + 1;

        for (int i = 0; i < numberOfLivraisons; i++) {
            LivraisonEntity livraison = new LivraisonEntity();
            livraison.setReference(commande.getReference());
            livraison.setMontant(100.0f); // Set random or default values
            livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Set the state of the delivery
            livraison.getCommandes().add(commande); // Add the CommandeEntity to the list of commandes
            livraisons.add(livraison);
        }

        return livraisons;
    }*/
    /*private List<LivraisonEntity> createLivraisonsFromCommande(List<CommandeEntity> commandes) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Generate a random number between 2 and 19
        int numberOfLivraisons = new Random().nextInt(18) + 2;

        for (int i = 0; i < numberOfLivraisons; i++) {
            LivraisonEntity livraison = new LivraisonEntity();
            livraison.setReference("L" + (i+1)); // Set a unique reference for each Livraison
            livraison.setMontant(100.0f); // Set random or default values
            livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Set the state of the delivery

            // Add a subset of CommandeEntity to the list of commandes
            int start = i * commandes.size() / numberOfLivraisons;
            int end = (i + 1) * commandes.size() / numberOfLivraisons;
            List<CommandeEntity> subsetOfCommandes = commandes.subList(start, end);
            for (CommandeEntity commande : subsetOfCommandes) {
                livraison.getCommandes().add(commande);
            }

            livraisons.add(livraison);
        }

        return livraisons;
    }*/
    /*private List<LivraisonEntity> createLivraisonsFromCommande(List<CommandeEntity> commandes) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Generate a random number between 2 and 19
        int numberOfLivraisons = new Random().nextInt(18) + 2;

        for (int i = 0; i < numberOfLivraisons; i++) {
            LivraisonEntity livraison = new LivraisonEntity();
            livraison.setReference("L" + (i+1)); // Set a unique reference for each Livraison
            livraison.setMontant(100.0f); // Set random or default values
            livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Set the state of the delivery

            // Add a subset of CommandeEntity to the list of commandes
            int start = i * commandes.size() / numberOfLivraisons;
            int end = (i + 1) * commandes.size() / numberOfLivraisons;
            List<CommandeEntity> subsetOfCommandes = commandes.subList(start, end);
            for (CommandeEntity commande : subsetOfCommandes) {
                livraison.addCommande(commande);
            }

            livraisons.add(livraison);
        }

        return livraisons;
    }*/
    private List<LivraisonEntity> createLivraisonsFromCommande(List<CommandeEntity> commandes) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Generate a random number between 2 and 19
        int numberOfLivraisons = new Random().nextInt(18) + 2;

        for (int i = 0; i < numberOfLivraisons; i++) {
            LivraisonEntity livraison = new LivraisonEntity();
            livraison.setReference("L" + (i+1)); // Set a unique reference for each Livraison
            livraison.setMontant(100.0f); // Set random or default values
            livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Set the state of the delivery

            // Add a subset of CommandeEntity to the list of commandes
            int start = i * commandes.size() / numberOfLivraisons;
            int end = (i + 1) * commandes.size() / numberOfLivraisons;
            List<CommandeEntity> subsetOfCommandes = commandes.subList(start, end);
            for (CommandeEntity commande : subsetOfCommandes) {
                livraison.addCommande(commande);
            }

            livraisons.add(livraison);
        }

        return livraisons;
    }
}
