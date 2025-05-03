package monprojet.main;

import p0.*;
import p1.*;
import monprojet.enums.*;
import java.util.*;

public class Initialisation {
    
    public static void initialiserDonneesTest(Administration admin) {
        // Créer quelques utilisateurs de test
        
        // 1. Créer des profils
        Preferences prefsEtudiant = new Preferences();
        prefsEtudiant.ajouterPreference("musique", "pop");
        prefsEtudiant.ajouterPreference("conversation", "détendue");
        
        List<JourSemaine> joursEtudiant = Arrays.asList(JourSemaine.LUNDI, JourSemaine.MERCREDI, JourSemaine.VENDREDI);
        Disponibilites dispoEtudiant = new Disponibilites(joursEtudiant, "08:00", DisponibiliteType.REGULIER);
        
        Itineraire itinEtudiant = new Itineraire("Résidence Universitaire", "Campus Sciences");
        
        Profil profilEtudiant = new Profil(Statut.EN_COURS, TypeCourse.COVOITURAGE, 
                                          itinEtudiant, prefsEtudiant, dispoEtudiant);
        
        // 2. Créer des utilisateurs
        Etudiant etudiant1 = new Etudiant("Dupont", "Marie", "E12345", 
                                          profilEtudiant, 2023, "Sciences", "Informatique");
        
        // 3. Ajouter à l'administration
        admin.ajouterUtilisateur(etudiant1);
        admin.ajouterCompteUtilisateur("E12345", "motdepasse123");
        
        // Ajouter d'autres utilisateurs, courses, etc.
        // ...
    }
}
