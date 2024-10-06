package com.nadila.recycleviewnadila

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadila.recycleviewnadila.Adapter.BukuAdapter
import com.nadila.recycleviewnadila.Model.ModelBuku
class RecycleViewActivity : AppCompatActivity() {
    private lateinit var rv_data : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        rv_data = findViewById(R.id.rv_data)
        //kita bikin array data
        val listBuku = listOf(
            ModelBuku(judul = "Matematika", penerbit = "Nadila"),
            ModelBuku(judul = "Bahasa Indonesia", penerbit = "Dila"),
            ModelBuku(judul = "PPKN", penerbit = "Dil"),
            ModelBuku(judul = "Sejarah", penerbit = "Ernesti"),
            ModelBuku(judul = "Agama", penerbit = "Laaa"),
        )
        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}