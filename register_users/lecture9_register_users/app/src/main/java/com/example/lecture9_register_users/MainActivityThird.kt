package com.example.lecture9_register_users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_third.*

class MainActivityThird : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_third)
        init()
    }

    private fun init() {
        val user = intent.extras!!.getParcelable<User>("user")
        textViewUsername.text = user!!.username
        textViewName.text = user!!.name
        textViewLastName.text = user!!.lastname.toString()
        textViewAge.text = user!!.age.toString()
        textViewAddress.text=user!!.address.toString()
    }
}
