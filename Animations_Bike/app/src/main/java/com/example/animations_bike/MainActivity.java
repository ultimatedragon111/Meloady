package com.example.animations_bike;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN = 2000;
    private ImageView imageView2;
    private ImageView imageView5;
    private ImageView imageView4;
    private ImageView bike1;
    private ImageView bike2;
    private ImageView bike3;
    private ImageView bike4;


    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;

    private ObjectAnimator objectAnimator1;
    private ObjectAnimator objectAnimator2;
    private ObjectAnimator objectAnimator3;
    private ObjectAnimator objectAnimator4;
    private ObjectAnimator objectAnimator5;
    private ObjectAnimator objectAnimator6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView2 = findViewById(R.id.imageView2);
        imageView5 = findViewById(R.id.imageView5);
        imageView4 = findViewById(R.id.imageView4);
        bike1 = findViewById(R.id.bike1);
        bike2 = findViewById(R.id.bike2);
        bike3 = findViewById(R.id.bike3);
        bike4 = findViewById(R.id.bike4);

        relativeLayout1 = findViewById(R.id.relativeLayout1);
        relativeLayout2 = findViewById(R.id.relativeLayout2);

        objectAnimator1 = ObjectAnimator.ofFloat(imageView2,"translationY" , 0f , -1700f);
        objectAnimator2 = ObjectAnimator.ofFloat(imageView5,"translationX" , 0f , -500f);
        objectAnimator3 = ObjectAnimator.ofFloat(bike1,"rotation",360f);
        objectAnimator4 = ObjectAnimator.ofFloat(bike2,"rotation",360f);
        objectAnimator5 = ObjectAnimator.ofFloat(bike3,"rotation",360f);
        objectAnimator6 = ObjectAnimator.ofFloat(bike4,"rotation",360f);


        objectAnimator2.setDuration(1000);
        objectAnimator1.setDuration(1000);
        objectAnimator2.setStartDelay(500);
        objectAnimator1.setStartDelay(500);
        objectAnimator2.start();
        objectAnimator1.start();


        /*AnimatorSet set = new AnimatorSet();
        set.playTogether(objectAnimator1,objectAnimator2);
        set.setDuration(1000);
        set.setStartDelay(500);
        set.start();*/

        relativeLayout1.animate().setDuration(1000).setStartDelay(500).alpha(1.0f).setStartDelay(500).translationX(-275f).translationY(-700f).alpha(0f);
        relativeLayout2.setTranslationY(100f);
        relativeLayout2.animate().setStartDelay(1000).setDuration(1000).translationY(0f).alpha(1f);
        imageView4.setTranslationX(2000f);
        imageView4.animate().setDuration(1000).setStartDelay(1000).translationX(0f);

        bike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               objectAnimator3.start();
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Intent a = new Intent(MainActivity.this,Bike.class);
                       startActivity(a);
                   }
               },1000);
            }
        });
        bike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimator4.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent a = new Intent(MainActivity.this,Bike.class);
                        startActivity(a);
                    }
                },1000);
            }
        });
        bike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimator5.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent a = new Intent(MainActivity.this,Bike.class);
                        startActivity(a);
                    }
                },1000);
            }
        });
        bike4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimator6.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent a = new Intent(MainActivity.this,Bike.class);
                        startActivity(a);
                    }
                },1000);
            }
        });
    }
}