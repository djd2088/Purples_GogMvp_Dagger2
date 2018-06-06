package com.rui.xb.rui_core.net.webView.client;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class RuiWebViewClient extends WebViewClient {

    private IPageLoadListener mIPageLoadListener = null;

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        view.loadUrl(url);
        return true;

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
//        LatteLoader.showLoading(view.getContext());
    }

    //获取浏览器cookie
//    private void syncCookie() {
//        final CookieManager manager = CookieManager.getInstance();
//        /*
//          注意，这里的Cookie和API请求的Cookie是不一样的，这个在网页不可见
//         */
//        final String webHost = Latte.getConfiguration(ConfigKeys.WEB_HOST);
//        if (webHost != null) {
//            if (manager.hasCookies()) {
//                final String cookieStr = manager.getCookie(webHost);
//                if (cookieStr != null && !cookieStr.equals("")) {
//                    LattePreference.addCustomAppProfile("cookie", cookieStr);
//                }
//            }
//        }
//    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
//        syncCookie();
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
//        HANDLER.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                LatteLoader.stopLoading();
//            }
//        }, 1000);
    }

}
