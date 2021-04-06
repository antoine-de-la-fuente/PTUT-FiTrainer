package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText motDePasse;
    private Button   connexion;
    private Button   creerCompte;

    private DBHelper bdd;
    private SQLiteDatabase db;

    private Utilisateur utilisateur = Utilisateur.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        try { this.getSupportActionBar().hide(); }
        catch(NullPointerException e){}

        pseudo      = findViewById(R.id.editTextUserNameConnexion);
        motDePasse  = findViewById(R.id.editTextPasswordConnexion);
        connexion   = findViewById(R.id.ButtonConnexion);
        creerCompte = findViewById(R.id.ButtonSignUp);

        bdd = new DBHelper(this);
        db  = bdd.getWritableDatabase();

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "SELECT * FROM utilisateur WHERE pseudo = '" + pseudo.getText().toString() + "' AND motDePasse = '" + motDePasse.getText().toString() + "';";
                Cursor curs = db.rawQuery(query, null);

                if(curs.getCount() > 0) {/*
                    if(curs.moveToFirst()) {
                        do {
                            utilisateur.init(curs.getString(curs.getColumnIndexOrThrow("pseudo")),
                                    curs.getString(curs.getColumnIndexOrThrow("nom")),
                                    curs.getString(curs.getColumnIndexOrThrow("prenom")),
                                    curs.getString(curs.getColumnIndexOrThrow("dateNaissance")),
                                    curs.getInt   (curs.getColumnIndexOrThrow("taille")),
                                    curs.getInt   (curs.getColumnIndexOrThrow("poids")),
                                    curs.getString(curs.getColumnIndexOrThrow("sexe")),
                                    curs.getString(curs.getColumnIndexOrThrow("condition")));
                        } while(curs.moveToNext());
                    }*/
                    Intent intent = new Intent(ConnectActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ConnectActivity.this, "Utilisateur non existant", Toast.LENGTH_SHORT).show();
                }
                curs.close();
            }
        });

        creerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}