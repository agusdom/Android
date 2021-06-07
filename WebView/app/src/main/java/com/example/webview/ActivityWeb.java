package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    WebView Wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Wv1 = (WebView) findViewById(R.id.Wv1);

        String URL = getIntent().getStringExtra("sitioWeb");
        Wv1.setWebViewClient(new WebViewClient());
        Wv1.loadUrl("http://" + URL);
    }

    public void Cerrar(View view){
        finish();
    }
}