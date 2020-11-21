package com.camilamizu.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        btnMainLogOff.setOnClickListener {
            //Creating an alert
            AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Deseja mesmo sair?")
                .setPositiveButton("Sair") { _, _ ->
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                    Toast.makeText(this, "Usuário deslogado.", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Cancelar") { _, _ ->}
                .setCancelable(false) //If the person clicks out of the alert, it will not be closed
                .create()
                .show()
        }
        //Listen to Cellep website button click
        btnMainCellep.setOnClickListener{
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}