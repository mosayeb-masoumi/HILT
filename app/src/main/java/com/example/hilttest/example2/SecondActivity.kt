package com.example.hilttest.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilttest.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var myClass: MyClass

    @Inject
    lateinit var myClass2: MyClass2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val time = myClass.getInterfaceTime()
        var gg= time

        val time2 = myClass2.getInterfaceTime()
        var dd = time2
    }
}