import java.util.Scanner;

public class GestionStock {
    private static final int TAILLE_MAX = 100;
    private static Produit[] produits = new Produit[TAILLE_MAX];
    private static int nbProduits = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1: ajouterProduit(scanner); break;
                case 2: modifierProduit(scanner); break;
                case 3: supprimerProduit(scanner); break;
                case 4: afficherProduits(); break;
                case 5: rechercherProduit(scanner); break;
                case 6: calculerValeurStock(); break;
                case 0: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("\n--- Menu Gestion de Stock ---");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher les produits");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    public static void ajouterProduit(Scanner scanner) {
        if (nbProduits >= TAILLE_MAX) {
            System.out.println("Erreur : le stock est plein.");
            return;
        }

        System.out.print("Code produit : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom produit : ");
        String nom = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prix = scanner.nextDouble();

        produits[nbProduits] = new Produit(code, nom, quantite, prix);
        nbProduits++;
        System.out.println("Produit ajouté avec succès.");
    }

    public static void modifierProduit(Scanner scanner) {
        System.out.print("Code produit à modifier : ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Produit produit = trouverProduitParCode(code);
        if (produit == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        System.out.print("Nouveau nom : ");
        String nouveauNom = scanner.nextLine();
        System.out.print("Nouvelle quantité : ");
        int nouvelleQuantite = scanner.nextInt();
        System.out.print("Nouveau prix unitaire : ");
        double nouveauPrix = scanner.nextDouble();

        produit.setNom(nouveauNom);
        produit.setQuantite(nouvelleQuantite);
        produit.setPrix(nouveauPrix);
        System.out.println("Produit modifié avec succès.");
    }

    public static void supprimerProduit(Scanner scanner) {
        System.out.print("Code produit à supprimer : ");
        int code = scanner.nextInt();

        for (int i = 0; i < nbProduits; i++) {
            if (produits[i].getCode() == code) {
                for (int j = i; j < nbProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[--nbProduits] = null;
                System.out.println("Produit supprimé avec succès.");
                return;
            }
        }

        System.out.println("Produit introuvable.");
    }

    public static void afficherProduits() {
        if (nbProduits == 0) {
            System.out.println("Aucun produit en stock.");
            return;
        }

        for (int i = 0; i < nbProduits; i++) {
            System.out.println(produits[i]);
        }
    }

    public static void rechercherProduit(Scanner scanner) {
        System.out.print("Nom du produit à rechercher : ");
        String nomRecherche = scanner.nextLine();

        for (Produit produit : produits) {
            if (produit != null && produit.getNom().equalsIgnoreCase(nomRecherche)) {
                System.out.println(produit);
                return;
            }
        }

        System.out.println("Produit introuvable.");
    }

    public static void calculerValeurStock() {
        double valeurTotale = 0;
        for (Produit produit : produits) {
            if (produit != null) {
                valeurTotale += produit.calculerValeurTotale();
            }
        }
        System.out.printf("Valeur totale du stock : %.2f\n", valeurTotale);
    }

    private static Produit trouverProduitParCode(int code) {
        for (Produit produit : produits) {
            if (produit != null && produit.getCode() == code) {
                return produit;
            }
        }
        return null;
    }
}
