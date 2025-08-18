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
        
        // Create WebView programmatically to avoid R class issues
        val webView = WebView(this)
        webView.id = android.view.View.generateViewId()
        setContentView(webView)
        
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
        val webView = findViewById<WebView>(android.R.id.content)
        if (webView?.canGoBack() == true) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
