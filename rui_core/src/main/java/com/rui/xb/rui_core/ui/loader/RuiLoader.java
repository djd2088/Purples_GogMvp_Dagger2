package com.rui.xb.rui_core.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.rui.xb.rui_core.R;
import com.rui.xb.rui_core.utils.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;


/**
 * Created by Rui on 2018/4/14.
 */


public class RuiLoader {



    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;
    private static final String DEFAULT_LOADER = LoadStyle.BallSpinFadeLoaderIndicator.name();
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();


    public static void showLoading(Context context, Enum<LoadStyle> style) {
        showLoading(context, style.name());
    }

    public static void showLoading(Context context, String type) {

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);

        dialog.setContentView(avLoadingIndicatorView);
        int devicewidth = DimenUtil.getScreenWidth();
        int devicehight = DimenUtil.getScreenHight();

        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = devicewidth / LOADER_SIZE_SCALE;
            lp.height = devicehight / LOADER_SIZE_SCALE;
            lp.height = lp.height + devicehight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);

        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                    //dialog.dismiss();   cancel有对应回调  dismiss只是单纯消失
                }
            }
        }
    }

}
