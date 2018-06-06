package com.rui.xb.rui_core.net.webView.initial;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Rui on 2017/8/23.
 */

public class WebViewInitializer {

    @SuppressLint("SetJavaScriptEnabled")
    public static WebView createWebView(WebView webView){
        //允许web调试
        WebView.setWebContentsDebuggingEnabled(true);
        //不能横向滚动
        webView.setHorizontalScrollBarEnabled(false);
        //不能纵向滚动
        webView.setVerticalScrollBarEnabled(false);
        //允许截图
        webView.setDrawingCacheEnabled(true);
        //屏蔽长按事件
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

        //初始化websetting;
        WebSettings settings = webView.getSettings();
        final String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua + "Rui");
        settings.setJavaScriptEnabled(true);
        //隐藏缩放控件
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        //禁止缩放
        settings.setSupportZoom(false);
        //文件权限
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        //缓存相关
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        return webView;
    }
}
