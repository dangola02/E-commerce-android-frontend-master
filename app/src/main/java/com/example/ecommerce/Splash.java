package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView textView ;
    Animation splash ;
    private LinearLayout view ;
    private static int SPLASH_TIME = 5000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = AnimationUtils.loadAnimation(this , R.anim.splash);

        textView = findViewById(R.id.splash_title) ;
        textView.setAnimation(splash);
//        view.animate().alpha(1).setDuration(1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this , OnBoarding.class);
                startActivity(intent);
                finish();
            }
        } , SPLASH_TIME);

    }
}