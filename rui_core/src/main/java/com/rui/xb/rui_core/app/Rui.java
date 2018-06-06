package com.rui.xb.rui_core.app;

import android.content.Context;
import android.os.Handler;

import com.rui.xb.rui_core.app.appconfigs.AppConfigurator;
import com.rui.xb.rui_core.app.enums.EAppConfigure;

import java.util.Map;

/**
 * Created by Rui on 2018/4/11.
 */

public final class Rui {

    public static AppConfigurator getAppConfigurator(Context AppContext){
        getAppConfigs().put(EAppConfigure.APPLICATION_CONTEXT.name(),AppContext);
        return AppConfigurator.getInstance();
    }

    public static Map<String,Object> getAppConfigs(){
        return AppConfigurator.getInstance().getRuiConfigs();
    }


    public static <T> T getConfigWithKey(String key){
        Object value = getAppConfigs().get(key);
        return (T) value;

    }

    public static Context getApplicationContext(){
        return getConfigWithKey(EAppConfigure.APPLICATION_CONTEXT.name());
    }

    public static Handler getHandler(){
        return getConfigWithKey(EAppConfigure.HANDLE.name());
    }

}
