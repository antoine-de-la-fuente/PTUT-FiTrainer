package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText email;
    private EditText motDePasse;
    private EditText confirmationMotDePasse;
    private Button   creerCompte;

    private DBHelper bdd;
    private SQLiteDatabase db;

    private Utilisateur utilisateur = Utilisateur.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        try { this.getSupportActionBar().hide(); }
        catch(NullPointerException e){}

        pseudo = (EditText)findViewById(R.id.editTextUserName);
        email = (EditText)findViewById(R.id.editTextEmail);
        motDePasse  = (EditText)findViewById(R.id.editTextPassword);
        confirmationMotDePasse = (EditText)findViewById(R.id.editTextPassword2);
        creerCompte = (Button)findViewById(R.id.Signup);

        bdd = new DBHelper(this);
        db  = bdd.getWritableDatabase();

        utilisateur.delete();

        creerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!pseudo.getText().toString().isEmpty() || !email.getText().toString().isEmpty() || !motDePasse.getText().toString().isEmpty()) && motDePasse.getText().toString().equals(confirmationMotDePasse.getText().toString())) {

                    String query = "SELECT * FROM utilisateur WHERE pseudo = '" + pseudo.getText().toString() + "'";
                    Cursor curs = db.rawQuery(query, null);

                    if(curs.getCount() == 0){
                        utilisateur.init(pseudo.getText().toString(), email.getText().toString(), motDePasse.getText().toString());
                        Log.i("test", "email : " + utilisateur.getEmail());

                        Intent intent = new Intent(CreateAccountActivity.this, CreateAccountAdditionnal.class);
                        startActivity(intent);
                        curs.close();
                    }else{
                        Toast.makeText(CreateAccountActivity.this, "Nom d'utilisateur deja utilisé", Toast.LENGTH_SHORT).show();
                    }
                    curs.close();
                } else {
                    Toast.makeText(CreateAccountActivity.this, "Veuillez remplir tout les champs correctement", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}