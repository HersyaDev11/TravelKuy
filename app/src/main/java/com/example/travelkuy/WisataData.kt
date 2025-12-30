package com.example.travelkuy

object WisataData {
    // List Utama (Semua Wisata)
    val listDestinasi = arrayListOf<Wisata>(
        Wisata(
            "Waduk Darma",
            "Kuningan, Jawa Barat",
            "Waduk buatan eksotis dengan pemandangan Gunung Ciremai. Cocok untuk rekreasi perahu, memancing, dan menikmati sunset yang memukau.",
            R.drawable.waduk_darma
        ),
        Wisata(
            "Curug Putri",
            "Palutungan, Kuningan",
            "Air terjun legendaris di kaki Gunung Ciremai. Suasananya sejuk, asri, dan airnya dipercaya bisa bikin awet muda!",
            R.drawable.curug_putri
        ),
        Wisata(
            "Telaga Biru Cicerem",
            "Kaduela, Kuningan",
            "Danau viral dengan air sebening kaca berwarna biru tosca. Kamu bisa berfoto ria dikelilingi ikan-ikan mas yang cantik.",
            R.drawable.telaga_biru
        ),
        Wisata(
            "Gedung Naskah Linggarjati",
            "Linggarjati, Kuningan",
            "Wisata sejarah saksi bisu perundingan Indonesia-Belanda. Bangunan kolonial yang megah dengan taman yang sangat luas dan rusa tutul.",
            R.drawable.gedung_naskah
        ),
        Wisata(
            "Sukageuri View",
            "Cisantana, Kuningan",
            "Spot gardu pandang di atas bukit batu. Tempat terbaik untuk berburu sunrise dan menikmati kopi dengan view kota Kuningan dari ketinggian.",
            R.drawable.sukageuri_view
        ),
    )

    // List Favorit (Awalnya kosong, nanti terisi otomatis saat user klik Love)
    val listFavorit = arrayListOf<Wisata>()
}