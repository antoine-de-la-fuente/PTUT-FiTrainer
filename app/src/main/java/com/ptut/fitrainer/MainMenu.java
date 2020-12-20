package com.ptut.fitrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    private TextView welcome;
    private TextView greetings;

    private Button newTraining;
    private Button createTraining;
    private Button history;
    private Button stats;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        welcome = (TextView) findViewById(R.id.activity_main_menu_welcome_txt);
        greetings = (TextView) findViewById(R.id.activity_main_menu_greetings_txt);

        newTraining = (Button) findViewById(R.id.activity_main_menu_new_training_button);
        createTraining = (Button) findViewById(R.id.activity_main_menu_create_training_button);
        history = (Button) findViewById(R.id.activity_main_menu_history_button);
        stats = (Button) findViewById(R.id.activity_main_menu_stats_button);
        logout = (Button) findViewById(R.id.activity_main_menu_logout_button);

        newTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTraining = new Intent(MainMenu.this, NewTraining.class);
                startActivity(newTraining);
            }
        });
    }
}