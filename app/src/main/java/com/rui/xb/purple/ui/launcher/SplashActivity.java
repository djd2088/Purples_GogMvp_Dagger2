package com.rui.xb.purple.ui.launcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rui.xb.purple.R;
import com.rui.xb.rui_core.app.enums.ECommon;
import com.rui.xb.rui_core.preference.RuiPreference;
import com.rui.xb.rui_core.utils.UiUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (RuiPreference.getAppFlag(ECommon.HAS_LAUNCH.name())){
            UiUtil.startIntent(this,AdvertisementActivity.class);
        }else {
            UiUtil.startIntent(this,LauncherScrollActivity.class);
            RuiPreference.setAppFlag(ECommon.HAS_LAUNCH.name(),true);
        }
        finish();
    }

}
