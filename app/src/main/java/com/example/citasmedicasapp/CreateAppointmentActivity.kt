package com.example.citasmedicasapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateAppointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_appointment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinnerSpecialties = findViewById<Spinner>(R.id.spinner_especialidades)
        val spinnerDoctor = findViewById<Spinner>(R.id.spinner_medico)


        val optionsSpecialties = arrayOf("Especialidad 1", "Especialidad 2", "Especialidad 3")
        spinnerSpecialties.adapter = arrayAdapter<Strings>(this, android.R.layouth.simple_list_item_1, optionsSpecialties)

        val optionsDoctor = arrayOf("Doctor 1", "Doctor 2", "Doctor 3")
        spinnerDoctor.adapter = arrayAdapter<Strings>(this, android.R.layouth.simple_list_item_1, optionsDoctor)
    }

}