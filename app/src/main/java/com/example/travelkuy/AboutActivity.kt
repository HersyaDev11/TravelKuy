package com.example.travelkuy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView // Jangan lupa import ini

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // 1. Tombol Back
        val btnBack = findViewById<ImageButton>(R.id.btn_back_about)
        btnBack.setOnClickListener {
            finish()
        }

        // 2. Tombol Kirim Email
        val btnEmail = findViewById<CardView>(R.id.btn_contact_email)
        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: amel123@example.com") // Ganti email kamu
            intent.putExtra(Intent.EXTRA_SUBJECT, "Tanya Seputar TravelKuy")
            startActivity(Intent.createChooser(intent, "Kirim Email"))
        }

        // 3. Tombol WhatsApp
        val btnWhatsapp = findViewById<CardView>(R.id.btn_contact_whatsapp)
        btnWhatsapp.setOnClickListener {
            val nomorHP = "6283129356225" // Ganti nomor WA kamu (pakai kode negara 62)
            val pesan = "Halo Admin TravelKuy, saya mau tanya..."

            val url = "https://api.whatsapp.com/send?phone=$nomorHP&text=${Uri.encode(pesan)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}