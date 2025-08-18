package com.webwrap.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Hardcode the layout resource ID (activity_main = 0x7f0d0000 + layout index)
        setContentView(0x7f0d0000)
        
        // Hardcode the webview resource ID (webview = 0x7f0a0000 + id index) 
        val webView: WebView = findViewById(0x7f0a0000)
        val webSettings: WebSettings = webView.settings

        // Enable JavaScript
        webSettings.javaScriptEnabled = true

        // Enable DOM storage  
        webSettings.domStorageEnabled = true

        // Enable caching
        webSettings.cacheMode = WebSettings.LOAD_DEFAULT

        // Enable mixed content for HTTPS
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        // Set WebView client
        webView.webViewClient = WebViewClient()

        // Load the web app URL
        webView.loadUrl("{{WEB_APP_URL}}")
    }

    override fun onBackPressed() {
        val webView: WebView = findViewById(0x7f0a0000)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
