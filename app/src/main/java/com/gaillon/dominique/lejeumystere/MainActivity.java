package com.gaillon.dominique.lejeumystere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mMessageBienvenue;
    private TextView mMessageExplication;
    private Button mBoutonJouer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageBienvenue = findViewById(R.id.activity_main_bienvenue);
        mMessageExplication = findViewById(R.id.activity_main_explication);
        mBoutonJouer = findViewById(R.id.activity_main_jouer_btn);

        // le bouton est actif dès l'ouverture de l'application
        mBoutonJouer.setEnabled(true);

        // listener du bouton jouer
        mBoutonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // le joueur appuie sur le bouton 'jouer'
                Intent jeuActivityIntent = new Intent(MainActivity.this, JeuActivity.class);
                startActivity(jeuActivityIntent);
            }
        });
    }
}
