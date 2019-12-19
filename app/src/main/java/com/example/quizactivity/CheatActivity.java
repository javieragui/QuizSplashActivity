package com.example.quizactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CheatActivity extends AppCompatActivity {
    private static String TAG;
    private static TextView answerTxt;

    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    Date now = new Date();
    String dateTime = dateFormat.format(now);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answerTxt = (TextView) findViewById(R.id.show_answer_button);

        //Clase SharedPreferences para guardar los datos en archivoregistros
        SharedPreferences lastTime = getSharedPreferences("registros", Context.MODE_PRIVATE);

        if(lastTime.contains("date") == true) {
            answerTxt.setText(lastTime.getString("date", ""));
            Log.i(TAG, "Last Acces: " + dateTime);
        }
    }
    //Evento Onclick que se utilizara para la activación del guardado de datos
    public void Guardar(View view){
        SharedPreferences preferencias = getSharedPreferences("registros", Context.MODE_PRIVATE);
        SharedPreferences.Editor dateEditor = preferencias.edit();
        dateEditor.putString("date", dateFormat.format(now));
        dateEditor.commit();
        answerTxt.setText(dateTime);
    }

}
