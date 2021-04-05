package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}

        Button boutonConnexion = (Button) findViewById(R.id.ButtonConnexion);
        boutonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        Button boutonSignUp = (Button) findViewById(R.id.ButtonSignUp);
        boutonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}