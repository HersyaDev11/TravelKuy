package com.example.travelkuy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 1. Tangkap Data dari Intent
        val wisata = intent.getParcelableExtra<Wisata>("key_wisata")

        // 2. Hubungkan View
        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val btnBack: ImageButton = findViewById(R.id.btn_back_detail)
        val btnShare: Button = findViewById(R.id.btn_share)
        val btnFavorite: Button = findViewById(R.id.btn_action_favorite)

        // 3. Tampilkan Data
        if (wisata != null) {
            imgPhoto.setImageResource(wisata.photo)
            tvName.text = wisata.nama
            tvLocation.text = wisata.lokasi
            tvDescription.text = wisata.deskripsi

            // Cek Status Favorit Awal
            checkFavoriteStatus(wisata, btnFavorite)

            // Logika Tombol Favorit
            btnFavorite.setOnClickListener {
                if (WisataData.listFavorit.contains(wisata)) {
                    // Jika sudah ada, hapus
                    WisataData.listFavorit.remove(wisata)
                    Toast.makeText(this, "Dihapus dari Favorit", Toast.LENGTH_SHORT).show()
                } else {
                    // Jika belum, tambahkan
                    WisataData.listFavorit.add(wisata)
                    Toast.makeText(this, "Ditambahkan ke Favorit ❤️", Toast.LENGTH_SHORT).show()
                }
                checkFavoriteStatus(wisata, btnFavorite)
            }
        }

        // 4. Tombol Back
        btnBack.setOnClickListener {
            finish()
        }

        // 5. Tombol Share (Bagikan)
        btnShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Ayo liburan ke ${wisata?.nama} di ${wisata?.lokasi}! Cek di aplikasi WisataKuy.")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan ke:"))
        }
    }

    // Fungsi Mengubah Tampilan Tombol Favorit
    private fun checkFavoriteStatus(wisata: Wisata, btn: Button) {
        if (WisataData.listFavorit.contains(wisata)) {
            btn.text = "HAPUS FAVORIT"
            btn.setBackgroundColor(android.graphics.Color.parseColor("#D32F2F")) // Merah
            btn.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_delete, 0, 0, 0)
        } else {
            btn.text = "FAVORIT"
            btn.setBackgroundColor(android.graphics.Color.parseColor("#009688")) // Teal
            btn.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.btn_star_big_on, 0, 0, 0)
        }
    }
}