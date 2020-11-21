package com.camilamizu.appestacaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get the email that was passed in Register Activity intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Access the Shared Preferences file
        val sharedPreferences = getSharedPreferences("register_$email", Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("NAME", "Chave não encontrada")
        val lastName = sharedPreferences.getString("LAST_NAME", "Chave não encontrada")
        val gender = sharedPreferences.getString("GENDER", "Chave não encontrada")

        //Replace text view content by recovered Shared Preferences info
        txvMainFullName.text = "$name $lastName"
        txvMainEmail.text =  email
        txvMainGender.text = gender
    }
}