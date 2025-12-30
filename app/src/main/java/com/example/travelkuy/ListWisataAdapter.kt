package com.example.travelkuy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListWisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wisata = listWisata[position]

        // Pasang data ke tampilan baru
        holder.imgPhoto.setImageResource(wisata.photo)
        holder.tvName.text = wisata.nama
        holder.tvDescription.text = wisata.deskripsi

        // Data Lokasi sekarang dimasukkan ke Badge Lokasi
        holder.tvLocationBadge.text = wisata.lokasi

        // --- FITUR TOMBOL FAVORIT DI KARTU (OPSIONAL) ---
        // Cek status favorit saat ini
        val isFavorite = WisataData.listFavorit.contains(wisata)
        updateFavoriteIcon(holder.btnFavorite, isFavorite)

        // Aksi saat tombol hati diklik
        holder.btnFavorite.setOnClickListener {
            if (WisataData.listFavorit.contains(wisata)) {
                WisataData.listFavorit.remove(wisata)
                updateFavoriteIcon(holder.btnFavorite, false)
                Toast.makeText(holder.itemView.context, "${wisata.nama} dihapus dari Favorit", Toast.LENGTH_SHORT).show()
            } else {
                WisataData.listFavorit.add(wisata)
                updateFavoriteIcon(holder.btnFavorite, true)
                Toast.makeText(holder.itemView.context, "${wisata.nama} jadi Favorit! ❤️", Toast.LENGTH_SHORT).show()
            }
        }
        // --------------------------------------------------

        // Klik Kartu untuk ke Detail
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("key_wisata", wisata)
            holder.itemView.context.startActivity(intent)
        }
    }

    // Fungsi helper untuk mengubah ikon hati (Penuh/Kosong)
    private fun updateFavoriteIcon(button: ImageButton, isFavorite: Boolean) {
        if (isFavorite) {
            // Kalau favorit, pakai ikon bintang penuh (Ganti dengan ikon hati nanti)
            button.setImageResource(android.R.drawable.btn_star_big_on)
            button.setColorFilter(android.graphics.Color.parseColor("#E91E63")) // Warna Pink
        } else {
            // Kalau bukan, pakai ikon bintang kosong putih
            button.setImageResource(android.R.drawable.btn_star_big_off)
            button.setColorFilter(android.graphics.Color.WHITE)
        }
    }

    override fun getItemCount(): Int = listWisata.size

    // Definisi Variabel UI yang baru
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        // INI YANG BARU: Badge Lokasi & Tombol Favorit
        val tvLocationBadge: TextView = itemView.findViewById(R.id.tv_item_location_badge)
        val btnFavorite: ImageButton = itemView.findViewById(R.id.btn_item_favorite)
    }
}