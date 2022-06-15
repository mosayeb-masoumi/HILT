package com.example.hilttest.recyclerView.with_activity_module

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hilttest.R

class MyAdapter () : RecyclerView.Adapter<MyViewHolder>(){


    private var list: MutableList<String> = ArrayList()
    private var context: Context? = null

    // we dont use constructor to set data
    fun setAdapterList(myList: MutableList<String> , myContext: Context) {
        list = myList
        context = myContext
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view, context!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = list.get(position)
//        model?.let { holder.bindData(it, position) }
        holder.bindData(model, position)
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}