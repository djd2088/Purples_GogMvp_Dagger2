package com.rui.xb.rui_core.app.appconfigs;

import android.os.Handler;

import com.rui.xb.rui_core.app.Rui;
import com.rui.xb.rui_core.app.enums.EAppConfigure;
import com.rui.xb.rui_core.ui.loader.LoadStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rui on 2018/4/14.
 */

public final class AppConfigurator {

    private static final Map<String,Object> RUI_CONFIGS = new HashMap<>();
    private static final Handler HANDLER = new Handler();

    private AppConfigurator() {
        RUI_CONFIGS.put(EAppConfigure.HANDLE.name(),HANDLER);
    }

    public final void configFinish(){

        if (Rui.getConfigWithKey(EAppConfigure.DEFAULT_LOADER_STYLE.name()) == null){
            Rui.getAppConfigs().put(EAppConfigure.DEFAULT_LOADER_STYLE.name(),LoadStyle
                    .BallClipRotatePulseIndicator);//默认加载图形
        }
    }

    private static class Holder{
        private static final AppConfigurator SINGLETON  = new AppConfigurator();
    }

    public static final AppConfigurator getInstance(){
        return Holder.SINGLETON;
    }

    public final Map<String,Object> getRuiConfigs(){
        return RUI_CONFIGS;
    }

    public final AppConfigurator withDefaultLoaderStyle(LoadStyle defaultLoaderStyle){
        RUI_CONFIGS.put(EAppConfigure.DEFAULT_LOADER_STYLE.name(),defaultLoaderStyle);
        return this;
    }

}
