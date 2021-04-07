package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingBeginActivity extends AppCompatActivity {

    private Entrainement entrainement;
    private ArrayList<Bloc> blocs;

    private TextView nomBloc;
    private TextView dureeBloc;
    private TextView vitesseBloc;
    private TextView nomBlocSuivant;
    private TextView dureeBlocSuivant;
    private TextView vitesseBlocSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_begin);

        nomBloc = (TextView) findViewById(R.id.modulenamebegining);
        dureeBloc = (TextView) findViewById(R.id.moduletimebegining);
        vitesseBloc = (TextView) findViewById(R.id.moduletrminbegining);

        nomBlocSuivant = (TextView) findViewById(R.id.nomblocsuivant);
        dureeBlocSuivant = (TextView) findViewById(R.id.dureeblocsuivant);
        vitesseBlocSuivant = (TextView) findViewById(R.id.vitesseblocsuivant);

        entrainement = getIntent().getParcelableExtra("entrainement");
        blocs = getIntent().getParcelableArrayListExtra("blocs");
        CountDownTimer bloc = new CountDownTimer(blocs.get(0).getDuree() * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = ((int) millisUntilFinished / 1000) / 60;
                int secondes = ((int) millisUntilFinished / 1000) % 60;
                dureeBloc.setText(minutes + ":" + String.format("%02d", secondes));
            }

            @Override
            public void onFinish() {

            }
        };
        bloc.start();
        for (int i = 0; i < blocs.size(); i++) {

            /*
            nomBloc.setText(blocs.get(i).getNom());
            vitesseBloc.setText(blocs.get(i).getVitesse());

            nomBlocSuivant.setText(blocs.get(i + 1).getNom());
            dureeBlocSuivant.setText(blocs.get(i + 1).getDuree());
            vitesseBlocSuivant.setText(blocs.get(i + 1).getVitesse());
             */
        }
    }
}