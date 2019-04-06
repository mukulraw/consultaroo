package com.consultaroo.consultaroo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Advanceable;

import com.consultaroo.app.R;

import im.delight.android.webview.AdvancedWebView;

public class Hire extends AppCompatActivity implements AdvancedWebView.Listener{

    Toolbar toolbar;
    AdvancedWebView web;
    String title , url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");

        toolbar = findViewById(R.id.toolbar2);
        web = findViewById(R.id.webview);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle(title);
        web.setListener(this, this);
        web.loadUrl(url);



    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        web.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        web.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        web.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        web.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!web.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

}