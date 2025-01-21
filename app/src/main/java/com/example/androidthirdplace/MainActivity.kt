package com.example.androidthirdplace


import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import org.json.JSONObject
import java.io.InputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        webView.webViewClient = WebViewClient() // Ensures links open inside WebView
        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed

        setContentView(webView)

        val baseUrl = getBaseUrl(this)
        webView.loadUrl(baseUrl) // Replace with your desired URL
    }

    fun getBaseUrl(context: Context): String {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.config)
        val json = inputStream.bufferedReader().use { it.readText() }
        return JSONObject(json).getString("base_url")
    }
}


