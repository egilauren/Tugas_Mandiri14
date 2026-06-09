package com.utama.tugas_mandiri

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("get_barang.php")
    fun getBarang(): Call<List<Barang>>
}
