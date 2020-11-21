package com.camilamizu.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Enable js code execution
        wbvWeb.settings.javaScriptEnabled = true

        //Load a url
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack")

        //Open the url via app, not using chrome, defining the webview as a web client
        wbvWeb.webViewClient = WebViewClient()
    }
}