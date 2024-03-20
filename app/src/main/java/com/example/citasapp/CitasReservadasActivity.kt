package com.example.citasapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.citasapp.R.id.btn_aceptar

class CityCancelled : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reservar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAceptar = findViewById<Button>(btn_aceptar)
        btnAceptar.setOnClickListener {
            gotoMenu()
        }

        val btnCancelar = findViewById<Button>(R.id.btn_cancelar)
        btnCancelar.setOnClickListener {
            finish()
        }

        val selectedSpecialty = intent.getStringExtra("selectedSpecialty")
        val selectedDoctor = intent.getStringExtra("selectedDoctor")
        val selectedDate = intent.getStringExtra("selectedDate")

        findViewById<TextView>(R.id.textViewEspecialidadValue)?.text = selectedSpecialty
        findViewById<TextView>(R.id.textViewMedicoValue)?.text = selectedDoctor
        findViewById<TextView>(R.id.fecha)?.text = selectedDate
    }

    private fun gotoMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
