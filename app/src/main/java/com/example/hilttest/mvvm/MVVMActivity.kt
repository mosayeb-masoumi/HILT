package com.example.hilttest.mvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.hilttest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvvmactivity.*
import javax.inject.Inject

@AndroidEntryPoint
class MVVMActivity : AppCompatActivity() {

    var context:Context? = null

    @Inject
    lateinit var viewModel: MvvmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)

        context = this

        btn_get_data.setOnClickListener {

            viewModel.getUserName().observe(this , Observer { userName:String ->

                if(userName!=""){
                    Toast.makeText(this@MVVMActivity , userName , Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}