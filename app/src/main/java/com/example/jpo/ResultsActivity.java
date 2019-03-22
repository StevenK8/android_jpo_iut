package com.example.jpo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultsActivity extends AppCompatActivity {
    List<String> listeReponses;
    Map<String, List<String>> listeQuestionsItems;
    ExpandableListView expandablelistView;
    
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

        listeQuestionsItems = new LinkedHashMap<String, List<String>>();

        for (int i=0; i<listeQuestions.size()-1; i++) {
            System.out.println(listeQuestions.size());
            loadReponses(tableauReponse[i-1]);
            listeQuestionsItems.put(listeQuestions.get(i), listeReponses);/*
            try {
                expandablelistView.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }catch (Exception e){}*/

        }

        expandablelistView = (ExpandableListView) findViewById(R.id.listView);
        final ExpandableListAdapter expListAdapter = new ListAdapter(
                this, listeQuestions, listeQuestionsItems);
        expandablelistView.setAdapter(expListAdapter);


        for(int i=0; i<reponseCorrecte.length; i++){
            System.out.println(tableauQuestion[i]+"\n"+tableauReponse[i][reponseCorrecte[i]]);
            if(isBonneReponse[i]){
                System.out.println("ok");
            }else{
                System.out.println("X");
            }
        }
    }

    private void loadReponses(String[] reponses) {
        listeReponses = new ArrayList<String>();
        for (String reponse : reponses)
            listeReponses.add(reponse);
    }

    public void quitter(View v){
        System.exit(0);
    }
}
