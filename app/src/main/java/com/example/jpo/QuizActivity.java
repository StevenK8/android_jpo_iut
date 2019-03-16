package com.example.jpo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    String[] tableauNumeroQuestion={"Question n°1","Question n°2","Question n°3","Question n°4","Question n°5","Question n°6","Question n°7","Question n°8","Question n°9","Question n°10","Question n°11","Question n°12","Question n°13","Question n°14","Question n°15"};
    String[] tableauQuestionFacile={"Lequel de ces objets est indispensable au bon fonctionnement de l'ordinateur ?",
            "Le système d'exploitation Windows appartient à :",
            "En quelle unité mesure-t-on la fréquence (nombre de cycles par seconde) d’un microprocesseur ?",
            "Combien vaut 1 Mo (mégaoctet) ?",
            "Qu’est-ce qu’un CPU ?",
            "À quoi est égal 1 octet ?"};
    String[][] tableauReponseFacile={
            {"la souris","le processeur","la carte son","le clavier"},
            {"IBM","Apple","Microsoft"},
            {"En Go (gigaoctet)","En GHz (gigahertz)","En MIPS (million d’instructions par seconde)"},
            {"1 million d’octets","1000 octets","1024 octets"},
            {"Un processeur","Une carte video","Un disque dur"},
            {"À 8 bytes","À 8 bits"}};
    String[] tableauQuestionNormal={"Combien de touches comporte un clavier d'ordinateur classique?",
            "Quel code d'erreur HTTP identifie un trop grand nombre de requêtes dans un temps donné ?"};
    String[][] tableauReponseNormal={{"120","98","105","111"},{"429","444","504"}};
    String[] tableauQuestion;
    String[][] tableauReponse;

    int progression=0;
    int[] reponseCorrecteFacile = {1,2,1,0,0,1};
    int[] reponseCorrecteNormal = {2,0};
    int[] reponseCorrecte;
    boolean[] isBonneReponse = new boolean[tableauNumeroQuestion.length];
    int num_question=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ConstraintLayout cl = findViewById(R.id.root_layout);

        cl.setBackgroundResource(R.drawable.second_gradient_animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) cl.getBackground();
        frameAnimation.setEnterFadeDuration(10);
        frameAnimation.setExitFadeDuration(5000);
        frameAnimation.start();

        TextView numero_question=findViewById(R.id.numeroQ);
        TextView affichage_question=findViewById(R.id.afficheQ);
        Button reponse1=findViewById(R.id.reponse1);
        Button reponse2=findViewById(R.id.reponse2);
        Button reponse3=findViewById(R.id.reponse3);
        Button reponse4=findViewById(R.id.reponse4);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        //Difficulté
        Intent intent = getIntent();
        String difficulty = intent.getStringExtra("difficulty");
        numero_question.setText(tableauNumeroQuestion[0]);

        if(difficulty.equals("Facile")){
            tableauQuestion = tableauQuestionFacile;
            tableauReponse = tableauReponseFacile;
            reponseCorrecte = reponseCorrecteFacile;
        }else{
            tableauQuestion = tableauQuestionNormal;
            tableauReponse = tableauReponseNormal;
            reponseCorrecte = reponseCorrecteNormal;
        }
        affichage_question.setText(tableauQuestion[0]);
        reponse1.setText(tableauReponse[0][0]);
        reponse2.setText(tableauReponse[0][1]);
        reponse3.setText(tableauReponse[0][2]);
        reponse4.setText(tableauReponse[0][3]);
        progressBar.setMax(2000);
    }
    public void changerQuestionSuivant(View view){
        Button button = (Button) view;
        String reponse = (String)button.getText();

        if(num_question < tableauReponse.length){
            String bonneReponse = tableauReponse[num_question][reponseCorrecte[num_question]];
            if(bonneReponse.equals(reponse)){
                //correct
                isBonneReponse[num_question]=true;
            }else{
                //faux
                isBonneReponse[num_question]=false;
            }
        }

        TextView numero_question=findViewById(R.id.numeroQ);
        TextView affichage_question=findViewById(R.id.afficheQ);
        Button reponse1=findViewById(R.id.reponse1);
        Button reponse2=findViewById(R.id.reponse2);
        Button reponse3=findViewById(R.id.reponse3);
        Button reponse4=findViewById(R.id.reponse4);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        progression+=2000/reponseCorrecte.length;
        ObjectAnimator.ofInt(progressBar, "progress", progression)
                .setDuration(300)
                .start();

        if(num_question+1 < reponseCorrecte.length){
            numero_question.setText(tableauNumeroQuestion[num_question+1]);
            affichage_question.setText(tableauQuestion[num_question+1]);
        }
        else {// fin du jeu
            afficher_score();
        }

        if (num_question+1 < tableauReponse.length){
            if (tableauReponse[num_question+1].length > 0){
                reponse1.setText(tableauReponse[num_question+1][0]);
            }
            else{
                reponse1.setText("");
                remove_button(reponse1);
            }

            if (tableauReponse[num_question+1].length > 1){
                reponse2.setText(tableauReponse[num_question+1][1]);
            }
            else{
                reponse2.setText("");
                remove_button(reponse2);
            }

            if (tableauReponse[num_question+1].length > 2){
                reponse3.setText(tableauReponse[num_question+1][2]);
            }
            else{
                reponse3.setText("");
                remove_button(reponse3);
            }

            if (tableauReponse[num_question+1].length > 3){
                reponse4.setText(tableauReponse[num_question+1][3]);
            }
            else{
                reponse4.setText("");
                remove_button(reponse4);
            }
        }
        num_question++;

    }

    public void remove_button(Button bouton){
        bouton.setVisibility(View.INVISIBLE);
        bouton.setClickable(false);
    }

    public void remove_TextView (TextView textView){
        textView.setVisibility(View.INVISIBLE);
    }

    public void afficher_score(){
        Intent intent = new Intent(this, ResultsActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("questions", tableauQuestion);
        mBundle.putSerializable("reponses", tableauReponse);
        mBundle.putSerializable("bonneReponse", reponseCorrecte);
        mBundle.putSerializable("choix", isBonneReponse);
        intent.putExtras(mBundle);

        startActivity(intent);

    }

/*
    public void reponse(View v){
        TransitionManager.beginDelayedTransition(transitionsContainer, new Recolor());

        Button button = (Button) v;
        String rep = (String)button.getText();

        button.setTextColor(getResources().getColor(!isColorsInverted ? R.color.second_accent :R.color.accent));
        button.setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(!mColorsInverted ? R.color.accent :
                        R.color.second_accent)));


    }
*/
}
