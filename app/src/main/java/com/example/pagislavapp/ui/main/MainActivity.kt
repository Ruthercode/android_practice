package com.example.pagislavapp.ui.main

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.pagislavapp.ui.login.USERNAME
import com.example.pagislavapp.ui.login.WEB_SITE


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val newTitle = this.title.toString() + " " + intent.getStringExtra(USERNAME)
        title = newTitle

        val webViewClient: WebViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            @TargetApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return true
            }
        }

        val message = intent.getStringExtra(WEB_SITE)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = webViewClient
        webView.loadUrl("https://$message")
    }
}
