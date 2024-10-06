package com.nadila.recycleviewnadila

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadila.recycleviewnadila.Adapter.BuahAdapter
import com.nadila.recycleviewnadila.Model.MockList
import com.nadila.recycleviewnadila.Model.ModelBuah

class RecycleBuahActivity : AppCompatActivity() {
    private lateinit var rv_buah : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_buah)
        rv_buah = findViewById(R.id.rv_buah)
        rv_buah.layoutManager = GridLayoutManager(this,1)
        val adapter = BuahAdapter(MockList.getModel() as ArrayList<ModelBuah>)
        rv_buah.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}