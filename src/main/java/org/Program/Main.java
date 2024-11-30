package org.Program;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionStock gestionStock = new GestionStock();
        Produit produits = new Produit();
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            printMenu();
            System.out.print("Choisi une opération (0 pour quitter): ");
            if (sc.hasNextInt()){
                choix = sc.nextInt();
                if (choix == 0) {
                    System.out.println("Quitter l'application.");
                    break;
                }
                switch (choix) {
                    case 1:
                        // Demander les informations du produit
                        System.out.println("Ajout d'un nouveau produit...............");
                        System.out.print("Code : ");
                        produits.setCode(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nom : ");
                        produits.setNom(sc.nextLine());
                        System.out.print("Quantité : ");
                        produits.setQuantite(sc.nextInt());
                        System.out.print("Prix : ");
                        produits.setPrix(sc.nextInt());
                        gestionStock.ajouterProduit(produits);
                        break;
                    case 2:
                        System.out.print("Code du produit à modifier : ");
                        produits.setCode(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nouveau nom : ");
                        produits.setNom(sc.nextLine());
                        System.out.print("Nouvelle quantité : ");
                        produits.setQuantite(sc.nextInt());
                        System.out.print("Nouveau prix : ");
                        produits.setPrix(sc.nextInt());
                        gestionStock.modifierProduit(produits.getCode(), produits.getNom(), produits.getQuantite(), produits.getPrix());
                        break;
                    case 3:
                        System.out.println("Supprimer un produit...............");
                        System.out.print("Code du produit à supprimer : ");
                        produits.setCode(sc.nextInt());
                        gestionStock.supprimerProduit(produits.getCode());
                        break;
                    case 4:
                        System.out.println("Liste des produits...............");
                        gestionStock.afficherProduits();
                        break;
                    case 5:
                        System.out.println("Rechercher un produit...............");
                        System.out.print("Nom du produit à rechercher : ");
                        produits.setNom(sc.nextLine());
                        gestionStock.rechercherProduit(produits.getNom());
                        break;
                    case 6:
                        System.out.println("La valeur total des produits...............");
                        gestionStock.calculerValeurStock();
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            }else {
                    System.out.println("Entrée invalide, veuillez entrer un nombre.");
                    sc.next(
                    );
                    choix = -1;
                }
        } while (choix != 0);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("====================================");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste de produits");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("0. Quitter");
    }
}