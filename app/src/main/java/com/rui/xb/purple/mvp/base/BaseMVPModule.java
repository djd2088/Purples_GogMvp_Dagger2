package com.rui.xb.purple.mvp.base;



import com.rui.xb.rui_core.net.rx.IRxRestService;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * MVP Module基类
 */
public class BaseMVPModule {

    @Inject
    protected IRxRestService netClient;

    @Inject
    protected BaseMVPModule() {
    }

    protected Observable<String> requestByGet(String url, Map<String,Object> params){
        return netClient.get(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Observable<String> requestByPost(String url, Map<String,Object> params){
        return netClient.post(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Observable<String> requestByPut(String url, Map<String,Object> params){
        return netClient.put(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

//    protected Observable<String> requestByUpload(String url, Map params){
//        return netClient.upload(url,params).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io());
//    }
//

}
