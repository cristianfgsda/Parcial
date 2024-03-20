package com.example.citasapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReservableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reservar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerSpecialties = findViewById<Spinner>(R.id.firstSpinner)
        val spinnerDoctor = findViewById<Spinner>(R.id.secondSpinner)

        val optionsSpecialties = arrayOf("", "Medicina general", "Especialidad 2", "Especialidad 3")
        val specialtiesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsSpecialties)
        specialtiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSpecialties.adapter = specialtiesAdapter

        val optionsDoctor = arrayOf("", "Médico juan", "Médico pedro", "Médica fran")
        val doctorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsDoctor)
        doctorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDoctor.adapter = doctorAdapter

        val button = findViewById<Button>(R.id.reservarButton)
        val fecha = findViewById<EditText>(R.id.dateEditText)

        button.setOnClickListener {
            val selectedSpecialty = spinnerSpecialties.selectedItem.toString()
            val selectedDoctor = spinnerDoctor.selectedItem.toString()
            val selectedDate = fecha.text.toString()

            val enviarCita = Intent(this, CityServandaActivity::class.java).apply {
                putExtra("selectedSpecialty", selectedSpecialty)
                putExtra("selectedDoctor", selectedDoctor)
                putExtra("selectedDate", selectedDate)
            }
            startActivity(enviarCita)
            }
        }
}