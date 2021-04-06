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

    public static final String SQL_CREATE =
            "CREATE TABLE utilisateur(id INTEGER PRIMARY KEY NOT NULL, " +
                    "pseudo TEXT, email TEXT, motDePasse TEXT, prenom TEXT, nom TEXT, dateNaissance TEXT, " +
                    "taille INTEGER, poids INTEGER, sexe TEXT, condition TEXT);";
    public static final String SQL_CREATE_ADMIN = "INSERT INTO utilisateur(pseudo, email, motDePasse, prenom, nom, dateNaissance, taille, poids, sexe, condition) VALUES('admin', 'admin@admin.com', 'admin', 'istrateur', '01/01/1970', 180, 80, 'Homme', 'Excellent');";

    public static final String SQL_DELETE = "DROP TABLE IF EXISTS utilisateur;";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
        db.execSQL(SQL_CREATE_ADMIN);
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
