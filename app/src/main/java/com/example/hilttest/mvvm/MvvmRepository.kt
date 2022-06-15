package com.example.hilttest.mvvm


import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MvvmRepository @Inject constructor(){

    private var mutableLiveData: MutableLiveData<String> = MutableLiveData<String>()

    fun getUserName(): MutableLiveData<String> {
        mutableLiveData.setValue("hassan")

        return mutableLiveData
    }
}