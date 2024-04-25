package com.cis436.project4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(private var dataSet : List<String>) : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val quote : TextView = view.findViewById(R.id.tvQuoteSaved)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.quote.text = dataSet[position]
    }
}