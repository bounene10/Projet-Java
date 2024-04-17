import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliothèque bibliotheque = new Bibliothèque();
        boolean continuer = true;

        // Boucle principale du programme
        while (continuer) {
            // Affichage du menu principal
            System.out.println("Menu Principal:");
            System.out.println("1. Rechercher un livre");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre");
            System.out.println("4. Ajouter un livre");
            System.out.println("5. Modifier un livre existant");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            // Lecture de l'option choisie par l'utilisateur
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            // Switch sur l'option choisie
            switch (choix) {
                case 1:
                    rechercherLivre(scanner, bibliotheque);
                    break;
                case 2:
                    emprunterLivre(scanner, bibliotheque);
                    break;
                case 3:
                    retournerLivre(scanner, bibliotheque);
                    break;
                case 4:
                    ajouterLivre(scanner, bibliotheque);
                    break;
                case 5:
                    modifierLivre(scanner, bibliotheque);
                    break;
                case 6:
                    continuer = false;
                    System.out.println("Merci d'avoir utilisé notre système de gestion de bibliothèque!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }

        scanner.close();
    }

    // Méthode pour rechercher un livre
    private static void rechercherLivre(Scanner scanner, Bibliothèque bibliotheque) {
        // Code pour rechercher un livre
        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre : ");
        String critere = scanner.nextLine();
        Livre livre = bibliotheque.rechercherLivre(critere);
        if (livre != null) {
            System.out.println("Livre trouvé : " + livre);
        } else {
            System.out.println("Aucun livre trouvé.");
        }
    }

    // Méthode pour emprunter un livre
    private static void emprunterLivre(Scanner scanner, Bibliothèque bibliotheque) {
        // Code pour emprunter un livre
        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à emprunter : ");
        String critere = scanner.nextLine();
        Livre livre = bibliotheque.rechercherLivre(critere);
        if (livre != null) {
            // Supposons que vous ayez déjà l'utilisateur actuellement connecté
            Utilisateur utilisateur = getUtilisateurConnecte();
            try {
                bibliotheque.emprunterLivre(utilisateur, livre);
            } catch (LibraryException e) {
                System.out.println("Erreur lors de l'emprunt du livre : " + e.getMessage());
            }

        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    // Méthode pour retourner un livre
    private static void retournerLivre(Scanner scanner, Bibliothèque bibliotheque) {
        // Code pour retourner un livre
        // Supposons que vous ayez déjà l'utilisateur actuellement connecté
        Utilisateur utilisateur = getUtilisateurConnecte();
        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à retourner : ");
        String critere = scanner.nextLine();

        Livre livre = utilisateur.rechercherLivreEmprunte(critere);

        if (livre != null) {
            bibliotheque.retournerLivre(utilisateur, livre);
        } else {
            System.out.println("Vous n'avez pas emprunté ce livre.");
        }
    }

    // Méthode pour ajouter un livre à la bibliothèque
    private static void ajouterLivre(Scanner scanner, Bibliothèque bibliotheque) {
        // Code pour ajouter un livre
        System.out.println("Ajout d'un nouveau livre :");
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("Année de publication : ");
        int anneePublication = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne
        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        Livre nouveauLivre = new Livre(titre, auteur, anneePublication, isbn);
        bibliotheque.ajouterLivre(nouveauLivre);
        System.out.println("Livre ajouté avec succès !");
    }

    // Méthode pour récupérer l'utilisateur connecté
    private static Utilisateur getUtilisateurConnecte() {
        // Code pour récupérer l'utilisateur connecté
        // Supposons que vous ayez une classe de gestion des sessions utilisateur
        SessionUtilisateur session = SessionUtilisateur.getInstance();
        if (session.estConnecte()) {
            return session.getUtilisateurConnecte();
        } else {
            System.out.println("Aucun utilisateur connecté.");
            return null;
        }
    }

    // Méthode pour modifier un livre existant dans la bibliothèque
    private static void modifierLivre(Scanner scanner, Bibliothèque bibliotheque) {
        // Code pour modifier un livre
        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à modifier : ");
        String critere = scanner.nextLine();
        Livre livre = bibliotheque.rechercherLivre(critere);
        if (livre != null) {
            // Récupérer les nouvelles informations sur le livre
            System.out.print("Nouveau titre : ");
            String nouveauTitre = scanner.nextLine();
            System.out.print("Nouvel auteur : ");
            String nouvelAuteur = scanner.nextLine();
            System.out.print("Nouvelle année de publication : ");
            int nouvelleAnneePublication = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne
            System.out.print("Nouveau ISBN : ");
            String nouveauISBN = scanner.nextLine();

            // Appeler la méthode de modification du livre dans la bibliothèque
            bibliotheque.modifierLivre(livre, nouveauTitre, nouvelAuteur, nouvelleAnneePublication, nouveauISBN);
        } else {
            System.out.println("Livre non trouvé.");
        }
    }
}
