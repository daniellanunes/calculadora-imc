package com.daniellanunes.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnAcesso : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnAcesso = findViewById(R.id.btn_acesso)
        btnAcesso.setOnClickListener {
            var intent = Intent (this, CalculadoraActivity::class.java)
            startActivity(intent)
        }
    }
}