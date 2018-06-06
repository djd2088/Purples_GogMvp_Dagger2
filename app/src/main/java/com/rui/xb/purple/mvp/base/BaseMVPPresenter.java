package com.rui.xb.purple.mvp.base;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Presenter基类
 */
public class BaseMVPPresenter<M extends BaseMVPModule,V extends BaseMVPView> {


    protected V mView;

    @Inject
    protected M mModule;

    private CompositeDisposable disposables;

    public BaseMVPPresenter() {
        disposables = new CompositeDisposable();
    }


    public void onAttachView(V view) {
        mView = view;
    }

    public void onDetachView() {
        mView = null;
    }

    /**
     * RxJava生命周期
     */
    protected void addDisposable(Disposable dis) {
        if (dis != null) {
            disposables.add(dis);
        }
    }

    /**
     * 消费所有事件
     */
    public void dispose() {
        if (!disposables.isDisposed() && disposables.size() > 0) {
            disposables.dispose();
        }
    }

}
