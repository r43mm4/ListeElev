# ListeElev

## Description
EleveConnect est une application Java qui se connecte à une base de données MySQL contenant une liste d'élèves et leurs notes. Elle récupère les données et les stocke dans une liste d'objets Eleve pour les afficher.

## Fonctionnalités
- Connexion à une base de données MySQL
- Récupération des informations des élèves (Nom, Matière, Note)
- Stockage des données dans une liste Java
- Affichage des informations récupérées

## Prérequis
- Java 8 ou plus
- MySQL installé et configuré
- Pilote JDBC MySQL (com.mysql.cj.jdbc.Driver)

## Installation
1. Clonez ce dépôt :
   ```sh
   git clone https://github.com/r43mm4/ListeElev.git
   ```
2. Importez le projet dans votre IDE (Eclipse, IntelliJ, etc.).
3. Assurez-vous que le pilote JDBC MySQL est bien inclus dans votre projet.
4. Configurez la base de données avec les informations suivantes :
   - Base de données : `listeeleve`
   - Table : `eleves` avec les colonnes `NomPrenom`, `Matiere`, `Note`

## Configuration de la Base de Données
Exécutez la requête SQL suivante pour créer la base de données et la table :
```sql
CREATE DATABASE listeeleve;
USE listeeleve;

CREATE TABLE eleves (
    id INT AUTO_INCREMENT PRIMARY KEY,
    NomPrenom VARCHAR(255) NOT NULL,
    Matiere VARCHAR(255) NOT NULL,
    Note INT NOT NULL
);
```

## Utilisation
1. Exécutez la classe `EleveConnect.java`.
2. Les informations des élèves seront affichées dans la console.

## Auteurs
-r43mm4


