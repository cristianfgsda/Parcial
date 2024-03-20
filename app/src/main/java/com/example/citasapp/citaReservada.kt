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

class citaReservada : AppCompatActivity() {
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

        val fechaRecibida = findViewById<TextView>(R.id.fechaResivida)
        val recibirFecha: String = intent.getStringExtra("EXTRA_MENSAJE").orEmpty()
        fechaRecibida.text = recibirFecha

        val textViewEspecialidad = findViewById<TextView>(R.id.especialidadResivida)
        val selectedItem = intent.getStringExtra("selectedItem")
        textViewEspecialidad.text = selectedItem

        val textViewMedico = findViewById<TextView>(R.id.textMedico)
        val selectedMedico = intent.getStringExtra("selectedItem2")
        textViewMedico.text = selectedMedico

        val buttonAceptar = findViewById<Button>(R.id.btn_aceptar)
        buttonAceptar.setOnClickListener {
            val intent = Intent(this, menuMobile::class.java)
            startActivity(intent)
        }

        val buttonCancelar = findViewById<Button>(R.id.btn_cancelar)
        buttonCancelar.setOnClickListener {
            val intent = Intent(this, citaCancelada::class.java)
            startActivity(intent)
        }
    }
}
