package com.rui.xb.purple.mvp.model;

import com.rui.xb.purple.mvp.base.BaseMVPModule;


import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/5/31.
 */

public class TestModel extends BaseMVPModule{

    @Inject
    public TestModel() {
    }

    public Disposable requestBaidu(Consumer<String> success, Consumer<Throwable> throwable){
        return requestByGet("https://www.baidu.com/",new HashMap<String, Object>())
                .subscribe(success,throwable);
    }


}
