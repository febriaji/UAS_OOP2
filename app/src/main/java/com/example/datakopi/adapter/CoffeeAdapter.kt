package com.example.datakopi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datakopi.R
import com.example.datakopi.model.coffee
import kotlinx.android.synthetic.main.item_kopi.view.*

class CoffeeAdapter (val context: Context):RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {
    private var coffees : MutableList<coffee> = mutableListOf()
    inner class CoffeeViewHolder (i: View):RecyclerView.ViewHolder(i){
        val tvId: TextView = i.findViewById(R.id.tv_id)
        val tvNamaKopi: TextView = i.findViewById(R.id.tv_namaKopi)
        val tvJenisKopi: TextView = i.findViewById(R.id.tv_jenisKopi)
        val tvAsalKopi: TextView = i.findViewById(R.id.tv_asalKopi)
        val tvStok: TextView = i.findViewById(R.id.tv_stok)
        fun bindModel(c : coffee){
            tvId.text=c.getId().toString()
            tvNamaKopi.text=c.getNamaKopi()
            tvJenisKopi.text=c.getJenisKopi()
            tvAsalKopi.text=c.getAsalKopi()
            tvStok.text=c.getStok()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_kopi, parent, false))
    }

    override fun getItemCount(): Int {
        return coffees.size
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bindModel(coffees[position])
    }

    fun setCoffee(data: List<coffee>){
        coffees.clear()
        coffees.addAll(data)
        notifyDataSetChanged()
    }
}