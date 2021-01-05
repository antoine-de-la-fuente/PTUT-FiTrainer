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
        String sql_user = "CREATE TABLE User(\n" +
                "   id_user numeric,\n" +
                "   nom text,\n" +
                "   prenom text,\n" +
                "   ddn numeric,\n" +
                "   poids integer,\n" +
                "   fc_max integer,\n" +
                "   niveau text,\n" +
                "   primary key(id_user)\n" +
                ");\n";

        String sql_ = "create table Training(\n" +
                "   id_training numeric,\n" +
                "   nom text,\n" +
                "   vitesse text,\n" +
                "   resistance text,\n" +
                "   PRIMARY KEY(id_training),\n" +
                "   FOREIGN KEY(id_user) REFERENCES User(id_training)\n" +
                ");\n";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
