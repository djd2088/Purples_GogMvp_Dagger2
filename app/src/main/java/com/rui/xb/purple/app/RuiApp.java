package com.rui.xb.purple.app;

import com.rui.xb.purple.mvp.dagger.DaggerAppComponent;
import com.rui.xb.purple.mvp.dagger.MainModule;
import com.rui.xb.rui_core.app.Rui;
import com.rui.xb.rui_core.ui.loader.LoadStyle;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Rui on 2018/4/14.
 */

public class RuiApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Rui.getAppConfigurator(this)
                .withDefaultLoaderStyle(LoadStyle.BallClipRotateIndicator)
                .configFinish();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .mainModule(new MainModule(this))
                .build();
    }
}
