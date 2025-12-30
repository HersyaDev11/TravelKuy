package com.example.travelkuy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val nama: String,
    val lokasi: String,
    val deskripsi: String,
    val photo: Int // Mengambil gambar dari folder Drawable
) : Parcelable