package com.rui.xb.purple.mvp.presenter;

import android.util.Log;
import android.widget.Toast;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.TestModel;
import com.rui.xb.purple.mvp.view.TestView;
import com.rui.xb.rui_core.app.Rui;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/5/31.
 */

public class TestPresenter extends BaseMVPPresenter<TestModel,TestView>{

    private static final String TAG = "TestPresenter";

    @Inject
    public TestPresenter() {

    }


    public void requestBaiduChangeData(){
      Disposable disposable =  mModule.requestBaidu(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                Toast.makeText(Rui.getApplicationContext(),s,Toast.LENGTH_SHORT).show();

                mView.getBtnImButton().setText("改变了data");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "error: " + throwable.getMessage());
            }
        });
      addDisposable(disposable);
    }

}
