package com.ptut.fitrainer;

/**
 * Created by Antoine DE LA FUENTE on 4/6/21.
 */

public class Utilisateur {

    private String pseudo;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private int    taille;
    private int    poids;
    private String sexe;
    private String condition;
    private boolean isEmpty = true;

    private static Utilisateur instance = new Utilisateur();
    private Utilisateur() {}
    public static Utilisateur getInstance() { return instance; }

    public void init(String pseudo, String nom, String prenom, String dateNaissance, int taille, int poids, String sexe, String condition) {
        if (isEmpty) {
            this.pseudo = pseudo;
            this.nom = nom;
            this.prenom = prenom;
            this.dateNaissance = dateNaissance;
            this.taille = taille;
            this.poids = poids;
            this.sexe = sexe;
            this.condition = condition;
            this.isEmpty = false;
        }
    }

    public void delete() {
        this.pseudo = "";
        this.nom = "";
        this.prenom = "";
        this.dateNaissance = "";
        this.taille = 0;
        this.poids = 0;
        this.sexe = "";
        this.condition = "";
        this.isEmpty = true;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getTaille() {
        return taille;
    }

    public int getPoids() {
        return poids;
    }

    public String getSexe() {
        return sexe;
    }

    public String getCondition() {
        return condition;
    }
}
