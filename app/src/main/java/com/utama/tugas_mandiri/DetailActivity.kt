package com.utama.tugas_mandiri

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val barang = intent.getSerializableExtra("EXTRA_BARANG") as? Barang

        if (barang != null) {
            findViewById<TextView>(R.id.tvDetailNama).text = barang.nama_barang
            findViewById<TextView>(R.id.tvDetailKategori).text = "Kategori: ${barang.kategori}"
            findViewById<TextView>(R.id.tvDetailStok).text = "Stok: ${barang.stok}"
            findViewById<TextView>(R.id.tvDetailDeskripsi).text = barang.deskripsi

            val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
            findViewById<TextView>(R.id.tvDetailHarga).text = format.format(barang.harga)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
