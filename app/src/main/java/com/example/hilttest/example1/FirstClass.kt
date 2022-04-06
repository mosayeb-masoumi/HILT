package com.example.hilttest.example1

import javax.inject.Inject

class FirstClass @Inject constructor(var secondClass: SecondClass) {

    fun firstClasstime():String {
        return  "1"
    }
}