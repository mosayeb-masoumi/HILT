package com.example.hilttest.example2

import javax.inject.Inject



class MyClass @Inject constructor() :MyInterface {

    override fun getInterfaceTime(): String {
       return "5"
    }
}

