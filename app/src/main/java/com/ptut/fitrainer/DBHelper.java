package com.ptut.fitrainer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Antoine DE LA FUENTE on 4/5/21.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "fitrainer.db";

    public static final String SQL_CREATE_USERS =
            "CREATE TABLE utilisateur(id INTEGER PRIMARY KEY NOT NULL, " +
                    "pseudo TEXT, email TEXT, motDePasse TEXT, prenom TEXT, nom TEXT, dateNaissance TEXT, " +
                    "taille INTEGER, poids INTEGER, sexe TEXT, condition TEXT);";
    public static final String SQL_CREATE_ADMIN =
            "INSERT INTO utilisateur(pseudo, email, motDePasse, prenom, nom, dateNaissance, taille, poids, sexe, condition)" +
                    "VALUES('admin', 'admin@admin.com', 'admin', 'admin', 'istrateur', '01/01/1970', 180, 80, 'Homme', 'Excellent');";
    
    public static final String SQL_CREATE_TRAININGS = 
            "CREATE TABLE entrainement(id INTEGER PRIMARY KEY NOT NULL, " +
                    "nom TEXT, temps INTEGER, vitesse INTEGER, resistance INTEGER, blocs TEXT);";


    public static final String[] SQL_FILL_TRAININGS = {
            "INSERT INTO entrainement(nom, temps, vitesse, resistance, blocs)" +
                    "VALUES('Countryside Ramble', 25, 2, 1, '2:3:4');",
            "INSERT INTO entrainement(nom, temps, vitesse, resistance, blocs)" +
                    "VALUES('Downhill Speed', 40, 3, 1, '2:3:5:3');"
    };


    public static final String SQL_CREATE_BLOCKS =
            "CREATE TABLE bloc(id INTEGER PRIMARY KEY NOT NULL, " +
                    "nom TEXT, duree INTEGER, vitesse INTEGER, intensite INTEGER);";

    public static final String[] SQL_FILL_BLOCKS = {
            "INSERT INTO bloc(id, nom, duree, vitesse, intensite)" +
                    "VALUES(1, 'Sprint', 5, 120, 85);",
            "INSERT INTO bloc(id, nom, duree, vitesse, intensite)" +
                    "VALUES(2, 'Echauffement', 10, 60, 30);",
            "INSERT INTO bloc(id, nom, duree, vitesse, intensite)" +
                    "VALUES(3, 'côte', 20, 50, 90);",
            "INSERT INTO bloc(id, nom, duree, vitesse, intensite)" +
                    "VALUES(4, 'décrassage', 25, 70, 40);",
            "INSERT INTO bloc(id, nom, duree, vitesse, intensite)" +
                    "VALUES(5, 'repos', 1, 30, 10);"
    };


    public static final String SQL_DELETE = "DROP TABLE IF EXISTS utilisateur;";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_ADMIN);
        db.execSQL(SQL_CREATE_TRAININGS);
        db.execSQL(SQL_CREATE_BLOCKS);

        for(int i = 0; i < SQL_FILL_BLOCKS.length; i++) {
            db.execSQL(SQL_FILL_BLOCKS[i]);
        }

        for(int i = 0; i < SQL_FILL_TRAININGS.length; i++) {
            db.execSQL(SQL_FILL_TRAININGS[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onDowngrade(db, oldVersion, newVersion);
    }
}
