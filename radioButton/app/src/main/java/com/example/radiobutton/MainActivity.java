package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rGroup1;
    private RadioGroup rGroup2;
    private RadioGroup rGroup3;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;
    private RadioButton radio6;
    private RadioButton radio7;
    private RadioButton radio8;
    private RadioButton radio9;
    private RadioButton radioSelected;
    private TextInputLayout TextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup1 = findViewById(R.id.rGroup1);
        rGroup2 = findViewById(R.id.rGroup2);
        rGroup3 = findViewById(R.id.rGroup3);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        radio6 = findViewById(R.id.radio6);
        radio7 = findViewById(R.id.radio7);
        radio8 = findViewById(R.id.radio8);
        radio9 = findViewById(R.id.radio9);

        radio3.setChecked(true);
        radio6.setChecked(true);

        rGroup3.clearCheck();
        for(int i = 0 ; i < rGroup3.getChildCount() ; i++){
            rGroup3.getChildAt(i).setClickable(false);
        }

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selected = radioGroup.getCheckedRadioButtonId();
                radioSelected = findViewById(selected);
                switch(selected){
                    case R.id.radio1:
                        Toast.makeText(MainActivity.this, radioSelected.getText()+ "",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio2:
                        Toast.makeText(MainActivity.this,radioSelected.getText() + "",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio3:
                        Toast.makeText(MainActivity.this,radioSelected.getText() + "",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selected = radioGroup.getCheckedRadioButtonId();
                radioSelected = findViewById(selected);
                switch(selected){
                    case R.id.radio4:
                        Toast.makeText(MainActivity.this,radioSelected.getText() + "",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio5:
                        Toast.makeText(MainActivity.this,radioSelected.getText() + "",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio6:
                        Toast.makeText(MainActivity.this,radioSelected.getText() + "",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
}