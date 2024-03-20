package com.example.citasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnReservableCity = findViewById<Button>(R.id.btn_Reservar_cita)
        btnReservableCity.setOnClickListener {
            goToReservar()
        }


        val tvGoCerrar = findViewById<Button>(R.id.tv_go_to_cerrar)
        tvGoCerrar.setOnClickListener {
            goToMenu()
        }
    }

    private fun goToReservar() {
        val intent = Intent(this, ReservableActivity::class.java)
        startActivity(intent)
    }

    private fun goToMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
