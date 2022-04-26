package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final long SPLASH_SCREEN = 2000;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Transicion.class);
                //Works only fro API > 21, then we need to surronded by  this if as suggested
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this,
                            Pair.create(imageView,"imageapp"),
                            Pair.create(textView, "textapp")            );
                    startActivity(intent,options.toBundle());
                }
            }
            }
            ,SPLASH_SCREEN);
            }
    }
