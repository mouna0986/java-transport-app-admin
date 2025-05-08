package monprojet.main;

import p0.*;
import p1.*;
import monprojet.enums.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("====== Application de Covoiturage - Démarrage ======");
        
        // Récupérer l'instance unique d'Administration (Singleton)
        Administration admin = Administration.getInstance();
        
        // Initialiser des données de test
        Initialisation.initialiserDonneesTest(admin);
        
        // Afficher un menu de connexion
        afficherMenuConnexion(admin);
    }
    
    private static void afficherMenuConnexion(Administration admin) {
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;
        
        while (!quitter) {
            System.out.println("\n===== Menu de Connexion =====");
            System.out.println("1. Connexion Administrateur");
            System.out.println("2. Connexion Utilisateur");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            
            switch (choix) {
                case 1:
                    connecterAdmin(admin, scanner);
                    break;
                case 2:
                    connecterUtilisateur(admin, scanner);
                    break;
                case 3:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
        
        scanner.close();
    }
    
    private static void connecterAdmin(Administration admin, Scanner scanner) {
        System.out.print("Identifiant admin : ");
        String id = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();
        
        if (admin.connexionAdmin(id, mdp)) {
            System.out.println("Connexion réussie en tant qu'administrateur !");
            // Afficher le menu administrateur
            MenuAdmin.afficherMenuAdmin(admin, scanner);
        } else {
            System.out.println("Identifiants incorrects !");
        }
    }
    
    private static void connecterUtilisateur(Administration admin, Scanner scanner) {
        System.out.print("Matricule utilisateur : ");
        String matricule = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();
        
        if (admin.connexionUtilisateur(matricule, mdp)) {
            System.out.println("Connexion réussie !");
            // Rechercher l'utilisateur
            Utilisateur utilisateur = admin.rechercherUtilisateur(matricule);
            // Afficher le menu utilisateur
            MenuUtilisateur.afficherMenuUtilisateur(admin, utilisateur, scanner);
        } else {
            System.out.println("Identifiants incorrects !");
        }
    }
}
