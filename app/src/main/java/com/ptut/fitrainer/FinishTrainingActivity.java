package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FinishTrainingActivity extends AppCompatActivity {

    private TextView titre;
    private TextView felicitations;
    private TextView nom;
    private TextView txtProchaineFois;

    private TextView distance;
    private TextView vitesse;
    private TextView temps;
    private TextView frequencePedalage;

    private int distanceTotale;
    private int vitesseMoyenne;
    private int freqPedalage;
    private int minutes;
    private int secondes;

    private Entrainement entrainement;
    private ArrayList<Bloc> blocs;
    private boolean entrainementFini;
    private long tempsTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_training);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        titre = (TextView) findViewById(R.id.textViewFelicitations);
        felicitations = (TextView) findViewById(R.id.textViewfinish);
        nom = (TextView) findViewById(R.id.textViewfinishtraining);
        txtProchaineFois = (TextView) findViewById(R.id.textViewfinish2);

        distance = (TextView) findViewById(R.id.textView17);
        vitesse = (TextView) findViewById(R.id.textView18);
        temps = (TextView) findViewById(R.id.textView19);
        frequencePedalage = (TextView) findViewById(R.id.textView20);

        entrainement = getIntent().getParcelableExtra("entrainement");
        blocs = getIntent().getParcelableArrayListExtra("blocs");
        entrainementFini = getIntent().getBooleanExtra("fini", false);
        tempsTotal = getIntent().getLongExtra("tempsTotal", 0);
        freqPedalage = getIntent().getIntExtra("freqPedalage", 0);


        for (int i = 0; i < blocs.size(); i++) {

        }

        minutes = ((int) tempsTotal / 1000) / 60;
        secondes = ((int) tempsTotal / 1000) % 60;

        nom.setText(entrainement.getNom());
        distance.setText(distanceTotale + " km");
        vitesse.setText(vitesseMoyenne + " km/h");
        temps.setText(minutes + "'" + secondes + "''");
        frequencePedalage.setText(freqPedalage + " tr/min");

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