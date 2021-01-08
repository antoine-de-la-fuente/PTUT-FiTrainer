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

        String sql_bloc = "create table Bloc(" +
                "   id_bloc numeric," +
                "   nom integer," +
                "   f_de_pedalage integer," +
                "   intensite text," +
                "   PRIMARY KEY(id_bloc)" +
                ");";

        String sql_composer = "create table Composer(" +
                "   id_entrainement numeric," +
                "   id_bloc integer," +
                "   num_ordre integer," +
                "   num_repetition integer," +
                "   duree integer," +
                "   PRIMARY KEY(id_training,id_bloc)," +
                "   FOREIGN KEY(id_training) REFERENCES Training(id_training)," +
                "   FOREIGN KEY(id_bloc) REFERENCES Bloc(id_bloc)" +
                ");";

        String sql_correspondre = "create table Correspondre(" +
                "   id_training numeric," +
                "   temps_courant integer," +
                "   date_activite integer," +
                "   PRIMARY KEY(id_training,temps_courant)," +
                "   FOREIGN KEY(id_training) REFERENCES Training(id_training)," +
                "   FOREIGN KEY(temps_courant) REFERENCES Donnees_Secondes(temps_courant)" +
                ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
