package com.example.hilttest.mvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import javax.inject.Inject

class MvvmViewModel @Inject constructor(var repository : MvvmRepository) {

    var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    var mutableListLiveData: MutableLiveData<JsonArray> = MutableLiveData()

    fun getUserName(): LiveData<String> {

        mutableLiveData = repository.getUserName()
        return mutableLiveData
    }


    fun getList(context:Context): LiveData<JsonArray> {

        mutableListLiveData = repository.getList(context)
        return mutableListLiveData
    }

}