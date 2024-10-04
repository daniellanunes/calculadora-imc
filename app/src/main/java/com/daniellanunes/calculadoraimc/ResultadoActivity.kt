package com.daniellanunes.calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    lateinit var textResultado : TextView
    lateinit var textPeso : TextView
    lateinit var textAlturaView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        componentesInterface()

        val bundle = intent.extras
        if (bundle != null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso Informado: $peso kg"
            textAlturaView.text = "Altura Informada: $altura m"

            val imc = peso / (altura * altura)
            val resultado = String.format("%.1f", imc)
            textResultado.text = if (resultado.toDouble() < 18.5){
                "IMC = $resultado - Peso Abaixo do Ideal"
            }else if (18.5 <= resultado.toDouble() && resultado.toDouble() <= 24.9){
                "IMC = $resultado - Peso Ideal"
            }else if (resultado.toDouble() in 25.0.. 29.9 ){
                "IMC = $resultado - Apresentando Sobrepeso, Peso Acima do Ideal"
            }else {
                "IMC = $resultado - Apresentando Obesidade, Peso Muito Acima do Ideal"
            }

        }

    }

    private fun componentesInterface() {

        textResultado = findViewById(R.id.text_result)
        textAlturaView = findViewById(R.id.text_altura)
        textPeso = findViewById(R.id.text_view_peso)
    }
}

