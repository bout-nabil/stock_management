package org.Program;
import java.util.Scanner;

public class GestionStock {
    private static final int MAX_PRODUITS = 100;
    private final Produit[] produits = new Produit[MAX_PRODUITS];
    private int compteurProduits = 0;

    public void ajouterProduit(Produit produit) {
        if (compteurProduits >= MAX_PRODUITS) {
            System.out.println("Erreur : La capacité maximale est atteinte.");
            return;
        }
        for (int i = 0; i < compteurProduits; i++) {
            if (produits[i].getCode() == produit.getCode()) {
                System.out.println("Erreur : Le code produit existe déjà.");
                return;
            }
        }
        produits[compteurProduits++] = produit;
        System.out.println("Produit ajouté avec succès !");
    }

    public void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (int i = 0; i < compteurProduits; i++) {
            if (produits[i].getCode() == code) {
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Produit introuvable.");
    }

    public void supprimerProduit(int code) {
        for (int i = 0; i < compteurProduits; i++) {
            if (produits[i].getCode() == code) {
                produits[i] = produits[--compteurProduits];
                System.out.println("Produit supprimé avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Produit introuvable.");
    }

    public void afficherProduits() {
        if (compteurProduits == 0) {
            System.out.println("Aucun produit en stock.");
        } else {
            // Print table header
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %-15s%n", "Code", "Nom", "Quantité", "Prix", "Valeur Totale");
            System.out.println("---------------------------------------------------------------------------");

            // Print each product as a row
            for (int i = 0; i < compteurProduits; i++) {
                Produit produit = produits[i];
                System.out.printf("%-10d | %-20s | %-10d | %-10.2f | %-15.2f%n",
                        produit.getCode(),
                        produit.getNom(),
                        produit.getQuantite(),
                        produit.getPrix(),
                        produit.calculValeurTotal());
            }
        }
    }

    public void rechercherProduit(String nom) {
        for (int i = 0; i < compteurProduits; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println(produits[i]);
                return;
            }
        }
        System.out.println("Erreur : Produit introuvable.");
    }

    public void calculerValeurStock() {
        double valeurTotale = 0;
        for (int i = 0; i < compteurProduits; i++) {
            valeurTotale += produits[i].calculValeurTotal();
        }
        System.out.println("Valeur totale du stock : " + valeurTotale);
    }
}