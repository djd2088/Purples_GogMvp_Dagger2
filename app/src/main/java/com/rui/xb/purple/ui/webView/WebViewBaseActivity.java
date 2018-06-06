package com.rui.xb.purple.ui.webView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.rui.xb.rui_core.net.webView.initial.IWebViewInitializer;


public abstract class WebViewBaseActivity extends AppCompatActivity implements IWebViewInitializer {


    private BridgeWebView mWebView = null;
    private boolean mWebViewIsAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        } else {
            mWebView = new BridgeWebView(this);
            mWebView = (BridgeWebView) this.initWebView(mWebView);
            mWebView.setWebViewClient(this.initWebViewClient(mWebView));
            mWebView.setWebChromeClient(this.initWebChromeClient());
            mWebViewIsAvailable = true;
        }

    }

    public WebView getWebview() {
        if (mWebView == null) {
            throw new NullPointerException("WebView Is Null");
        }
        return mWebViewIsAvailable ? mWebView : null;
    }


    @Override
    public void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mWebView != null) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
        }
        finish();
        return true;
    }


}
