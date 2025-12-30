package com.example.travelkuy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan variabel dengan ID di XML
        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        // --- UPDATE LOGIKA PENCARIAN (FILTER) ---

        // 1. Cek apakah ada kiriman kata kunci dari Dashboard?
        val keyword = intent.getStringExtra("CARI_WISATA")

        if (keyword != null && keyword.isNotEmpty()) {
            // JIKA ADA PENCARIAN:
            // Saring data dari WisataData.listDestinasi
            // Ambil yang namanya mengandung kata kunci (ignoreCase = huruf besar/kecil dianggap sama)
            val hasilPencarian = WisataData.listDestinasi.filter { wisata ->
                wisata.nama.contains(keyword, ignoreCase = true)
            }

            // Masukkan hasil saringan ke list yang mau ditampilkan
            list.addAll(hasilPencarian)

            // (Opsional) Ubah judul activity biar keren
            title = "Hasil: $keyword"

        } else {
            // JIKA TIDAK ADA PENCARIAN (Dibuka lewat tombol menu biasa):
            // Tampilkan semua data seperti biasa
            list.addAll(WisataData.listDestinasi)
            title = "Daftar Wisata"
        }

        showRecyclerList()
    }

    private fun showRecyclerList() {
        // Mengatur layout menjadi baris ke bawah (Linear)
        rvWisata.layoutManager = LinearLayoutManager(this)

        // Memasang Adapter
        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter
    }
}