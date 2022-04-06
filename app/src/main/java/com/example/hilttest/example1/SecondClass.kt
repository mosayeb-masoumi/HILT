package com.example.hilttest.example1

import javax.inject.Inject

class SecondClass @Inject constructor() {
    fun secondClassTime(): String {
        return "2"
    }
}