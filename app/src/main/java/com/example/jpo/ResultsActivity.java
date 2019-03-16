package com.example.jpo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ConstraintLayout cl = findViewById(R.id.root_layout);

        cl.setBackgroundResource(R.drawable.third_gradient_animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) cl.getBackground();
        frameAnimation.setEnterFadeDuration(10);
        frameAnimation.setExitFadeDuration(5000);
        frameAnimation.start();

        Bundle bundle = getIntent().getExtras();
        String[] tableauQuestion = (String[]) bundle.getSerializable("questions");
        String[][] tableauReponse = (String[][]) bundle.getSerializable("reponses");
        int[] reponseCorrecte = (int[]) bundle.getSerializable("bonneReponse");
        boolean[] isBonneReponse = (boolean[]) bundle.getSerializable("choix");
        ListView listView = findViewById(R.id.listView);

        ArrayList<String> listeQuestions = new ArrayList<>(Arrays.asList(tableauQuestion));

        // Create ArrayAdapter using the planet list.
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listeQuestions);

        listView.setAdapter(listAdapter);

        for(int i=0; i<reponseCorrecte.length; i++){

            System.out.println(tableauQuestion[i]+"\n"+tableauReponse[i][reponseCorrecte[i]]);
            if(isBonneReponse[i]){
                System.out.println("ok");
            }else{
                System.out.println("X");
            }
        }
    }


}
