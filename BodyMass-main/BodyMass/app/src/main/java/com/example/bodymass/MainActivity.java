package com.example.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rGroup;
    private RadioGroup rGroup2;
    private RadioGroup rGroup3;
    private RadioButton male;
    private RadioButton small;
    private TextInputLayout textInput;
    private TextInputLayout textInput2;
    private TableLayout table;
    private TextView textView2;
    private RelativeLayout relative;
    private Gender gender;
    private Morphology morphology;
    private int seleccion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup = findViewById(R.id.rGroup);
        rGroup2 = findViewById(R.id.rGroup2);
        rGroup3 = findViewById(R.id.rGroup3);
        RadioButton relativeFat = findViewById(R.id.relativeFat);
        RadioButton wanDer = findViewById(R.id.wanDer);
        RadioButton loretz = findViewById(R.id.loretz);
        RadioButton creff = findViewById(R.id.creff);
        male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);
        small = findViewById(R.id.small);
        RadioButton medium = findViewById(R.id.medium);
        RadioButton broad = findViewById(R.id.broad);
        textInput = findViewById(R.id.textInput);
        textInput2 = findViewById(R.id.textInput2);
        table = findViewById(R.id.tabla);
        textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);
        relative = findViewById(R.id.relative);

         rGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioSelected = rGroup3.getCheckedRadioButtonId();
                switch (radioSelected) {
                    case R.id.relativeFat:
                        relative.setAlpha(1);
                        textInput2.setVisibility(View.VISIBLE);
                        rGroup.setVisibility(View.VISIBLE);
                        rGroup2.setVisibility(View.GONE);
                        male.setChecked(true);
                        textInput2.setHint(R.string.waist_circumference_cm);
                        gender = Gender.MALE;
                        textView2.setAlpha(0);
                        seleccion = 1;
                        break;
                    case R.id.wanDer:
                        relative.setAlpha(1);
                        textInput2.setVisibility(View.GONE);
                        rGroup.setVisibility(View.VISIBLE);
                        rGroup2.setVisibility(View.GONE);
                        male.setChecked(true);
                        table.setAlpha(0);
                        gender = Gender.MALE;
                        textView2.setAlpha(0);
                        seleccion = 2;
                        break;
                    case R.id.loretz:
                        relative.setAlpha(1);
                        textInput2.setVisibility(View.VISIBLE);
                        rGroup.setVisibility(View.VISIBLE);
                        rGroup2.setVisibility(View.GONE);
                        textInput2.setHint(R.string.age);
                        table.setAlpha(0);
                        male.setChecked(true);
                        gender = Gender.MALE;
                        textView2.setAlpha(0);
                        seleccion = 3;
                        break;
                    case R.id.creff:
                        relative.setAlpha(1);
                        textInput2.setVisibility(View.VISIBLE);
                        rGroup.setVisibility(View.GONE);
                        rGroup2.setVisibility(View.VISIBLE);
                        textInput2.setHint(R.string.age);
                        table.setAlpha(0);
                        small.setChecked(true);
                        morphology = Morphology.SMALL;
                        textView2.setAlpha(0);
                        seleccion = 4;
                        break;
                }
            }
        });

        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioSelected = rGroup2.getCheckedRadioButtonId();
                switch (radioSelected) {
                    case R.id.small:
                        morphology = Morphology.SMALL;
                        break;
                    case R.id.medium:
                        morphology = Morphology.MEDIUM;
                        break;
                    case R.id.broad:
                        morphology = Morphology.BROAD;
                        break;
                }
            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioSelected = rGroup.getCheckedRadioButtonId();
                switch (radioSelected) {
                    case R.id.male:
                        gender = Gender.MALE;
                        break;
                    case R.id.female:
                        gender = Gender.FEMALE;
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultado;
                double constante;
                if (textInput.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Error en la altura", Toast.LENGTH_SHORT).show();
                } else {
                    switch (seleccion) {
                        case 1:
                            if (textInput2.getEditText().getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Error en la cintura", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                if (gender == Gender.MALE) {
                                    constante = Constants.N_hombre;
                                } else {
                                    constante = Constants.N_mujer;
                                }
                                resultado = constante - 20 * Double.parseDouble(textInput.getEditText().getText().toString()) / Double.parseDouble(textInput2.getEditText().getText().toString());
                                resultado = Math.round(resultado*100.0)/100.0;
                                textView2.setAlpha(1);
                                textView2.setText(resultado + "%");
                                table.setAlpha(1);
                            }
                            break;
                        case 2:
                            if (gender == Gender.MALE) {
                                constante = Constants.M_hombre;
                            } else {
                                constante = Constants.M_muujer;
                            }
                            resultado = (Double.parseDouble(textInput.getEditText().getText().toString()) - 150) * constante + 50;
                            resultado = Math.round(resultado*100.0)/100.0;
                            textView2.setAlpha(1);
                            textView2.setText(resultado + "Kg");
                            break;
                        case 3:
                            if (textInput2.getEditText().getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Error en la edad", Toast.LENGTH_SHORT).show();
                            }else{
                                if (gender == Gender.MALE) {
                                    constante = Constants.K_hombre;
                                } else {
                                    constante = Constants.K_muujer;
                                }
                                resultado = Double.parseDouble(textInput.getEditText().getText().toString()) - 100 - (Double.parseDouble(textInput.getEditText().getText().toString()) - 150) / 4 + (Double.parseDouble(textInput2.getEditText().getText().toString())-20)/constante;
                                resultado = Math.round(resultado*100.0)/100.0;
                                textView2.setAlpha(1);
                                textView2.setText(resultado + "Kg");
                            }
                            break;
                        case 4:
                            if (textInput2.getEditText().getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Error en la edad", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                resultado = (Double.parseDouble(textInput.getEditText().getText().toString())-100+Double.parseDouble(textInput2.getEditText().getText().toString())/10);
                                if (morphology == Morphology.BROAD) {
                                    resultado = resultado * 0.9 * 1.1;
                                } else if (morphology == Morphology.SMALL) {
                                    resultado = resultado * 0.9 * 0.9;
                                } else {
                                    resultado = resultado * 0.9;
                                }
                                resultado = Math.round(resultado*100.0)/100.0;
                                textView2.setAlpha(1);
                                textView2.setText(resultado + "Kg");
                            }
                            break;
                    }
                }
            }
        });








    }
}