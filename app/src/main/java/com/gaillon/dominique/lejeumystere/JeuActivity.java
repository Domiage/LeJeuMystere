package com.gaillon.dominique.lejeumystere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    private TextView mMessageAffirmation;
    private EditText mChiffreInput;
    private Button mBoutonValider;
    private TextView mMessageVariation;

    private int nbCoups = 0;
    private int min = 0;
    private int max = 100;
    // génération d'un chiffre aléatoire entre 0 et 100
    private int nbAleatoire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        nbAleatoire = min + (int)(Math.random() * ((max - min) + 1));

        mMessageAffirmation = findViewById(R.id.activity_jeu_affirmation_text);
        mChiffreInput = findViewById(R.id.activity_jeu_chiffre_input);
        mBoutonValider = findViewById(R.id.activity_jeu_valider_btn);
        mMessageVariation = findViewById(R.id.activity_jeu_variation_text);

        System.out.println("nbAleatoire = " + nbAleatoire);

        // on active le bouton uniquement si un chiffre a été rentré
        mBoutonValider.setEnabled(false);

        mChiffreInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // on active le bouton dès que l'utilisateur rentre une valeur
                // caster la chaîne de caractères en entier ??
                mBoutonValider.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBoutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbCoups++; // A REPLACER !!
                String chiffreRentre = mChiffreInput.getText().toString(); // marche
                int result = Integer.parseInt(chiffreRentre); //conversion en int

                // faire la comparaison puis afficher un Toast "Plus" ou "Moins" !?
                //mMessageVariation.setText(String.valueOf(nbAleatoire));
                //mMessageVariation.setText(chiffreRentre);
                //mMessageVariation.setText(String.valueOf(result));

                if (result < 100 && result >= 0) {
                    // affichage "c'est plus" ou "c'est moins" en fonction de la valeur de result
                    if (result < nbAleatoire) {
                        mMessageVariation.setText("C'est plus !");
                    } else if (result > nbAleatoire) {
                        mMessageVariation.setText("C'est moins !");
                    }
                    else {
                        mMessageVariation.setText("Félicitations !");
                    }
                    mChiffreInput.setText("");
                } else {
                    mMessageVariation.setText("Vous devez saisir un chiffre entre 0 et 100 !");
                }


            }
        });
    }
}