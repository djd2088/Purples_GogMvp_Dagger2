package com.rui.xb.rui_core.timer;

import java.util.TimerTask;

/**
 * Created by Rui on 2018/4/11.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mTimerListener = null;

    public BaseTimerTask(ITimerListener mTimerListener) {
        this.mTimerListener = mTimerListener;
    }

    @Override
    public void run() {
        if (mTimerListener != null) {
            mTimerListener.onTimer();
        }
    }
}
