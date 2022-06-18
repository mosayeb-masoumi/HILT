package com.example.hilttest.mvvm


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.hilttest.example1.SecondClass
import com.example.hilttest.retrofit.APIServices
import com.example.hilttest.retrofit.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MvvmRepository @Inject constructor(var retrofitClient: RetrofitClient){

    private var mutableLiveData: MutableLiveData<String> = MutableLiveData<String>()
    private var mutableListLiveData: MutableLiveData<JsonArray> = MutableLiveData<JsonArray>()

    fun getUserName(): MutableLiveData<String> {
        mutableLiveData.setValue("hassan")

        return mutableLiveData
    }


    fun getList(context: Context): MutableLiveData<JsonArray> {

        val request = retrofitClient.buildService(APIServices::class.java , context)
        val  call = request.getUserList()
        call?.enqueue(object : Callback<JsonArray?> {
            override fun onResponse(call: Call<JsonArray?>, response: Response<JsonArray?>) {

                if (response.isSuccessful) {
                    mutableListLiveData.setValue(response.body())
                } else {
                    Log.i("TAG", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<JsonArray?>, t: Throwable) {
                Log.i("TAG", "onResponse: ")
            }
        })

        return mutableListLiveData

    }
}