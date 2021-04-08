package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FinishTrainingActivity extends AppCompatActivity {

    private TextView titre;
    private TextView felicitations;
    private TextView nom;
    private TextView txtProchaineFois;

    private Entrainement entrainement;
    private ArrayList<Bloc> blocs;
    private boolean entrainementFini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_training);

        titre = (TextView) findViewById(R.id.textViewFelicitations);
        felicitations = (TextView) findViewById(R.id.textViewfinish);
        nom = (TextView) findViewById(R.id.textViewfinishtraining);
        txtProchaineFois = (TextView) findViewById(R.id.textViewfinish2);

        entrainement = getIntent().getParcelableExtra("entrainement");
        blocs = getIntent().getParcelableArrayListExtra("blocs");
        entrainementFini = getIntent().getBooleanExtra("fini", false);

        nom.setText(entrainement.getNom());

        if (entrainementFini) {
            titre.setText("Félicitations");
            felicitations.setText("Vous avez terminé l'entraînement");
            txtProchaineFois.setVisibility(View.INVISIBLE);
        } else if (!entrainementFini) {
            titre.setText("Dommage...");
            felicitations.setText("Vous n'avez pas terminé l'entraînement");
        }
    }
}