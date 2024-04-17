public class SessionUtilisateur {
    private static SessionUtilisateur instance; // Instance unique de la classe SessionUtilisateur
    private Utilisateur utilisateurConnecte; // L'utilisateur actuellement connecté

    // Constructeur privé pour empêcher l'instanciation directe de la classe
    private SessionUtilisateur() {
        // Initialisation de la session utilisateur
        // Par exemple, vous pourriez initialiser des paramètres de session ici
        System.out.println("Initialisation de la session utilisateur...");
    }

    // Méthode statique pour obtenir l'instance unique de la classe
    // SessionUtilisateur
    public static SessionUtilisateur getInstance() {
        if (instance == null) {
            instance = new SessionUtilisateur();
        }
        return instance;
    }

    // Méthode pour ouvrir une session pour un utilisateur spécifique
    public void ouvrirSession(Utilisateur utilisateur) {
        this.utilisateurConnecte = utilisateur;
        System.out.println("Session ouverte pour l'utilisateur : " + utilisateur.getNom());
    }

    // Méthode pour fermer la session de l'utilisateur connecté
    public void fermerSession() {
        System.out.println("Session fermée pour l'utilisateur : " + utilisateurConnecte.getNom());
        this.utilisateurConnecte = null;
    }

    // Méthode pour vérifier si un utilisateur est connecté
    public boolean estConnecte() {
        return this.utilisateurConnecte != null;
    }

    // Méthode pour récupérer l'utilisateur connecté
    public Utilisateur getUtilisateurConnecte() {
        return this.utilisateurConnecte;
    }
}
