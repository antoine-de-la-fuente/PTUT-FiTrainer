package com.ptut.fitrainer;

import java.util.ArrayList;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Entrainement {

    private String nom;
    private int temps;
    private int vitesse;
    private int resistance;
    private ArrayList<Bloc> blocs;
    private boolean isEmpty = true;

    private static Entrainement instance = new Entrainement();
    private Entrainement() {}
    public static Entrainement getInstance() { return instance; }

    public void init(String nom, int temps, int vitesse, int resistance, ArrayList<Bloc> blocs) {
        if (isEmpty) {
            this.nom = nom;
            this.temps = temps;
            this.vitesse = vitesse;
            this.resistance = resistance;
            this.blocs = blocs;
            this.isEmpty = false;
        }
    }

    public void delete() {
        this.nom = "";
        this.temps = 0;
        this.vitesse = 0;
        this.resistance = 0;
        this.blocs.clear();
        this.isEmpty = true;
    }

    public String getNom() {
        return nom;
    }

    public int getTemps() {
        return temps;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getResistance() {
        return resistance;
    }

    public ArrayList<Bloc> getBlocs() {
        return blocs;
    }
}
