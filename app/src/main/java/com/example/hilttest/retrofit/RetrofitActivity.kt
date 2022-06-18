package com.example.hilttest.retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hilttest.R
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_mvvmactivity.*
import kotlinx.android.synthetic.main.activity_retrofit.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class RetrofitActivity : AppCompatActivity() {

    var context: Context? = null

    @Inject
    lateinit var retrofitClient: RetrofitClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)



        btn_get_list.setOnClickListener {

            getListFromServer()
        }

        context  = this@RetrofitActivity
    }

    private fun get401ErrorServer() {
        val request = RetrofitClient().buildService(APIServices::class.java , context)
        val  call = request.get401List(0)

        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful) {

                    Log.i("TAG", "onResponse: ")

                } else {
                    Log.i("TAG", "onResponse: ")
                }

            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Log.i("TAG", "onResponse: ")
            }
        })
    }


    private fun getListFromServer() {

//        val request = RetrofitClient().buildService(APIServices::class.java , context)
        val request = retrofitClient.buildService(APIServices::class.java , context)
        val  call = request.getUserList()

        call?.enqueue(object : Callback<JsonArray?> {
            override fun onResponse(call: Call<JsonArray?>, response: Response<JsonArray?>) {
                if (response.isSuccessful) {

                    Log.i("TAG", "onResponse: ")

                } else {
                    Log.i("TAG", "onResponse: ")
                }

            }

            override fun onFailure(call: Call<JsonArray?>, t: Throwable) {
                Log.i("TAG", "onResponse: ")
            }
        })


    }
}

