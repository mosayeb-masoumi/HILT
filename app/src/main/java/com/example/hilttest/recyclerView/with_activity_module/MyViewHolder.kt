package com.example.hilttest.recyclerView.with_activity_module

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hilttest.R

class MyViewHolder (view: View, val context: Context) : RecyclerView.ViewHolder(view) {

    private val txt: TextView = view.findViewById(R.id.txt_row)

    fun bindData(model: String, position: Int) {
        var title = model +  position.toString()
        txt.text = title
    }
}