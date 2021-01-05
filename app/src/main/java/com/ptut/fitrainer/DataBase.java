package com.ptut.fitrainer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FiTrainer.db";
    private static final int DATABASE_VERSION = 1;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_user = "CREATE TABLE User(" +
                "   id_user numeric," +
                "   nom text," +
                "   prenom text," +
                "   ddn numeric," +
                "   poids integer," +
                "   fc_max integer," +
                "   niveau text," +
                "   primary key(id_user)" +
                ");";

        String sql_training = "create table Training(" +
                "   id_training numeric," +
                "   nom text," +
                "   vitesse text," +
                "   resistance text," +
                "   PRIMARY KEY(id_training)," +
                "   FOREIGN KEY(id_user) REFERENCES User(id_training)" +
                ");";

        String sql_donnees_sec = "create table Donnees_Secondes(" +
                "   temps_courant numeric," +
                "   puissance integer," +
                "   f_de_pedalage integer," +
                "   f_cardiaque integer," +
                "   distance integer," +
                "   PRIMARY KEY(temps_courant)" +
                ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
