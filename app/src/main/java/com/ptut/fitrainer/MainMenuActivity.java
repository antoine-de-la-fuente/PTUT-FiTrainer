package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.UUID;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button bouton = (Button) findViewById(R.id.activity_main_menu_logout_button);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ConnectActivity.class);
                startActivity(intent);
            }
        });

        Button bouton_training = (Button) findViewById(R.id.activity_main_menu_new_training_button);
        bouton_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_training = new Intent(MainMenuActivity.this, StartTrainingActivity.class);
                startActivity(intent_training);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menumain, menu);
        return true;
    }
}