package com.utama.tugas_mandiri

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class BarangAdapter(private val listBarang: List<Barang>) : RecyclerView.Adapter<BarangAdapter.BarangViewHolder>() {

    class BarangViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvTitle)
        val tvHarga: TextView = view.findViewById(R.id.tvBody)
        val tvKategori: TextView = view.findViewById(R.id.tvCategoryBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return BarangViewHolder(view)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val barang = listBarang[position]
        holder.tvNama.text = barang.nama_barang
        holder.tvKategori.text = barang.kategori
        
        val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        holder.tvHarga.text = format.format(barang.harga)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("EXTRA_BARANG", barang)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listBarang.size
}
