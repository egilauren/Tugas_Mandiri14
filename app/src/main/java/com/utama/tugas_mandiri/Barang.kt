package com.utama.tugas_mandiri

import java.io.Serializable

data class Barang(
    val id: Int,
    val nama_barang: String,
    val kategori: String,
    val stok: Int,
    val harga: Int,
    val deskripsi: String
) : Serializable
