package com.example.travelkuy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val tvRegister = findViewById<TextView>(R.id.tv_register)

        // AKSI TOMBOL LOGIN
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Validasi sederhana: tidak boleh kosong// ... kode validasi username password ...
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi dulu dong!", Toast.LENGTH_SHORT).show()
            } else {
                // UBAH BAGIAN INI: Tujuan diganti ke DashboardActivity
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // AKSI TEKS REGISTER (Pindah ke halaman daftar)
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}