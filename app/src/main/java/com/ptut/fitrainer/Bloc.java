package com.ptut.fitrainer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Antoine DE LA FUENTE on 4/7/21.
 */

public class Bloc implements Parcelable {

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

    protected Bloc(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        duree = in.readInt();
        vitesse = in.readInt();
        intensite = in.readInt();
    }

    public static final Creator<Bloc> CREATOR = new Creator<Bloc>() {
        @Override
        public Bloc createFromParcel(Parcel in) {
            return new Bloc(in);
        }

        @Override
        public Bloc[] newArray(int size) {
            return new Bloc[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeInt(duree);
        dest.writeInt(vitesse);
        dest.writeInt(intensite);
    }
}
