package com.rui.xb.rui_core.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.rui.xb.rui_core.app.Rui;


/**
 * Created by Rui on 2018/4/11.
 */

public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = Rui.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHight(){
        final Resources resources = Rui.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
