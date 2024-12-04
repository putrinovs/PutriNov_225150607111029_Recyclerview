package com.example.pamub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamub.data.Mahasiswa
import com.example.pamub.R

class MahasiswaAdapter(private val mahasiswaList: List<Mahasiswa>) : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNama: TextView = itemView.findViewById(R.id.textViewNama)
        val textViewNim: TextView = itemView.findViewById(R.id.textViewNim)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_hasil, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mahasiswa = mahasiswaList[position]
        holder.textViewNama.text = mahasiswa.nama
        holder.textViewNim.text = mahasiswa.nim
    }

    override fun getItemCount(): Int {
        return mahasiswaList.size
    }
}