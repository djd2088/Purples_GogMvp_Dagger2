package com.rui.xb.rui_core.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.rui.xb.rui_core.app.Rui;

/**
 * Created by Rui on 2018/4/11.
 */
public final class RuiPreference {

    private static final SharedPreferences PREFERENCES =
            PreferenceManager.getDefaultSharedPreferences(Rui.getApplicationContext());


    private static SharedPreferences getAppPreference() {
        return PREFERENCES;
    }



    public static void addCustomAppProfile(String key, String val) {
        getAppPreference()
                .edit()
                .putString(key, val)
                .apply();
    }

    public static String getCustomAppProfile(String key) {
        return getAppPreference().getString(key, "");
    }


    public static void setAppFlag(String key, boolean flag) {
        getAppPreference()
                .edit()
                .putBoolean(key, flag)
                .apply();
    }

    public static boolean getAppFlag(String key) {
        return getAppPreference()
                .getBoolean(key, false);
    }


    public static void removeAppProfile(String key) {
        getAppPreference()
                .edit()
                .remove(key)
                .apply();
    }

    public static void clearAppPreferences() {
        getAppPreference()
                .edit()
                .clear()
                .apply();
    }





}
