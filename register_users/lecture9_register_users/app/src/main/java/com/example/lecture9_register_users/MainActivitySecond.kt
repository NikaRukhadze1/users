package com.example.lecture9_register_users

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main_second.*

class MainActivitySecond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)
        init()
    }

    private fun init()
    {
        goToThird.setOnClickListener{
            setChoosedAdress()
            }
    }



    private fun setChoosedAdress(){
        val intent = intent.putExtra("Address", editTextSetAddress.text.toString())
        d("Text Address", intent.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
