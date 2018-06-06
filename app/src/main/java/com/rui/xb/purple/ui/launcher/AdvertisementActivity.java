package com.rui.xb.purple.ui.launcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

import com.rui.xb.purple.MainFragmentActivity;
import com.rui.xb.purple.R;
import com.rui.xb.rui_core.app.userAccount.UserManager;
import com.rui.xb.rui_core.app.userAccount.ot.IUserLoginListener;
import com.rui.xb.rui_core.timer.BaseTimerTask;
import com.rui.xb.rui_core.timer.ITimerListener;
import com.rui.xb.rui_core.utils.UiUtil;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

public class AdvertisementActivity extends AppCompatActivity implements ITimerListener {


    @BindView(R.id.tv_adver_timer)
    AppCompatTextView mTvTimer;
    private Timer mTimer = null;
    private int mCount = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);
        StatusBarCompat.translucentStatusBar(this,true);
        ButterKnife.bind(this);
        BaseTimerTask task = new BaseTimerTask(this);
        mTimer = new Timer();
        mTimer.schedule(task, 0, 1000);
    }



    @Override
    public void onTimer() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (mTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                }
                mCount--;
                if (mCount < 0) {
                    UserManager.checkUserHasLogin(new IUserLoginListener() {
                        @Override
                        public void hasLogin() {
                            //用户已经登录 操作
                            UiUtil.startIntent(AdvertisementActivity.this, MainFragmentActivity.class);
                        }

                        @Override
                        public void noLogin() {
                            //用户未登录 操作
                            UiUtil.startIntent(AdvertisementActivity.this, MainFragmentActivity.class);
                        }
                    });
                    stopTimer();
                }
            }
        });
    }

    @OnClick(R.id.tv_adver_timer)
    public void onViewClicked() {

        UserManager.checkUserHasLogin(new IUserLoginListener() {
            @Override
            public void hasLogin() {
                //用户已经登录 操作
                UiUtil.startIntent(AdvertisementActivity.this, MainFragmentActivity.class);
            }

            @Override
            public void noLogin() {
                //用户未登录 操作
                UiUtil.startIntent(AdvertisementActivity.this, MainFragmentActivity.class);

            }
        });
        stopTimer();
    }

    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        finish();
    }


}

