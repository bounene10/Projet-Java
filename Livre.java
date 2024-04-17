public class Livre {
    // Déclaration des attributs
    private String titre; // Le titre du livre
    private String auteur; // L'auteur du livre
    private String ISBN; // Le numéro ISBN du livre
    private int anneePublication; // L'année de publication du livre

    // Constructeur de la classe Livre
    public Livre(String titre, String auteur, int anneePublication, String ISBN) {
        // Initialisation des attributs avec les valeurs passées en paramètres
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }

    // Méthode pour obtenir le titre du livre
    public String getTitre() {
        return titre;
    }

    // Méthode pour définir le titre du livre
    public void setTitre(String titre) {
        this.titre = titre;
    }

    // Méthode pour obtenir l'auteur du livre
    public String getAuteur() {
        return auteur;
    }

    // Méthode pour définir l'auteur du livre
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    // Méthode pour obtenir l'année de publication du livre
    public int getAnneePublication() {
        return anneePublication;
    }

    // Méthode pour définir l'année de publication du livre
    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    // Méthode pour obtenir le numéro ISBN du livre
    public String getISBN() {
        return ISBN;
    }

    // Méthode pour définir le numéro ISBN du livre
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Méthode pour obtenir une représentation textuelle du livre
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    // Méthode pour vérifier si le livre correspond à un critère donné (titre ou
    // auteur)
    public boolean match(String critere) {
        // Conversion en minuscules pour une comparaison insensible à la casse
        String critereLowerCase = critere.toLowerCase();
        String titreLowerCase = titre.toLowerCase();
        String auteurLowerCase = auteur.toLowerCase();

        // Vérification si le critère correspond au titre ou à l'auteur du livre
        return titreLowerCase.contains(critereLowerCase) || auteurLowerCase.contains(critereLowerCase);
    }
}
