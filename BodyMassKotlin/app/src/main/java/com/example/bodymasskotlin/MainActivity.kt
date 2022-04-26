package com.example.bodymasskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private lateinit var rGroup: RadioGroup
    private lateinit var rGroup2: RadioGroup
    private lateinit var rGroup3: RadioGroup
    private lateinit var male: RadioButton
    private lateinit var small: RadioButton
    private lateinit var textInput: TextInputLayout
    private lateinit var textInput2: TextInputLayout
    private lateinit var table: TableLayout
    private lateinit var textView2: TextView
    private lateinit var relative: RelativeLayout
    private lateinit var gender: Gender
    private lateinit var morphology: Morphology
    private var seleccion: Int = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rGroup = findViewById(R.id.rGroup)
        rGroup2 = findViewById(R.id.rGroup2)
        rGroup3 = findViewById(R.id.rGroup3)
        findViewById<RadioButton>(R.id.relativeFat)
        findViewById<RadioButton>(R.id.wanDer)
        findViewById<RadioButton>(R.id.loretz)
        findViewById<RadioButton>(R.id.creff)
        male = findViewById(R.id.male)
        findViewById<RadioButton>(R.id.female)
        small = findViewById(R.id.small)
        findViewById<RadioButton>(R.id.medium)
        findViewById<RadioButton>(R.id.broad)
        textInput = findViewById(R.id.textInput)
        textInput2 = findViewById(R.id.textInput2)
        table = findViewById(R.id.tabla)
        textView2 = findViewById(R.id.textView2)
        val button: Button = findViewById(R.id.button)
        relative = findViewById(R.id.relative)
        rGroup3.setOnCheckedChangeListener { _, _ ->
            when (rGroup3.checkedRadioButtonId) {
                R.id.relativeFat -> {
                    relative.alpha = 1f
                    textInput2.visibility = View.VISIBLE
                    rGroup.visibility = View.VISIBLE
                    rGroup2.visibility = View.GONE
                    male.isChecked = true
                    textInput2.setHint(R.string.waist_circumference_cm)
                    gender = Gender.MALE
                    textView2.alpha = 0f
                    seleccion = 1
                }
                R.id.wanDer -> {
                    relative.alpha = 1f
                    textInput2.visibility = View.GONE
                    rGroup.visibility = View.VISIBLE
                    rGroup2.visibility = View.GONE
                    male.isChecked = true
                    table.alpha = 0f
                    gender = Gender.MALE
                    textView2.alpha = 0f
                    seleccion = 2
                }
                R.id.loretz -> {
                    relative.alpha = 1f
                    textInput2.visibility = View.VISIBLE
                    rGroup.visibility = View.VISIBLE
                    rGroup2.visibility = View.GONE
                    textInput2.setHint(R.string.age)
                    table.alpha = 0f
                    male.isChecked = true
                    gender = Gender.MALE
                    textView2.alpha = 0f
                    seleccion = 3
                }
                R.id.creff -> {
                    relative.alpha = 1f
                    textInput2.visibility = View.VISIBLE
                    rGroup.visibility = View.GONE
                    rGroup2.visibility = View.VISIBLE
                    textInput2.setHint(R.string.age)
                    table.alpha = 0f
                    small.isChecked = true
                    morphology = Morphology.SMALL
                    textView2.alpha = 0f
                    seleccion = 4
                }
            }
        }
        rGroup2.setOnCheckedChangeListener { _, _ ->
            when (rGroup2.checkedRadioButtonId) {
                R.id.small -> morphology = Morphology.SMALL
                R.id.medium -> morphology = Morphology.MEDIUM
                R.id.broad -> morphology = Morphology.BROAD
            }
        }
        rGroup.setOnCheckedChangeListener { _, _ ->
            when (rGroup.checkedRadioButtonId) {
                R.id.male -> gender = Gender.MALE
                R.id.female -> gender = Gender.FEMALE
            }
        }
        button.setOnClickListener {
            var resultado: Double
            val constante: Double
            if (textInput.editText!!.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "Error en la altura", Toast.LENGTH_SHORT)
                    .show()
            } else {
                when (seleccion) {
                    1 -> if (textInput2.editText!!.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext,
                            "Error en la cintura",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        constante = if (gender === Gender.MALE) {
                            Constants.N_hombre
                        } else {
                            Constants.N_mujer
                        }
                        resultado = constante - 20 * textInput.editText!!.text.toString()
                            .toDouble() / textInput2.editText!!
                            .text.toString().toDouble()
                        resultado = (resultado * 100.0).roundToInt() / 100.0
                        textView2.alpha = 1f
                        textView2.text = "$resultado%"
                        table.alpha = 1f
                    }
                    2 -> {
                        constante = if (gender === Gender.MALE) {
                            Constants.M_hombre
                        } else {
                            Constants.M_muujer
                        }
                        resultado = (textInput.editText!!.text.toString()
                            .toDouble() - 150) * constante + 50
                        resultado = (resultado * 100.0).roundToInt() / 100.0
                        textView2.alpha = 1f
                        textView2.text = resultado.toString() + "Kg"
                    }
                    3 -> if (textInput2.editText!!.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext,
                            "Error en la edad",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        constante = if (gender === Gender.MALE) {
                            Constants.K_hombre
                        } else {
                            Constants.K_muujer
                        }
                        resultado = textInput.editText!!.text.toString()
                            .toDouble() - 100 - (textInput.editText!!
                            .text.toString().toDouble() - 150) / 4 + (textInput2.editText!!
                            .text.toString().toDouble() - 20) / constante
                        resultado = (resultado * 100.0).roundToInt() / 100.0
                        textView2.alpha = 1f
                        textView2.text = resultado.toString() + "Kg"
                    }
                    4 -> if (textInput2.editText!!.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext,
                            "Error en la edad",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        resultado = textInput.editText!!.text.toString()
                            .toDouble() - 100 + textInput2.editText!!
                            .text.toString().toDouble() / 10
                        resultado = when {
                            morphology === Morphology.BROAD -> {
                                resultado * 0.9 * 1.1
                            }
                            morphology === Morphology.SMALL -> {
                                resultado * 0.9 * 0.9
                            }
                            else -> {
                                resultado * 0.9
                            }
                        }
                        resultado = (resultado * 100.0).roundToInt() / 100.0
                        textView2.alpha = 1f
                        textView2.text = resultado.toString() + "Kg"
                    }
                }
            }
        }
    }
}
