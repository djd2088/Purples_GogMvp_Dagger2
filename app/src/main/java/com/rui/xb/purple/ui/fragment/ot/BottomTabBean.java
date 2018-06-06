package com.rui.xb.purple.ui.fragment.ot;

import android.graphics.drawable.Drawable;

/**
 * Created by 傅令杰
 */

public final class BottomTabBean {

    private final Drawable ICON_NORMRAL;
    private final String TITLE;
    private final Drawable ICON_CHOOSE;

    public BottomTabBean(String title,Drawable icon_normal, Drawable icon_choose) {
        this.ICON_NORMRAL = icon_normal;
        this.TITLE = title;
        this.ICON_CHOOSE = icon_choose;
    }

    public Drawable getICON_NOMAL() {
        return ICON_NORMRAL;
    }

    public String getTitle() {
        return TITLE;
    }

    public Drawable getICON_CHOOSE() {
        return ICON_CHOOSE;
    }
}
