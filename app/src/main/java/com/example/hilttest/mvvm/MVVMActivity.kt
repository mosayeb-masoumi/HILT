package com.example.hilttest.mvvm

import android.content.Context
import android.graphics.PostProcessor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.hilttest.R
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
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


        btn_get_list_from_server.setOnClickListener {
            viewModel.getList(this).observe(this , Observer { t->

                val type = object : TypeToken<List<PostModel>?>() {}.type
                val list = Gson().fromJson<List<PostModel>>( t , type)

                var dd = list[0].title

                Log.i("TAG", "onCreate: ")
            })
        }

    }
}