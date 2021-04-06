package com.ptut.fitrainer;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Bloc {
    private String nom;
    private int duree;
    private int vitesse;
    private int intensite;
    private boolean isEmpty = true;

    public Bloc(String nom, int duree, int vitesse, int intensite) {
        if(isEmpty) {
            this.nom = nom;
            this.duree = duree;
            this.vitesse = vitesse;
            this.intensite = intensite;
            this.isEmpty = false;
        }
    }

    public String getNom() {
        return nom;
    }

    public int getDuree() {
        return duree;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getIntensite() {
        return intensite;
    }

}
