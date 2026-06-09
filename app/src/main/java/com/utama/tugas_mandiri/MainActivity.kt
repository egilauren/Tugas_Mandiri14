package com.utama.tugas_mandiri

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvPosts = findViewById<RecyclerView>(R.id.rvPosts)
        val tvError = findViewById<TextView>(R.id.tvError)

        rvPosts.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitClient.instance.create(ApiService::class.java)

        apiService.getBarang().enqueue(object : Callback<List<Barang>> {
            override fun onResponse(call: Call<List<Barang>>, response: Response<List<Barang>>) {
                if (response.isSuccessful) {
                    val listBarang = response.body() ?: emptyList()
                    rvPosts.adapter = BarangAdapter(listBarang)
                } else {
                    tvError.visibility = View.VISIBLE
                    tvError.text = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Barang>>, t: Throwable) {
                tvError.visibility = View.VISIBLE
                tvError.text = "Gagal: ${t.localizedMessage}\n\nPastikan HP & Laptop di Wi-Fi yang sama dan Firewall mati."
            }
        })
    }
}