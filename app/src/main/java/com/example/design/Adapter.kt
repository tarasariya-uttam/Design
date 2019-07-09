package com.example.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView1.text = "Bitcoins"
        holder.textView2.text = "$3,630.33"
        holder.textView3.text = "0.0025 BTC"
        holder.textView4.text = "$9.07"
        holder.imageViewBitcoin.setImageResource(R.drawable.baseline_account_circle_black_24)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val textView3: TextView = itemView.findViewById(R.id.textView3)
        val textView4: TextView = itemView.findViewById(R.id.textView4)
        val imageViewBitcoin: ImageView = itemView.findViewById(R.id.imageViewBitcoin)
    }
}