package Eleve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EleveConnect {

    // Liste statique pour stocker les objets Eleve
    static ArrayList<Eleve> EleveList = new ArrayList<>();

    public EleveConnect() {

        System.out.println("Connexion à la base de données 'listeeleve'...");

        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/listeeleve?allowPublicKeyRetrieval=true&useSSL=false";
        String login = "root";
        String password = "";

        Connection connexion = null;
        Statement requete = null;
        ResultSet resultat = null;

        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données
            connexion = DriverManager.getConnection(url, login, password);

            // Création d'une requête SQL
            requete = connexion.createStatement();
            String query = "SELECT * FROM eleves";

            // Exécution de la requête et récupération des résultats
            resultat = requete.executeQuery(query);

            // Traitement des résultats
            while (resultat.next()) {
                String nomPrenom = resultat.getString("NomPrenom");
                String matiere = resultat.getString("Matiere");
                int note = resultat.getInt("Note");

                System.out.println("Nom : " + nomPrenom);
                System.out.println("Matière : " + matiere);
                System.out.println("Note : " + note);
                
                // Création d'un objet Eleve et ajout à la liste
                Eleve E1 = new Eleve(note, nomPrenom, matiere);
                EleveList.add(E1);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur SQL !");
            e.printStackTrace();
        } finally {
            // Fermeture des ressources pour éviter les fuites
            try {
                if (resultat != null) resultat.close();
                if (requete != null) requete.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Instanciation de l'objet pour exécuter le constructeur
        new EleveConnect();

        // Affichage des objets Eleve dans la liste
        System.out.println("\nListe des élèves :");
        for (Eleve eleve : EleveList) {
            System.out.println(eleve);
        }
    }
}