package com.example.pamub

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamub.adapter.MahasiswaAdapter
import com.example.pamub.data.DatabaseHelper
import com.example.pamub.data.Mahasiswa

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MahasiswaAdapter
    private lateinit var mahasiswaList: MutableList<Mahasiswa>
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var editTextNama: EditText
    private lateinit var editTextNim: EditText
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editTextNama = findViewById(R.id.editTextNama)
        editTextNim = findViewById(R.id.editTextNim)
        buttonAdd = findViewById(R.id.buttonAdd)

        // Inisialisasi database helper
        databaseHelper = DatabaseHelper(this)

        // Inisialisasi list mahasiswa
        mahasiswaList = mutableListOf()

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MahasiswaAdapter(mahasiswaList)
        recyclerView.adapter = adapter

        // Tombol Tambah Mahasiswa
        buttonAdd.setOnClickListener {
            val nama = editTextNama.text.toString()
            val nim = editTextNim.text.toString()

            if (nama.isNotBlank() && nim.isNotBlank()) {
                val mahasiswa = Mahasiswa(nama, nim)
                mahasiswaList.add(mahasiswa)
                adapter.notifyDataSetChanged()


                databaseHelper.addMahasiswa(mahasiswa)

                // Reset input
                editTextNama.text.clear()
                editTextNim.text.clear()
                Toast.makeText(this, "Mahasiswa berhasil ditambahkan!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nama dan NIM tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
