package com.ptut.fitrainer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewTraining extends AppCompatActivity {

    private TextView countdown;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training);

        countdown = findViewById(R.id.activity_main_countdown);
        startButton = findViewById(R.id.activity_main_start_training_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l'utilisateur a cliqué
            }
        });
    }
}