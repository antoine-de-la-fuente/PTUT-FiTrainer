package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class StartTrainingActivity extends AppCompatActivity {

    private Entrainement entrainement;
    private ArrayList<Bloc> blocs;
    private TextView bloc;
    private TextView timer;
    private TextView toursMinute;
    private Button commencer;
    private SeekBar intensite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_training);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        entrainement = getIntent().getParcelableExtra("entrainement");
        blocs = getIntent().getParcelableArrayListExtra("blocs");

        bloc = (TextView) findViewById(R.id.modulename);
        timer = (TextView) findViewById(R.id.moduletime);
        toursMinute = (TextView) findViewById(R.id.moduletrmin);

        commencer = (Button) findViewById(R.id.button_start);
        intensite = (SeekBar) findViewById(R.id.intensitySlider2);

        bloc.setText(blocs.get(0).getNom());
        timer.setText(blocs.get(0).getDuree() + ":00");
        toursMinute.setText(blocs.get(0).getVitesse() + " tr/min");
        intensite.setEnabled(false);
        intensite.setProgress(blocs.get(0).getIntensite());

        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartTrainingActivity.this, OngoingTrainingActivity.class);
                intent.putExtra("entrainement", entrainement);
                intent.putExtra("blocs", blocs);
                startActivity(intent);
            }
        });
    }
}