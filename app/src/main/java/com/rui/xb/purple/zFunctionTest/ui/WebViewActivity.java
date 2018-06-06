package com.rui.xb.purple.zFunctionTest.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.google.gson.Gson;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.webView.WebViewBaseActivity;
import com.rui.xb.rui_core.net.webView.chromClient.WebViewChromClientImpl;
import com.rui.xb.rui_core.net.webView.initial.WebViewInitializer;


import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

public class WebViewActivity extends WebViewBaseActivity {


    @BindView(R.id.tv_web_title)
    public AppCompatTextView tvWebTitle;
    @BindView(R.id.ll_title)
    LinearLayoutCompat llTitle;
    @BindView(R.id.web_container)
    ContentFrameLayout webContainer;
    private BridgeWebView mWebView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        StatusBarCompat.translucentStatusBar(this, true);

        mWebView = (BridgeWebView) getWebview();
        webContainer.addView(mWebView);

        //mWebView.loadUrl("http://10.1.64.184:8899/dist/first.html");
        mWebView.loadUrl("file:///android_asset/first.html");
        initData();
    }

    private void initData() {

        //注册submitFromWeb方法
        mWebView.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Toast.makeText(WebViewActivity.this,"web调用原生:参数=" + data,Toast.LENGTH_SHORT).show();
                function.onCallBack("{data2Web}");
            }
        });
    }

    @OnClick(R.id.btn_callWeb)
    void onClickGoback(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","123");
        mWebView.callHandler("functionInJs", new Gson().toJson(map), new CallBackFunction() {

            @Override
            public void onCallBack(String data) {
                // TODO Auto-generated method stub
                Toast.makeText(WebViewActivity.this,"原生调用web的返回值" + data,Toast.LENGTH_SHORT)
                        .show();
            }

        });
    }

    @OnClick(R.id.tv_go_back)
    void onGoback(){
        finish();
    }

    @Override
    public WebView initWebView(WebView webView) {
        return  WebViewInitializer.createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient(WebView webView) {
        return new BridgeWebViewClient((BridgeWebView) webView);
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebViewChromClientImpl();
    }
}

