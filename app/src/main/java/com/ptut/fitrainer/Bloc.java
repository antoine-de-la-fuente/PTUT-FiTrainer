package com.ptut.fitrainer;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Bloc {

    private int id;
    private String nom;
    private int duree;
    private int vitesse;
    private int intensite;

    public Bloc(int id, String nom, int duree, int vitesse, int intensite) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.vitesse = vitesse;
        this.intensite = intensite;
    }

    public int getId() {
        return id;
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
