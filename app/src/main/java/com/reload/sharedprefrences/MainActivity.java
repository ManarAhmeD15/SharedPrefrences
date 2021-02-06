package com.reload.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // Time to Display Splash screen
    private static int SPLASH_SCREEN = 5000;

    //Variables
    Animation top_anim;
    Animation bottom_anim;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//====================================================================

        // load animations
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //load image
        imageView = findViewById(R.id.imageView);
        // Apply animation
        imageView.setAnimation(top_anim);

//====================================================================
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // To Move To next intent
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                // Finish for Destroy the first activity and don't let user return to splash screen
                finish();
            }
        },SPLASH_SCREEN);


    }
}