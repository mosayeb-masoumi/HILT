package com.example.hilttest.example1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hilttest.R
import com.example.hilttest.example2.SecondActivity
import com.example.hilttest.mvvm.MVVMActivity
import com.example.hilttest.recyclerView.RecyclerActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var firstClass: FirstClass

    @Inject
    lateinit var secondClass: SecondClass

    @Inject
    lateinit var thirdClass : ThirdClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val thirdClassTime = thirdClass.thirdClassTime()
        var aa = thirdClassTime


        var firstClassTime = firstClass.firstClasstime()
        var dd = firstClassTime
        var secondClassTime = secondClass.secondClassTime()
        var cc = secondClassTime

        var secondClassTimeFromFirstClass = firstClass.secondClass.secondClassTime()
        var hh = secondClassTimeFromFirstClass



        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity , SecondActivity::class.java ))
        }


        btn_recycler.setOnClickListener {
            startActivity(Intent(this@MainActivity , RecyclerActivity::class.java ))
        }


        btn_mvvm.setOnClickListener {
            startActivity(Intent(this@MainActivity , MVVMActivity::class.java ))
        }


    }
}