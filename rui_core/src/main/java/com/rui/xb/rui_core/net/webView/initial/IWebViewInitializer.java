package com.rui.xb.rui_core.net.webView.initial;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Rui on 2018/4/14.
 */

public interface IWebViewInitializer {

    WebView initWebView(WebView webView);

    WebViewClient initWebViewClient(WebView webView);

    WebChromeClient initWebChromeClient();
}
