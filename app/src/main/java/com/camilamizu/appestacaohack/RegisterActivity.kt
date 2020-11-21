package com.camilamizu.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Creating list of options for spinner; arrayListOf is immutable so it has to be a val
        val genderOptions = arrayListOf("Feminino", "Masculino", "Outro")

        //Creating an adapter (layout) for spinner
        val genderAdapter = ArrayAdapter(
            this,                                 //Context
            android.R.layout.simple_spinner_dropdown_item, //Layout
            genderOptions                                  //List content
        )

        //Plugging the adapter to spnRegisterGender
        spnRegisterGender.adapter = genderAdapter
    }
}