package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.List;


public class ChoiceTrainingActivity extends AppCompatActivity {

    public DBHelper dbhelper;
    private List<Entrainement> entrainement;
    private ListViewAdapterCustom adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_training);

        /*this.entrainement = this.dbhelper.ARENSEIGNER();
        this.adapter = new ListViewAdapterCustom(this, this.entrainement);

        ListView listview = findViewById(R.id.listviewchoice);
        listview.setAdapter(this.adapter);
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu, menu);
        return true;
    }
}