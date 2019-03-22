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
   /*
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

    int[] reponseCorrecteFacile = {1,2,1,0,0,1};
    int[] reponseCorrecteNormal = {2,0};
*/
    String[] tableauNumeroQuestionFacile ={"Question n°1","Question n°2","Question n°3","Question n°4","Question n°5","Question n°6","Question n°7","Question n°8","Question n°9","Question n°10","Question n°11","Question n°12","Question n°13","Question n°14","Question n°15"};
    String[] tableauQuestionFacile={"Lequel de ces objets est indispensable au bon fonctionnement de l'ordinateur ?",
            "Le système d'exploitation Windows appartient à :",
            "Quel est le langage informatique le plus courant utilisé pour écrire les pages web ?",
            "À quoi est égal 1 octet ?",
            "Qu’est-ce qu’un CPU ?",
            "Quelle est la combinaison de touches qui permet de sélectionner tous les fichiers d’un répertoire sous Windows ?",
            "Quelle est l'unité de mesure des écrans ?",
            "Les programmes sont aussi appelés :",
            " que signifie \"www\" :",
            " laquelle de ces entreprises n'est pas un fournisseur d'accès Internet :",
            "Pour connecter mon ordi à Internet, je le relie à une box qui s'appelle en réalité :",
            "le moteur de recherche du navigateur permet de rechercher :",
            " Je peux utiliser toutes les images trouvées sur Internet :",
            "Avast, MacAfee sont des exemples de logiciels :",
            "Mon écran affiche 1280 pixels en largeur et 1024 pixels en hauteur, ça s'appelle"};
    String[][] tableauReponseFacile={{"La souris","Le processeur","La carte son","Le clavier"},
            {"IBM","Apple","Microsoft"},
            {"HTML (Hypertext Markup Language)","HTTP (Hypertext Transfer Protocol)","Java"},
            {"À 8 bytes","À 8 bits"},
            {"Un processeur"," Une carte video","Un disque dur"},
            {"Ctrl + A","Ctrl + T","Alt + T"},
            {"Le pied"," Le centimètre","Le pouce","Le décibel"},
            {"Exécutables","Partitions","Logiciels","Interfaces"},
            {"What We Want","World Wide Web","West Wild World"},
            {"Bouygues","Orange","Amazon","Free"},
            {"un switch","un routeur","un serveur"},
            {"à l'intérieur du site seulement","sur tout l'Internet","sur votre réseau local"},
            {"non, seulement celles libres de droits de diffusion","oui si l'usage n'est pas commercial","oui, si je ne le dis à personne"},
            {"Malwares","antivirus","d'archivage des données"},
            {" Sa définition","Sa résolution","Sa révolution"}};
    int[] reponseCorrecteFacile = {0,1,0,1,0,0,2,0,1,2,1,1,0,1,1};

    String[] tableauNumeroQuestionNormal ={"Question n°1","Question n°2","Question n°3","Question n°4","Question n°5","Question n°6","Question n°7","Question n°8","Question n°9","Question n°10"};
    String[] tableauQuestionNormal={"Le programme qui fait la traduction en langage binaire est dit:","Quel est le résultat de cette fonction? \n int main(void){ \n int nombre_de_vie=5; \n printf(\"Vous avez %d vies\n\", nombreDeVies) \n nombre_de_vie-=2; \n printf(\"Vous avez %d vies\n\", nombreDeVies)","Que signifie l'abréviation OS ?","Quel est le protocole de l'ordinateur utilisé principalement pour le trafic réseau et Internet ?","Que signifie l'abréviation CSS?","Quel est le langage utilisé dans le code suivant?\n @sfont-face\n{\nfont-family:'BlackparkWeiner';\nfont-weight:normal;\nfont-style:normal;\n}","Qu'est ce qu'un Thread?","Comment appelle t-on le fait d'avoir plusieurs OS sur une même machine?","La conversion de 101 en base 2 est :","Parmi ces typologies de réseau, laquelle n’existe PAS ?","A quel indice commence les tableaux en langage C?"};
    String[][] tableauReponseNormal={{"2","3","4","5"},{"Operating System","Open Software","Open Source"},{"64-bits","TCP/IP","IPX/SPX"},{"Create Simple Samples","Central Security Service","Cascading Style Sheets"},{"JAVA","Python","CSS","C"},{"Un processus léger","Un processus lourd","Un langage de programmation","Un rapport d'erreur généré par EClipse"},{"Un duo-boot","Un dual-boot","Un pluri-boot","Un mono-boot"},{"1","3","4","5"},{"Le réseau fleché","le réseau maillé","le réseau en anneau"},{"0","1","2","3"}};
    int[] reponseCorrecteNormal={2,0,1,2,2,0,1,3,0,0};

    String[] tableauNumeroQuestion;
    String[] tableauQuestion;
    String[][] tableauReponse;

    int progression=0;
    int[] reponseCorrecte;
    boolean[] isBonneReponse;
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

        if(difficulty.equals("Facile")){
            tableauNumeroQuestion = tableauNumeroQuestionFacile;
            tableauQuestion = tableauQuestionFacile;
            tableauReponse = tableauReponseFacile;
            reponseCorrecte = reponseCorrecteFacile;
        }else{
            tableauNumeroQuestion = tableauNumeroQuestionNormal;
            tableauQuestion = tableauQuestionNormal;
            tableauReponse = tableauReponseNormal;
            reponseCorrecte = reponseCorrecteNormal;
        }
        isBonneReponse = new boolean[tableauNumeroQuestion.length];
        numero_question.setText(tableauNumeroQuestion[0]);

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
                show_button(reponse1);
            }
            else{
                reponse1.setText("");
                remove_button(reponse1);
            }

            if (tableauReponse[num_question+1].length > 1){
                reponse2.setText(tableauReponse[num_question+1][1]);
                show_button(reponse2);
            }
            else{
                reponse2.setText("");
                remove_button(reponse2);
            }

            if (tableauReponse[num_question+1].length > 2){
                reponse3.setText(tableauReponse[num_question+1][2]);
                show_button(reponse3);
            }
            else{
                reponse3.setText("");
                remove_button(reponse3);
            }

            if (tableauReponse[num_question+1].length > 3){
                reponse4.setText(tableauReponse[num_question+1][3]);
                show_button(reponse4);
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

    public void show_button(Button bouton){
        bouton.setVisibility(View.VISIBLE);
        bouton.setClickable(true);
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
