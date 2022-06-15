package com.example.hilttest.dialog_factory

import android.content.Context
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.example.hilttest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_dialog_factory.*
import javax.inject.Inject



@AndroidEntryPoint
class DialogFactoryActivity : AppCompatActivity() {

    var context: Context?=null

    @Inject
    lateinit var dialogFactory: DialogFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_factory)

        context = this

        btn_show_dialog.setOnClickListener {
            showDialog()
        }

    }


    private fun showDialog() {
        dialogFactory.createTestDialog(object : DialogFactory.DialogFactoryInteraction {
            override fun onAcceptButtonClicked(vararg strings: String?) {
                Log.i("" ,"")
            }
            override fun onDeniedButtonClicked(cancel_dialog: Boolean) {
                Log.i("" ,"")
            }
        }, root, context)
    }
}