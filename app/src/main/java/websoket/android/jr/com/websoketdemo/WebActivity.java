package websoket.android.jr.com.websoketdemo;

import android.app.Service;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import websoket.android.jr.com.websoketdemo.databinding.ActivityWebBinding;


public class WebActivity extends AppCompatActivity {
    WebView webView;
    ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("https://www.9helix.com/android/main.html");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        final WebSettings web = webView.getSettings();
        // 设置此属性，可任意比例缩放
        web.setUseWideViewPort(true);
        web.setLoadWithOverviewMode(true);
        // 支持js
        web.setJavaScriptEnabled(true);
        web.setBuiltInZoomControls(true);
        // 支持缩放
        web.setSupportZoom(true);
        web.setBuiltInZoomControls(false);
        web.setDomStorageEnabled(true);
        web.setAppCacheMaxSize(Long.MAX_VALUE);
        web.setAppCachePath(getFileStreamPath("webCache").getPath());
        web.setAllowFileAccess(true);
        web.setAppCacheEnabled(true);

        doSetCacheMode(webView);
        binding.addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImage(binding.text.getText().toString());
            }
        });
        binding.addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText(binding.text.getText().toString());
            }
        });
    }


    private void addText(String text) {
        webView.loadUrl("javascript:addText('"+text+"')");
    }


    private void addImage(String imageUri) {
        webView.loadUrl("javascript:addPic('"+imageUri+"')");
    }


    private void doSetCacheMode(WebView webView) {
        final ConnectivityManager svr =
                (ConnectivityManager) getSystemService(Service.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = svr.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        } else {
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        }
    }
}
