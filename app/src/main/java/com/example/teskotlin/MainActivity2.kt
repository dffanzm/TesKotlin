package com.example.teskotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Temukan semua tombol berdasarkan ID
        val buttonNext = findViewById<Button>(R.id.button_next)
        val buttonKontak = findViewById<Button>(R.id.buttonkontak) // Menggunakan ID dari XML Anda
        val buttonMaps = findViewById<Button>(R.id.buttonmaps)

        // --- Logika Tombol NEXT (Pindah Activity) ---
        buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        // --- LOGIKA TOMBOL MAPS (Buka Google Maps ke Bandung) ---
        buttonMaps.setOnClickListener {
            // URL Intent ke Bandung
            val gmmIntentUri = Uri.parse("geo:-6.917464,107.619123?q=Bandung")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            // Memaksa dibuka di Google Maps. Jika Maps tidak ada, ini akan gagal.
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(this, "Aplikasi Google Maps tidak ditemukan.", Toast.LENGTH_LONG).show()
            }
        }

        // --- LOGIKA TOMBOL KONTAK (Buka Daftar Kontak) ---
        buttonKontak.setOnClickListener {
            // Action_VIEW ke URI kontak, yang akan membuka Daftar Kontak HP
            val contactIntent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))

            if (contactIntent.resolveActivity(packageManager) != null) {
                startActivity(contactIntent)
            } else {
                Toast.makeText(this, "Tidak ada aplikasi Kontak yang terinstal.", Toast.LENGTH_LONG).show()
            }
        }
    }
}