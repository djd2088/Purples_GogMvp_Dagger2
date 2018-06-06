package com.rui.xb.rui_core.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rui.xb.rui_core.app.enums.ECommon;

/**
 * Created by Rui on 2018/4/11.
 */

public class UiUtil {

    public static void startIntent(Context context, Class target) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }

    public static void startIntent(Context context, Class target, Bundle bundle){
        Intent intent = new Intent(context, target);
        intent.putExtra(ECommon.BUNDLE.name(),bundle);
        context.startActivity(intent);
    }

}
