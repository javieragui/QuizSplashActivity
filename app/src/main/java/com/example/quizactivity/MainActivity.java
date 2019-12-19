package com.example.quizactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static TextView questiones;
    private static String[] questionary;
    private static int i = 0;

    private View contentView;
    private View loadingView;
    private int shortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PREGUNTAS
        questiones = (TextView) findViewById(R.id.questions);
        questionary = getResources().getStringArray(R.array.array_Questions);
        questiones.setText(questionary[i]);

    }

    public void backOnclick(View view){

        i -= 1;
        if(i<0) {
            i = questionary.length - 1;
        }
        questiones.setText(questionary[i]);
    }
    public void nextOnclick(View view){
        i+=1;
        if(i> questionary.length-1){
            i = 0;
        }
        questiones.setText(questionary[i]);
    }
    public void windowBtn(View view){
        Intent window = new Intent(this, CheatActivity.class);
        startActivity(window);
    }

}
