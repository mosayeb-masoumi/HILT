package com.example.hilttest.mvvm

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MvvmRepository @Inject constructor(){

    private var mutableLiveData: MutableLiveData<String> = MutableLiveData<String>()
//    private var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    fun getBundles(): MutableLiveData<String> {
        mutableLiveData.setValue("hassan")
        return mutableLiveData
    }
}