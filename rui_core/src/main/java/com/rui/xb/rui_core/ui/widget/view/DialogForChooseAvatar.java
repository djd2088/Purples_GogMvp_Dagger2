package com.rui.xb.rui_core.ui.widget.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.rui.xb.rui_core.R;
import com.rui.xb.rui_core.utils.PictureUtil;

/**
 * Created by Rui on 2018/5/15.
 */

public class DialogForChooseAvatar extends AlertDialog {

    private WindowManager.LayoutParams mLayoutParams;

    private Activity mActivity;

    private Fragment mFragment;

    public DialogForChooseAvatar(@NonNull Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void show() {
        super.show();
        initView(mActivity);
    }

    private void initView(final Activity activity) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = this.getWindow();
        window.setContentView(R.layout.dialog_camera_panel);
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mLayoutParams = window.getAttributes();
        mLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        mLayoutParams.alpha = 1f;
        mLayoutParams.dimAmount = 0.5f;
        window.setAttributes(mLayoutParams);


        window.findViewById(R.id.btn_native_dialog).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureUtil.openLocalImage(activity);
                cancel();
            }
        });
        window.findViewById(R.id.btn_takephoto_dialog).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureUtil.openCameraImage(activity);
                cancel();
            }
        });
        window.findViewById(R.id.btn_cancel_dialog).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

    }

}
