package com.example.jpo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.activity_main.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ConstraintLayout cl = findViewById(R.id.root_layout);

        cl.setBackgroundResource(R.drawable.gradient_animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) cl.getBackground();
        frameAnimation.setEnterFadeDuration(10);
        frameAnimation.setExitFadeDuration(5000);
        frameAnimation.start();

    }

    public void jouer(View v){
        RadioGroup radioGroup = findViewById(R.id.difficulty);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radiobutton = (RadioButton) findViewById(selectedId);

        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(EXTRA_MESSAGE, radiobutton.getText());
        startActivity(intent);
    }
}
