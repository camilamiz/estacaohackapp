package com.camilamizu.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Creating list of options for spinner; arrayListOf is immutable so it has to be a val
        val genderOptions = arrayListOf("Selecione seu gênero", "Feminino", "Masculino", "Outro")

        //Creating an adapter (layout) for spinner
        val genderAdapter = ArrayAdapter(
            this,                                 //Context
            android.R.layout.simple_spinner_dropdown_item, //Layout
            genderOptions                                  //List content
        )

        //Plugging the adapter to spnRegisterGender
        spnRegisterGender.adapter = genderAdapter

        btnRegisterRegister.setOnClickListener {
            val name = edtRegisterName.text.toString().trim()
            val lastName = edtRegisterLastName.text.toString().trim()
            val email = edtRegisterEmail.text.toString().trim().toLowerCase()
            val password = edtRegisterPassword.text.toString().trim()
            val gender = spnRegisterGender.selectedItem.toString()

            //Field validation
            if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || gender == genderOptions[0]) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                //Creating or accessing the Shared Preferences file
                // Mode private means that other apps will not have access to that information, but it doesn't mean it's safe
                val sharedPreferences = getSharedPreferences("register_$email", Context.MODE_PRIVATE)

                //Edit the Shared Preferences file
                val editPreferences = sharedPreferences.edit()

                //Preparing the information that will be saved
                editPreferences.putString("NAME", name)
                editPreferences.putString("LAST_NAME", lastName)
                editPreferences.putString("EMAIL", email)
                editPreferences.putString("PASSWORD", password)
                editPreferences.putString("GENDER", gender)

                //Save information in Shared Preferences
                editPreferences.apply()
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                //Opening mainActivity
                val mIntent = Intent(this, MainActivity::class.java)

                //Accessing the Shared Preferences file and sending the information to the next activity through intent
                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)

                //Finish all previous activities that were piled up
                finishAffinity()
            }
        }
    }
}