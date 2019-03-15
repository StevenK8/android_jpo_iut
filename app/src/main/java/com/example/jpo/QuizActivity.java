package com.example.jpo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    public String[] questions = {"Le javascript permet :", "Quand on parle de résolution on parle :"};
    String[] tableauNuméroQuestion ={"Question n°1","Question n°2","Question n°3","Question n°4","Question n°5","Question n°6","Question n°7","Question n°8","Question n°9","Question n°10","Question n°11","Question n°12","Question n°13","Question n°14","Question n°15"};
    String[] tableauQuestionFacile={"Lequel de ces objets est indispensable au bon fonctionnement de l'ordinateur ?","Le système d'exploitation Windows appartient à :"};
    String[][] tableauReponseFacile={{"la souris","le processeur","la carte son","le clavier"},{"IBM","Apple","Microsoft",""}};
    int[] reponseCorrecte = {1,2};
    boolean[] isBonneReponse = new boolean[tableauNuméroQuestion.length];
    int num_question_actuel=0;

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

        numero_question.setText(tableauNuméroQuestion[0]);
        affichage_question.setText(tableauQuestionFacile[0]);
        reponse1.setText(tableauReponseFacile[0][0]);
        reponse2.setText(tableauReponseFacile[0][1]);
        reponse3.setText(tableauReponseFacile[0][2]);
        reponse4.setText(tableauReponseFacile[0][3]);
    }

    public void changerQuestionSuivant(View view){

        TextView numero_question=findViewById(R.id.numeroQ);
        TextView affichage_question=findViewById(R.id.afficheQ);
        Button reponse1=findViewById(R.id.reponse1);
        Button reponse2=findViewById(R.id.reponse2);
        Button reponse3=findViewById(R.id.reponse3);
        Button reponse4=findViewById(R.id.reponse4);


        if(tableauNuméroQuestion[num_question_actuel+1]!=null){
            numero_question.setText(tableauNuméroQuestion[num_question_actuel+1]);
        }
        else {
            numero_question.setText("Il n'y plus de question");
        }

        if (tableauQuestionFacile[num_question_actuel+1]!=null){
            affichage_question.setText(tableauQuestionFacile[num_question_actuel+1]);
        }
        else {
            affichage_question.setText("Il n'y plus de question");
        }


        if (tableauReponseFacile[num_question_actuel+1][0]!=null){
            reponse1.setText(tableauReponseFacile[num_question_actuel+1][0]);
        }
        else{
            reponse1.setText("");
            verif_bouton(reponse1);
        }

        if (tableauReponseFacile[num_question_actuel+1][1]!=null){
            reponse2.setText(tableauReponseFacile[num_question_actuel+1][1]);
        }
        else{
            reponse2.setText("");
            verif_bouton(reponse2);
        }

        if (tableauReponseFacile[num_question_actuel+1][2]!=null){
            reponse3.setText(tableauReponseFacile[num_question_actuel+1][2]);
        }
        else{
            reponse3.setText("");
            verif_bouton(reponse3);
        }

        if (tableauReponseFacile[num_question_actuel+1][3]!=null){
            reponse4.setText(tableauReponseFacile[num_question_actuel+1][3]);
        }
        else{
            reponse4.setText("");
            verif_bouton(reponse4);
        }


        num_question_actuel=num_question_actuel+1;


    }

    public void buttonSetInvisible(Button bouton){

        bouton.setVisibility(View.INVISIBLE);
    }

    public void verif_bouton(Button bouton){
        if(bouton.getText().equals("")){
            buttonSetInvisible(bouton);
            bouton.setClickable(false);
        }
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
