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

        int[] i = {0};
        /*
        CountDownTimer bloc = new CountDownTimer(blocs.get(i).getDuree() * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = ((int) millisUntilFinished / 1000) / 60;
                int secondes = ((int) millisUntilFinished / 1000) % 60;
                dureeBloc.setText(minutes + ":" + String.format("%02d", secondes));
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();
         */
        nomBloc.setText(blocs.get(i[0]).getNom());
        vitesseBloc.setText(blocs.get(i[0]).getVitesse() + " tr/min");
        nomBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getNom()));
        dureeBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getDuree()));
        vitesseBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getVitesse()));

        MyCountDownTimer tempsRestant = new MyCountDownTimer(blocs.get(i[0]).getDuree() * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = ((int) millisUntilFinished / 1000) / 60;
                int secondes = ((int) millisUntilFinished / 1000) % 60;
                dureeBloc.setText(minutes + ":" + String.format("%02d", secondes));
            }

            @Override
            public void onFinish() {
                if (i[0] < blocs.size()) {
                    ++i[0];
                    nomBloc.setText(blocs.get(i[0]).getNom());
                    vitesseBloc.setText(blocs.get(i[0]).getVitesse() + " tr/min");
                    nomBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getNom()));
                    dureeBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getDuree()) + ":00");
                    vitesseBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getVitesse()) + "tr/min");
                    this.setMillisInFuture(blocs.get(i[0]).getDuree() * 60000); // here we change the millisInFuture of our timer
                    this.start();
                } else {

                }
            }
        }.start();

    }
}