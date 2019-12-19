package com.example.quizactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import static android.content.ClipData.newIntent;

public class AnimationActivity extends AppCompatActivity {
    TextView ani ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ani = (TextView) findViewById(R.id.animation);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.progressbar);

        ani.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(AnimationActivity.this, MainActivity.class));
                AnimationActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
    }
}
