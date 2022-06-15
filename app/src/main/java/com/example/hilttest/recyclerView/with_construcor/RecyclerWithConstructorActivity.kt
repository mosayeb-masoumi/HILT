package com.example.hilttest.recyclerView.with_construcor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilttest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recycler.*
import javax.inject.Inject


@AndroidEntryPoint
class RecyclerWithConstructorActivity : AppCompatActivity() {

    @Inject
    lateinit var myAdapterWithConstructor: MyAdapterWithConstructor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_with_constructor)


        val nameList:MutableList<String> = ArrayList()
        nameList.add("ali")
        nameList.add("reza")
        nameList.add("hasan")


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleview.layoutManager = layoutManager
//        myAdapter = MyAdapter(nameList ,this@MainActivity)
        myAdapterWithConstructor.setAdapterList(nameList ,this)
        recycleview.adapter = myAdapterWithConstructor
    }
}