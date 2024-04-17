import java.util.ArrayList;

public class Utilisateur {
    // Déclaration des attributs
    private String nom; // Le nom de l'utilisateur
    private int numeroIdentification; // Le numéro d'identification de l'utilisateur
    private boolean estAjour; // Pour enregistrer l'état de cotisation de l'utilisateur
    private ArrayList<Livre> livresEmpruntes; // Liste des livres empruntés par l'utilisateur

    // Constructeur de la classe Utilisateur
    public Utilisateur(String nom, int numeroIdentification, boolean estAjour) {
        // Initialisation des attributs avec les valeurs passées en paramètres
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.estAjour = estAjour;
        // Initialisation de la liste des livres empruntés
        this.livresEmpruntes = new ArrayList<>();
    }

    // Méthode pour obtenir le numéro d'identification de l'utilisateur
    public int getNumeroIdentification() {
        return this.numeroIdentification;
    }

    // Méthode pour définir le numéro d'identification de l'utilisateur
    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    // Méthode pour obtenir l'état de cotisation de l'utilisateur
    public boolean isEstAjour() {
        return this.estAjour;
    }

    // Méthode pour définir l'état de cotisation de l'utilisateur
    public void setEstAjour(boolean estAjour) {
        this.estAjour = estAjour;
    }

    // Méthode pour obtenir le nom de l'utilisateur
    public String getNom() {
        return this.nom;
    }

    // Méthode pour emprunter un livre
    public void emprunterLivre(Livre livre) {
        livresEmpruntes.add(livre);
    }

    // Méthode pour retourner un livre
    public void retournerLivre(Livre livre) {
        livresEmpruntes.remove(livre);
    }

    // Méthode pour afficher les livres empruntés par l'utilisateur
    public void afficherLivresEmpruntes() {
        System.out.println("Livres empruntés par " + nom + ":");
        for (Livre livre : livresEmpruntes) {
            System.out.println(livre);
        }
    }

    // Méthode pour rechercher un livre emprunté par titre, auteur ou ISBN
    public Livre rechercherLivreEmprunte(String critere) {
        for (Livre livre : livresEmpruntes) {
            if (livre.getTitre().equals(critere) || livre.getAuteur().equals(critere)
                    || livre.getISBN().equals(critere)) {
                return livre;
            }
        }
        return null; // Aucun livre trouvé avec le critère donné
    }

}
