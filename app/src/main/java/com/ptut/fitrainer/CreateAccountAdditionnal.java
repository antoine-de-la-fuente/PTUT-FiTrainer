package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateAccountAdditionnal extends AppCompatActivity {

    private EditText prenom;
    private EditText nom;
    private EditText dateNaissance;
    private EditText taille;
    private EditText poids;
    private Spinner  sexe;
    private Spinner  condition;
    private Button   creerCompte;

    private DBHelper bdd;
    private SQLiteDatabase db;

    private Utilisateur utilisateur = Utilisateur.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_additionnal);

        try { this.getSupportActionBar().hide(); }
        catch(NullPointerException e){}

        prenom = (EditText)findViewById(R.id.editTextFName);
        nom = (EditText)findViewById(R.id.editTextName);
        dateNaissance  = (EditText)findViewById(R.id.editTextBirth);
        taille = (EditText)findViewById(R.id.editTextHeight);
        poids = (EditText)findViewById(R.id.editTextWeight);
        creerCompte = (Button)findViewById(R.id.signUpinfo);
        sexe = (Spinner)findViewById(R.id.spinnerSex);
        condition = (Spinner)findViewById(R.id.spinnerCondition);

        bdd = new DBHelper(this);
        db  = bdd.getWritableDatabase();
        Log.i("test", "email : " + utilisateur.getEmail());

        creerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!prenom.getText().toString().isEmpty() || !nom.getText().toString().isEmpty() || !dateNaissance.getText().toString().isEmpty() || !taille.getText().toString().isEmpty() || poids.getText().toString().isEmpty()) && (sexe.getSelectedItemPosition() != 0 || condition.getSelectedItemPosition() != 0)) {
                    utilisateur.init(utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getMotDePasse(),
                            nom.getText().toString(), prenom.getText().toString(), dateNaissance.getText().toString(),
                            Integer.parseInt(taille.getText().toString()), Integer.parseInt(poids.getText().toString()),
                            sexe.getSelectedItem().toString(), condition.getSelectedItem().toString());
                    ContentValues values = new ContentValues();
                    values.put("pseudo", utilisateur.getPseudo());
                    values.put("email", utilisateur.getPseudo());
                    values.put("motDePasse", utilisateur.getPseudo());
                    values.put("nom", utilisateur.getNom());
                    values.put("prenom", utilisateur.getPrenom());
                    values.put("dateNaissance", utilisateur.getDateNaissance());
                    values.put("taille", utilisateur.getTaille());
                    values.put("poids", utilisateur.getPoids());
                    values.put("sexe", utilisateur.getSexe());
                    values.put("condition", utilisateur.getCondition());
                    db.insert("utilisateur", null, values);
                    Log.i("test", utilisateur.getCondition());
                    Intent intent = new Intent(CreateAccountAdditionnal.this, MainMenuActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(CreateAccountAdditionnal.this, "Veuillez remplir tout les champs correctement", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}