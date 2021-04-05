package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountAdditionnal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_additionnal);

        Button boutonFinal = (Button) findViewById(R.id.signUpinfo);
        boutonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountAdditionnal.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }


}