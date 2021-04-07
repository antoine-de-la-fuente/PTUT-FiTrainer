package com.ptut.fitrainer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Entrainement {

    private String nom;
    private int temps;
    private int vitesse;
    private int resistance;
    private ArrayList<Bloc> blocs;

    private SQLiteDatabase db;

    public Entrainement(String nom, int temps, int vitesse, int resistance, String listeIDs, SQLiteDatabase db) {
        this.nom = nom;
        this.temps = temps;
        this.vitesse = vitesse;
        this.resistance = resistance;
        this.db = db;
        this.blocs = new ArrayList<>();
        initBlocs(listeIDs);
    }

    public void initBlocs(String listeIDs) {
        String query = "SELECT * FROM bloc;";
        Cursor curs = db.rawQuery(query, null);

        String[] str = listeIDs.split(" ");
        for(int i = 1; i < listeIDs.length() - 1; i++) {
            if(curs.moveToFirst()) {
                do {
                    if(Integer.parseInt(str[i - 1]) == curs.getInt(curs.getColumnIndexOrThrow("id"))) {
                        blocs.add(new Bloc(curs.getInt(curs.getColumnIndexOrThrow("id")),
                                curs.getString(curs.getColumnIndexOrThrow("nom")),
                                curs.getInt(curs.getColumnIndexOrThrow("duree")),
                                curs.getInt(curs.getColumnIndexOrThrow("vitesse")),
                                curs.getInt(curs.getColumnIndexOrThrow("intensite"))));
                    }
                } while(curs.moveToNext());
            }
        }
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
