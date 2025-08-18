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
        
        // Use resources by ID instead of R class references
        val layoutId = resources.getIdentifier("activity_main", "layout", packageName)
        setContentView(layoutId)

        val webViewId = resources.getIdentifier("webview", "id", packageName)
        val webView: WebView = findViewById(webViewId)
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
        val webViewId = resources.getIdentifier("webview", "id", packageName)
        val webView: WebView = findViewById(webViewId)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
