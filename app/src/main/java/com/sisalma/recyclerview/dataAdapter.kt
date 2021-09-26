package com.sisalma.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class dataAdapter(objekProvinsi: List<provinceValue>) : RecyclerView.Adapter<dataAdapter.ViewHolder>() {
    var length: Int = objekProvinsi.size
    var data: List<provinceValue> = objekProvinsi

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val provinceName = view.findViewById<TextView>(R.id.provinceName)
        val provinceNum = view.findViewById<TextView>(R.id.provinceValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val provinceList = inflater.inflate(R.layout.row_table, parent,false)

        return ViewHolder(provinceList)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rawData = data
        holder.provinceName.text = rawData[position].name
        holder.provinceNum.text = rawData[position].value.toString()

    }

    override fun getItemCount(): Int {
        return length
    }
}