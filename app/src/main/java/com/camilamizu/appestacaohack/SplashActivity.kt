package com.camilamizu.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    // One of the present methods in Activity lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // Open MainActivity after 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start an intent - transition from Splash to Login
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            // Does not allow user to go back to splash screen
            finish()
        }, 5000)
    }
}