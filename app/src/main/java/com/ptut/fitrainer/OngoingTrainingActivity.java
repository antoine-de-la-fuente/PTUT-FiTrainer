package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OngoingTrainingActivity extends AppCompatActivity {

    private Entrainement entrainement;
    private ArrayList<Bloc> blocs;
    private boolean etatTimer = true;
    private long tempsRestant;

    private TextView nomBloc;
    private TextView dureeBloc;
    private TextView vitesseBloc;
    private TextView nomBlocSuivant;
    private TextView dureeBlocSuivant;
    private TextView vitesseBlocSuivant;

    private SeekBar sliderIntensite;

    private Button playPause;
    private Button stop;

    private TextView exerciceFinal;
    private TableLayout layoutProchainBloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_training);

        nomBloc = (TextView) findViewById(R.id.modulenamebegining);
        dureeBloc = (TextView) findViewById(R.id.moduletimebegining);
        vitesseBloc = (TextView) findViewById(R.id.moduletrminbegining);

        nomBlocSuivant = (TextView) findViewById(R.id.nomblocsuivant);
        dureeBlocSuivant = (TextView) findViewById(R.id.dureeblocsuivant);
        vitesseBlocSuivant = (TextView) findViewById(R.id.vitesseblocsuivant);

        sliderIntensite = (SeekBar) findViewById(R.id.intensitySlider);

        playPause = (Button) findViewById(R.id.buttonplaypause);
        stop = (Button) findViewById(R.id.buttonstop);

        exerciceFinal = (TextView) findViewById(R.id.labelExerciceFinal);
        layoutProchainBloc = (TableLayout) findViewById(R.id.tableLayoutProchainBloc);

        entrainement = getIntent().getParcelableExtra("entrainement");
        blocs = getIntent().getParcelableArrayListExtra("blocs");

        int[] i = {0};
        nomBloc.setText(blocs.get(i[0]).getNom());
        vitesseBloc.setText(blocs.get(i[0]).getVitesse() + " tr/min");
        sliderIntensite.setProgress(blocs.get(i[0]).getIntensite());
        nomBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getNom()));
        dureeBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getDuree()) + ":00");
        vitesseBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getVitesse()) + " tr/min");

        sliderIntensite.setEnabled(false);
        exerciceFinal.setVisibility(View.INVISIBLE);

        MyCountDownTimer countdown = new MyCountDownTimer(blocs.get(i[0]).getDuree() * 600, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                tempsRestant = millisUntilFinished;
                int minutes = ((int) millisUntilFinished / 1000) / 60;
                int secondes = ((int) millisUntilFinished / 1000) % 60;
                dureeBloc.setText(minutes + ":" + String.format("%02d", secondes));
            }

            @Override
            public void onFinish() {
                ++i[0];
                nomBloc.setText(blocs.get(i[0]).getNom());
                vitesseBloc.setText(blocs.get(i[0]).getVitesse() + " tr/min");
                sliderIntensite.setProgress(blocs.get(i[0]).getIntensite());
                if (i[0] < blocs.size() - 2) {
                    nomBlocSuivant.setText(String.valueOf(blocs.get(i[0] + 1).getNom()));
                    dureeBlocSuivant.setText(blocs.get(i[0] + 1).getDuree() + ":00");
                    vitesseBlocSuivant.setText(blocs.get(i[0] + 1).getVitesse() + " tr/min");
                    this.setMillisInFuture(blocs.get(i[0]).getDuree() * 600);
                    this.start();
                } else if (i[0] == blocs.size() - 2) {
                    exerciceFinal.setVisibility(View.VISIBLE);
                    layoutProchainBloc.setVisibility(View.INVISIBLE);
                    this.setMillisInFuture(blocs.get(i[0]).getDuree() * 600);
                    this.start();
                } else if (i[0] == blocs.size() - 1) {
                    Intent intent = new Intent(OngoingTrainingActivity.this, FinishTrainingActivity.class);
                    intent.putExtra("fini", true);
                    intent.putExtra("entrainement", entrainement);
                    intent.putExtra("blocs", blocs);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etatTimer) {
                    playPause.setBackgroundColor(playPause.getContext().getColor(R.color.fitrainer_blue));
                    playPause.setText("Pause");
                    countdown.setMillisInFuture(tempsRestant);
                    countdown.start();
                    etatTimer = false;
                } else if (!etatTimer) {
                    playPause.setBackgroundColor(playPause.getContext().getColor(R.color.green));
                    playPause.setText("Reprendre");
                    countdown.cancel();
                    etatTimer = true;
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OngoingTrainingActivity.this, FinishTrainingActivity.class);
                intent.putExtra("fini", false);
                intent.putExtra("entrainement", entrainement);
                intent.putExtra("blocs", blocs);
                startActivity(intent);
                finish();
            }
        });

    }
}