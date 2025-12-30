package com.example.travelkuy

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteActivity : AppCompatActivity() {

    private lateinit var rvFavorite: RecyclerView
    private lateinit var tvCount: TextView
    private var list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // Hubungkan variabel
        rvFavorite = findViewById(R.id.rv_favorite)
        tvCount = findViewById(R.id.tv_favorite_count)
        val btnBack = findViewById<ImageButton>(R.id.btn_back_fav)

        rvFavorite.setHasFixedSize(true)

        // Ambil data dari List Favorit yang ada di WisataData
        list.addAll(WisataData.listFavorit)

        // Update teks jumlah destinasi
        tvCount.text = "${list.size} Destinasi tersimpan"

        showRecyclerList()

        // Tombol Back
        btnBack.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }
    }

    private fun showRecyclerList() {
        rvFavorite.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        rvFavorite.adapter = listWisataAdapter
    }

    // Agar saat user menghapus favorit dan kembali ke sini, datanya refresh
    override fun onResume() {
        super.onResume()
        list.clear()
        list.addAll(WisataData.listFavorit)
        tvCount.text = "${list.size} Destinasi tersimpan"
        rvFavorite.adapter?.notifyDataSetChanged()
    }
}