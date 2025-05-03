package monprojet.main;

import p0.*;
import p1.*;
import monprojet.enums.*;
import java.util.*;

public class MenuAdmin {
    
    public static void afficherMenuAdmin(Administration admin, Scanner scanner) {
        boolean retour = false;
        
        while (!retour) {
            System.out.println("\n===== Menu Administrateur =====");
            System.out.println("1. Afficher les statistiques");
            System.out.println("2. Afficher les courses en cours");
            System.out.println("3. Afficher top chauffeurs");
            System.out.println("4. Afficher utilisateurs à surveiller");
            System.out.println("5. Bannir un utilisateur");
            System.out.println("6. Gérer les comptes administrateur");
            System.out.println("7. Déconnexion");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            
            switch (choix) {
                case 1:
                    admin.afficherStatistiques();
                    break;
                case 2:
                    admin.afficherCoursesEnCours();
                    break;
                case 3:
                    System.out.print("Nombre de chauffeurs à afficher : ");
                    int limit = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    admin.afficherTopChauffeurs(limit);
                    break;
                case 4:
                    admin.afficherPiresUtilisateurs(2.5); // Seuil à 2.5/5
                    break;
                case 5:
                    // Code pour bannir un utilisateur
                    // ...
                    break;
                case 6:
                    // Code pour gérer les comptes admin
                    // ...
                    break;
                case 7:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}
