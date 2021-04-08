package com.ptut.fitrainer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Entrainement implements Parcelable {

    private String nom;
    private int vitesse;
    private int resistance;
    private ArrayList<Bloc> blocs;

    private SQLiteDatabase db;

    public Entrainement(String nom, int vitesse, int resistance, String listeIDs, SQLiteDatabase db) {
        this.nom = nom;
        this.vitesse = vitesse;
        this.resistance = resistance;
        this.db = db;
        this.blocs = new ArrayList<>();
        initBlocs(listeIDs);
    }

    protected Entrainement(Parcel in) {
        nom = in.readString();
        vitesse = in.readInt();
        resistance = in.readInt();
    }

    public static final Creator<Entrainement> CREATOR = new Creator<Entrainement>() {
        @Override
        public Entrainement createFromParcel(Parcel in) {
            return new Entrainement(in);
        }

        @Override
        public Entrainement[] newArray(int size) {
            return new Entrainement[size];
        }
    };

    private void initBlocs(String listeIDs) {
        String query = "SELECT * FROM bloc;";
        Cursor curs = db.rawQuery(query, null);

        String[] str = listeIDs.split(" ");
        for(String id : str) {
            if(curs.moveToFirst()) {
                do {
                    if(Integer.parseInt(id) == curs.getInt(curs.getColumnIndexOrThrow("id"))) {
                        blocs.add(new Bloc(curs.getInt   (curs.getColumnIndexOrThrow("id")),
                                           curs.getString(curs.getColumnIndexOrThrow("nom")),
                                           curs.getInt   (curs.getColumnIndexOrThrow("duree")),
                                           curs.getInt   (curs.getColumnIndexOrThrow("vitesse")),
                                           curs.getInt   (curs.getColumnIndexOrThrow("intensite"))));
                    }
                } while(curs.moveToNext());
            }
        }
    }

    public String getNom() {
        return nom;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(vitesse);
        dest.writeInt(resistance);
    }
}
