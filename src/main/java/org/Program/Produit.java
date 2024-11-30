package org.Program;
public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    //Constructeur par defaut
    public Produit(){

    }
    //Constructeur avec tous les attributs
    public Produit(int code, String nom, int quantite, double prix){
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }
    //Getters
    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }
    //Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    //Methode pour calculer la valeur totale d'un produit en stock
    public double calculValeurTotal(){
        return quantite * prix;
    }
    //Méthode toString pour afficher les détails d'un produit
    @Override
    public String toString() {
        return String.format("Code: %d, Nom: %s, Quantité: %d, Prix: %.2f, Valeur Totale: %.2f",
                    code, nom, quantite, prix, calculValeurTotal());
    }
}
