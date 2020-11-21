package com.camilamizu.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Listen to button click "Entrar"
        btnLoginSignIn.setOnClickListener {
            //Capture typed data
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val password = edtLoginPassword.text.toString().trim()

            //Field validation
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório."
                //Defines the cursor focus and directs the user
                edtLoginEmail.requestFocus()
            } else if (password.isEmpty()) {
                edtLoginPassword.error = "Campo obrigatório."
                edtLoginPassword.requestFocus()
            } else {
                // Verify email and password
                if (email == "admin@admin.com" && password == "admin") {
                    //Success message via Toast
                    Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_LONG).show()
                    //Open MainAcitvity
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    finish()
                } else {
                    Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_LONG).show()
                }
            }
        }

        //Listen to "Cadastrar" button
        btnLoginRegister.setOnClickListener {
            val mIntent = Intent(this, RegisterActivity::class.java)
            startActivity(mIntent)
        }
    }
}