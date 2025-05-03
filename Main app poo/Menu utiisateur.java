package monprojet.main;

import p0.*;
import p1.*;
import monprojet.enums.*;
import java.util.*;

public class MenuUtilisateur {
    
    public static void afficherMenuUtilisateur(Administration admin, Utilisateur utilisateur, Scanner scanner) {
        boolean retour = false;
        
        while (!retour) {
            System.out.println("\n===== Menu Utilisateur =====");
            System.out.println("Bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom());
            System.out.println("1. Afficher mon profil");
            System.out.println("2. Modifier mon profil");
            System.out.println("3. Créer une course");
            System.out.println("4. Consulter les courses disponibles");
            System.out.println("5. Rejoindre une course");
            System.out.println("6. Afficher mon historique");
            System.out.println("7. Évaluer un utilisateur");
            System.out.println("8. Déconnexion");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            
            switch (choix) {
                case 1:
                    utilisateur.afficherProfil();
                    break;
                case 2:
                    // Code pour modifier le profil
                    // ...
                    break;
                case 3:
                    // Code pour créer une course
                    // ...
                    break;
                case 4:
                    // Code pour consulter les courses disponibles
                    // ...
                    break;
                case 5:
                    // Code pour rejoindre une course
                    // ...
                    break;
                case 6:
                    utilisateur.afficherHistorique();
                    break;
                case 7:
                    // Code pour évaluer un utilisateur
                    // ...
                    break;
                case 8:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}
