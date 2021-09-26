package com.sisalma.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class provinceValue(val value: Float, val name: String, val display: String, val id: Int){}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcView: RecyclerView = findViewById(R.id.kotakList)
        val jsonString = getJsonDataFromAssets(applicationContext,"dataLatihan.json")
        val gson = Gson()
        val listProvince = object : TypeToken<List<provinceValue>>(){}.type
        var provinsi: List<provinceValue> = gson.fromJson(jsonString, listProvince)
        Log.e("gson parser",provinsi[2].name)

        val adapter = dataAdapter(provinsi)

        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(this)
    }
}

