package com.rui.xb.rui_core.utils;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Rui on 2018/4/16.
 */

public class SingletonUtil {


    //begin
    public static RequestOptions getRequestOptions(){
        return RequestOptionsHolder.SINGLETON;
    }

    private static class RequestOptionsHolder{
        private static final RequestOptions SINGLETON = new RequestOptions()
                .centerCrop()
                //.placeholder(R.mipmap.launcher_00) //占位
                //.error() //错误占位
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate();
    }
    //end


}
