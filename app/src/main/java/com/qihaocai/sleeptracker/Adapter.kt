package com.qihaocai.sleeptracker


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val list: List<SleepEntity>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val Hours: TextView
        val Date: TextView
//        val priceTextView: TextView

        init{
//            itemNameTextView = itemView.findViewById(R.id.itemname)
            Hours = itemView.findViewById(R.id.Hours)
            Date = itemView.findViewById(R.id.Date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.item_temp, parent, false)

        return ViewHolder((contactView))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemTemp = list.get(position)
        holder.Hours.text = ItemTemp.Hours + " Hours"
        holder.Date.text = ItemTemp.Date
//        holder.priceTextView.text = ItemTemp.price

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
