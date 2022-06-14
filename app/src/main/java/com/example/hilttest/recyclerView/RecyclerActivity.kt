package com.example.hilttest.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilttest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recycler.*
import javax.inject.Inject

@AndroidEntryPoint
class RecyclerActivity : AppCompatActivity() {

    @Inject
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val nameList:MutableList<String> = ArrayList()
        nameList.add("ali")
        nameList.add("reza")
        nameList.add("hasan")


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleview.layoutManager = layoutManager
//        myAdapter = MyAdapter(nameList ,this@MainActivity)
        myAdapter.setAdapterList(nameList ,this)
        recycleview.adapter = myAdapter


    }
}