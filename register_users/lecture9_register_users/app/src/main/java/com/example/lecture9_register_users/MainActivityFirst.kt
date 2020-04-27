package com.example.lecture9_register_users

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.textViewAdress
import kotlinx.android.synthetic.main.activity_main_second.*
import kotlinx.android.synthetic.main.activity_main_third.*

class MainActivityFirst : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    //ვიძახებ ინიტ ფუნქციას სადაც ლისენერები დავადე მეორე მეინ აქთვივითზე და მესამე აქთივითიზე გადასასვლელად
    //ასევე მაქვს ფუნქცია openActivitySecond მეორე ფეიჯზე გასასვლელად
    //userInfoHere ფუნქციაში ვქმნი იუზერის ობიექტს და ვინახავ ცვლადებში ფიზუალის ფილდებში შეყვანილ ინფორმაციას
    //მესამე მეინში კი ინიტ ფუნქციაში ვიზუალის ფილდებს ვავსებ ამ ობიექტის ცვლადებით

    private fun init()
    {
        goToSecond.setOnClickListener{openActivitySecond()}
        goToFinal.setOnClickListener{
            checkFields()
        }
    }

    private fun openActivitySecond()
    {
        val intent = Intent(this,MainActivitySecond::class.java)
        startActivityForResult(intent, requestCode)
    }

    private val requestCode = 27

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
            val address = data!!.extras!!.getString("Address", "")
            textViewAdress.text = address
        }
    }



    private fun userInfoHere() {
        val intent = Intent(this, MainActivityThird::class.java)
        val user = User(
            editTextUserName.text.toString(),
            editTextName.text.toString(),
            editTextLastName.text.toString(),
            editTextAge.text.toString().toInt(),
            textViewAdress.text.toString()
        )
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun checkFields()
    {
        if (editTextUserName.text.isEmpty())
        {
            Toast.makeText(applicationContext, "\"Please, fill Username's field\"", Toast.LENGTH_SHORT).show()
        }
        else if (editTextName.text.isEmpty())
        {
            Toast.makeText(applicationContext, "\"Please, fill Name's field\"", Toast.LENGTH_SHORT).show()
        }
        else if (editTextLastName.text.isEmpty())
        {
            Toast.makeText(applicationContext, "\"Please, fill Lastname's field\"", Toast.LENGTH_SHORT).show()
        }
        else if(editTextAge.text.isEmpty())
        {
            Toast.makeText(applicationContext, "\"Please, fill Age's field\"", Toast.LENGTH_SHORT).show()
        }
        else if (textViewAdress.text.isEmpty())
        {
            Toast.makeText(applicationContext, "\"Please, fill Address's field\"", Toast.LENGTH_SHORT).show()
        }

        else userInfoHere()
    }



}
