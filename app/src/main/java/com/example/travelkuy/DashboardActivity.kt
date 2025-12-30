package com.example.travelkuy

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // --- SETUP TOMBOL MENU GRID ---

        // 1. Klik Wisata
        findViewById<CardView>(R.id.card_menu_wisata).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // 2. Klik Favorit
        findViewById<CardView>(R.id.card_menu_favorite).setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        // 3. Klik Profil
        findViewById<CardView>(R.id.card_menu_profile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // 4. Klik Info/About
        findViewById<CardView>(R.id.card_menu_about).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        // 5. Klik Keluar
        findViewById<Button>(R.id.btn_menu_exit).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // --- SETUP PENCARIAN ---
        val etSearch = findViewById<EditText>(R.id.et_search)
        etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE) {
                val keyword = etSearch.text.toString()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("CARI_WISATA", keyword)
                startActivity(intent)
                true
            } else {
                false
            }
        }
    }
}