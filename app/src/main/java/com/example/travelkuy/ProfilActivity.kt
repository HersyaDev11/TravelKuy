package com.example.travelkuy

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        // Tombol Back di Kiri Atas (Ikon Panah)
        val btnBackTop = findViewById<ImageButton>(R.id.btn_back_profile)
        btnBackTop.setOnClickListener {
            finish()
        }

        // Tombol Teks di Paling Bawah
        val btnBackBottom = findViewById<Button>(R.id.btn_back_to_menu)
        btnBackBottom.setOnClickListener {
            finish()
        }
    }
}