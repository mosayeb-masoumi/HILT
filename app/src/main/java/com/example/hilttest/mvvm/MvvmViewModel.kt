package com.example.hilttest.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MvvmViewModel @Inject constructor(var repository : MvvmRepository) {

    var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    fun getUserName(): LiveData<String> {

        mutableLiveData = repository.getUserName()
        return mutableLiveData
    }


}