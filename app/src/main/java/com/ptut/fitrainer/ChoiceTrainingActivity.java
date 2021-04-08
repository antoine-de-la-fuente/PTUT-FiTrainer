package com.ptut.fitrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ChoiceTrainingActivity extends AppCompatActivity {

    private ArrayList<Entrainement> listeEntrainements;
    private ListViewAdapterCustom adapter;

    private DBHelper bdd;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_training);

        bdd = new DBHelper(this);
        db = bdd.getWritableDatabase();

        String query = "SELECT * FROM entrainement;";
        Cursor curs = db.rawQuery(query, null);
        listeEntrainements = new ArrayList<>();

        if(curs.moveToFirst()) {
            do {
                listeEntrainements.add(new Entrainement(curs.getString(curs.getColumnIndexOrThrow("nom")),
                                                  curs.getInt   (curs.getColumnIndexOrThrow("vitesse")),
                                                  curs.getInt   (curs.getColumnIndexOrThrow("resistance")),
                                                  curs.getString(curs.getColumnIndexOrThrow("blocs")), db));
            } while(curs.moveToNext());
        }

        for (int i = 0; i < listeEntrainements.size(); i++) {
            Log.i("test: nom entraînement", listeEntrainements.get(i).getNom());
            Log.i("test: nombre de blocs", listeEntrainements.get(i).getBlocs().size() + "");
        }

        this.adapter = new ListViewAdapterCustom(this, this.listeEntrainements);

        ListView listview = findViewById(R.id.listviewchoice);
        listview.setAdapter(this.adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(ChoiceTrainingActivity.this,StartTrainingActivity.class);
                intent.putExtra("entrainement", listeEntrainements.get(position));
                intent.putExtra("blocs", listeEntrainements.get(position).getBlocs());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu, menu);
        return true;
    }


}