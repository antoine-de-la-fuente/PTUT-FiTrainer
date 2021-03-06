package com.ptut.fitrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
    private Button globalStats;
    private Button logout;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_bar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        welcome = (TextView) findViewById(R.id.activity_main_menu_welcome_txt);
        greetings = (TextView) findViewById(R.id.activity_main_menu_greetings_txt);

        newTraining = (Button) findViewById(R.id.activity_main_menu_new_training_button);
        createTraining = (Button) findViewById(R.id.activity_main_menu_create_training_button);
        history = (Button) findViewById(R.id.activity_main_menu_history_button);
        globalStats = (Button) findViewById(R.id.activity_main_menu_stats_button);
        logout = (Button) findViewById(R.id.activity_main_menu_logout_button);

        newTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTraining = new Intent(MainMenu.this, NewTraining.class);
                startActivity(newTraining);
            }
        });

        createTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createTraining = new Intent(MainMenu.this, CreateTraining.class);
                startActivity(createTraining);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(MainMenu.this, History.class);
                startActivity(history);
            }
        });

        globalStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent globalStats = new Intent(MainMenu.this, GlobalStats.class);
                startActivity(globalStats);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(MainMenu.this, Connect.class);
                startActivity(logout);
            }
        });
    }

}