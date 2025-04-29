package com.universite.covoiturage;

public class administration {

    package com.universite.covoiturage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Administration {
    private List<Utilisateur> utilisateurs;
    private Planning planning;

    public Administration() {
        this.utilisateurs = new ArrayList<>();
        this.planning = new Planning();
    }

    // Méthode pour ajouter un utilisateur a
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            throw new IllegalArgumentException("L'utilisateur ne peut pas être null");
        }
        
        utilisateurs.add(utilisateur);
        System.out.println("Utilisateur " + utilisateur.getNom() + " (ID:" + utilisateur.getID() + ") ajouté avec succès.");
    }

    // Méthode pour supprimer un utilisateur par ID
    public void supprimerUtilisateur(String id) {
        Utilisateur utilisateur = trouverUtilisateurParID(id);
        if (utilisateur != null) {
            utilisateurs.remove(utilisateur);
            System.out.println("Utilisateur ID:" + id + " supprimé avec succès.");
        } else {
            System.out.println("Aucun utilisateur trouvé avec l'ID: " + id);
        }
    }

    // Méthode pourr bannir un utilisateur par ID
    public void bannirUtilisateur(String id) {
        Utilisateur utilisateur = trouverUtilisateurParID(id);
        if (utilisateur != null) {
            utilisateur.setReputation(0); //lol
            utilisateurs.remove(utilisateur);
            System.out.println("Utilisateur ID:" + id + " a été banni pour mauvaise réputation.");
        } else {
            System.out.println("Aucun utilisateur trouvé avec l'ID: " + id);
        }
    }

    // Méthode utilitaire pour trouver un utilisateur par son ID
    private Utilisateur trouverUtilisateurParID(String id) {
        return utilisateurs.stream()
                .filter(u -> u.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Méthode pour afficher les statistiques avec focus sur les IDs
    public void afficherStatistiques() {
        System.out.println("\n=== STATISTIQUES D'UTILISATION ===");
        System.out.println("Nombre total d'utilisateurs: " + utilisateurs.size());
        
        // Statistiques par type d'utilisateur avec exemples d'IDs
        System.out.println("\nDétail par type (3 premiers exemples):");
        
        utilisateurs.stream()
            .limit(3)
            .forEach(u -> System.out.println(
                "- " + u.getClass().getSimpleName() + 
                " ID:" + u.getID() + 
                " Nom:" + u.getNom() + 
                " Réputation:" + u.getReputation()));
    }

    // Méthode pour afficher les meilleurs chauffeurs (par réputation)
    public void afficherTopChauffeurs() {
        System.out.println("\n=== TOP CHAUFFEURS DU MOIS ===");
        List<Utilisateur> chauffeurs = utilisateurs.stream()
            .filter(u -> u.getProfil().getStatut() == Statut.CHAUFFEUR)
            .sorted((u1, u2) -> Double.compare(u2.getReputation(), u1.getReputation()))
            .limit(5)
            .collect(Collectors.toList());
            
        for (int i = 0; i < chauffeurs.size(); i++) {
            Utilisateur u = chauffeurs.get(i);
            System.out.println((i+1) + ". ID:" + u.getID() + 
                             " " + u.getNom() + 
                             " - Réputation: " + u.getReputation());
        }
    }
// Méthode pour afficher les utilisateurs avec la pire réputation
    public void afficherPiresUtilisateurs() {
        System.out.println("\n=== UTILISATEURS À PROBLÈMES ===");
        List<Utilisateur> problemUsers = utilisateurs.stream()
            .sorted((u1, u2) -> Double.compare(u1.getReputation(), u2.getReputation()))
            .limit(5)
            .collect(Collectors.toList());
            
        problemUsers.forEach(u -> 
            System.out.println("- ID:" + u.getID() + 
                             " " + u.getNom() + 
                             " Réputation:" + u.getReputation()));
    }

    // Getters
    public Planning getPlanning() {
        return planning;
    }

    public List<Utilisateur> getUtilisateurs() {
        return new ArrayList<>(utilisateurs);
    }
}
}

