import java.util.ArrayList;
import java.util.HashMap;

public class Bibliothèque {
    // Déclaration des attributs
    private ArrayList<Livre> listeLivres; // Liste des livres dans la bibliothèque
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs; // Map pour suivre les emprunts par utilisateur

    // Constructeur de la bibliothèque
    public Bibliothèque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    // Méthode pour supprimer un livre de la bibliothèque
    public void supprimerLivre(Livre livre) {
        listeLivres.remove(livre);
    }

    // Méthode pour rechercher un livre par titre, auteur ou ISBN
    public Livre rechercherLivre(String critere) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equalsIgnoreCase(critere) || livre.getAuteur().equalsIgnoreCase(critere)
                    || livre.getISBN().equalsIgnoreCase(critere)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    // Méthode pour modifier les détails d'un livre existant
    public void modifierLivre(Livre livre, String nouveauTitre, String nouvelAuteur, int nouvelleAnneePublication,
            String nouveauISBN) {
        if (listeLivres.contains(livre)) {
            // Retrouver l'index du livre dans la liste
            int index = listeLivres.indexOf(livre);

            // Mettre à jour les détails du livre
            livre.setTitre(nouveauTitre);
            livre.setAuteur(nouvelAuteur);
            livre.setAnneePublication(nouvelleAnneePublication);
            livre.setISBN(nouveauISBN);

            // Mettre à jour le livre dans la liste
            listeLivres.set(index, livre);

            System.out.println("Les détails du livre ont été modifiés avec succès.");
        } else {
            System.out.println("Le livre n'existe pas dans la bibliothèque.");
        }
    }

    // Méthode pour emprunter un livre
    public void emprunterLivre(Utilisateur utilisateur, Livre livre) throws LibraryException {
        if (!empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.put(utilisateur, new ArrayList<>());
        }
        // Vérifier si l'utilisateur a atteint sa limite d'emprunts
        if (empruntsUtilisateurs.get(utilisateur).size() == 5) {
            throw new LibraryException("Vous avez atteint votre limite d'emprunts.");
        }
        // Vérifier si l'utilisateur est éligible à emprunter ce livre
        if (!verifierEligibilite(utilisateur, livre)) {
            throw new LibraryException("Vous n'êtes pas éligible à emprunter ce livre.");
        }
        // Ajouter le livre à la liste des emprunts
        empruntsUtilisateurs.get(utilisateur).add(livre);
    }

    // Méthode pour le retour d'un livre
    public void retournerLivre(Utilisateur utilisateur, Livre livre) {
        empruntsUtilisateurs.get(utilisateur).remove(livre);
    }

    // Méthode pour vérifier l'éligibilité des utilisateurs
    public boolean verifierEligibilite(Utilisateur utilisateur, Livre livre) {
        return !empruntsUtilisateurs.containsKey(utilisateur) || !empruntsUtilisateurs.get(utilisateur).contains(livre);
    }

    // Méthode pour afficher les statistiques
    public void afficherStatistiques() {
        System.out.println("Nombre total de livres: " + listeLivres.size());
        int totalEmpruntes = 0;
        for (ArrayList<Livre> livresEmpruntes : empruntsUtilisateurs.values()) {
            totalEmpruntes += livresEmpruntes.size();
        }
        System.out.println("Nombre d'exemplaires empruntés: " + totalEmpruntes);
    }
}
