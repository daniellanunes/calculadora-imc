package com.daniellanunes.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CalculadoraActivity : AppCompatActivity() {

    lateinit var textInputPeso : TextInputLayout
    lateinit var textEditPeso : TextInputEditText

    lateinit var textInputAltura : TextInputLayout
    lateinit var textEditAltura : TextInputEditText

    lateinit var btnCalcular : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        componentesInterface()

        btnCalcular.setOnClickListener {
            val intent = Intent (this, ResultadoActivity::class.java)

            var peso = textEditPeso.text.toString()
            var altura = textEditAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }


    }



    private fun componentesInterface() {
        textEditAltura = findViewById(R.id.text_edit_altura)
        textInputAltura = findViewById(R.id.text_input_altura)

        textEditPeso = findViewById(R.id.text_edit_peso)
        textInputPeso = findViewById(R.id.text_input_peso)

        btnCalcular = findViewById(R.id.btn_calcular)
    }

}