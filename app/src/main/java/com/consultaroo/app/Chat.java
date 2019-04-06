package com.consultaroo.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Chat extends AppCompatActivity {
    public static final int notify = 1000;  //interval between two services(Here Service run every 20 Sec)
    private Handler mHandler = new Handler();   //run on another Thread to avoid crash
    private Timer mTimer = null;    //timer handling

    String countime = "";

    WebView webView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        webView = (WebView) findViewById(R.id.webView);
        progressBar.setVisibility(View.GONE);

        startWebView("http://nationproducts.in/html/consultaroo/chatbox.php");


        if (isNetworkAvailable())
        {

        }else {
            Chat.this.finish();
            Toast.makeText(this, "Please Check internet ", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void startWebView(String s)
    {
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            { progressBar.setVisibility(View.VISIBLE);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });


        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(s);

        webView.getUrl();

    }
    @Override
    protected void onPause() {
        mTimer.cancel();
        super.onPause();
        if (isNetworkAvailable())
        {

        }else {
            Chat.this.finish();
            Toast.makeText(this, "Please Check internet ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mTimer.cancel();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isNetworkAvailable())
        {

        }else {
            Chat.this.finish();
            Toast.makeText(this, "Please Check internet ", Toast.LENGTH_SHORT).show();
        }
        if (mTimer != null) {// Cancel if already existed
            // mTimer.cancel();
            Log.wtf("service", "all ready started");
        } else {
            mTimer = new Timer();   //recreate new
            //Toast.makeText(getContext(),"Refreshed",Toast.LENGTH_SHORT).show();
            mTimer.scheduleAtFixedRate(new TimeDisplay(), 0, notify);
        }
//        Intent i = new Intent(SearchActivity.this,SearchActivity.class);
//        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (isNetworkAvailable())
        {

        }else {
            Chat.this.finish();
            Toast.makeText(this, "Please Check internet ", Toast.LENGTH_SHORT).show();
        }
        if (mTimer != null) {// Cancel if already existed
            // mTimer.cancel();
            Log.wtf("service", "all ready started");


        } else {
            if (isNetworkAvailable())
            {

            }else {
                Chat.this.finish();
                Toast.makeText(this, "Please Check internet ", Toast.LENGTH_SHORT).show();
            }
            mTimer = new Timer();   //recreate new
            //Toast.makeText(getContext(),"Refreshed",Toast.LENGTH_SHORT).show();
            mTimer.scheduleAtFixedRate(new TimeDisplay(), 0, notify);
        }
    }
    class TimeDisplay extends TimerTask {
        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {
                @Override
                public void run() {


                    if (!webView.getUrl().equalsIgnoreCase("http://nationproducts.in/html/consultaroo/chatbox.php"))
                    {

                        Intent intent =new Intent(getApplicationContext(),MyProfessional.class);
                        startActivity(intent);
                        Chat.this.finish();
                    }

                }
            });
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();


    }
}
