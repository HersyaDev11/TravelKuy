package com.example.travelkuy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.btn_register)
        val tvLoginLink = findViewById<TextView>(R.id.tv_login_link)

        btnRegister.setOnClickListener {
            // Ceritanya data disimpan ke database (Logic dummy)
            Toast.makeText(this, "Registrasi Berhasil! Silakan Login", Toast.LENGTH_SHORT).show()
            finish() // Kembali ke halaman Login
        }

        tvLoginLink.setOnClickListener {
            finish() // Kembali ke halaman Login
        }
    }
}