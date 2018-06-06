package com.rui.xb.purple.ui.launcher;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.rui.xb.purple.MainFragmentActivity;
import com.rui.xb.purple.R;
import com.rui.xb.rui_core.ui.launcher.LauncherHolderCreator;
import com.rui.xb.rui_core.utils.UiUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

public class LauncherScrollActivity extends AppCompatActivity implements ViewPager
        .OnPageChangeListener {


    private static final ArrayList<Integer> INTENTS = new ArrayList<>();

    @BindView(R.id.banner_launcher)
    ConvenientBanner mConvenientBanner;

    @BindView(R.id.btn_begin)
    Button btnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_scroll);
        ButterKnife.bind(this);
        StatusBarCompat.translucentStatusBar(this, true);
        initBanner();
    }

    private void initBanner() {
        INTENTS.add(R.mipmap.launcher_01);
        INTENTS.add(R.mipmap.launcher_02);
        INTENTS.add(R.mipmap.launcher_03);
        INTENTS.add(R.mipmap.launcher_04);
        INTENTS.add(R.mipmap.launcher_05);
        mConvenientBanner.setPages(new LauncherHolderCreator(), INTENTS)
                .setPageIndicator(new int[]{R.drawable.dot_nomal, R.drawable.dot_foucs})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setCanLoop(false);
        mConvenientBanner.setOnPageChangeListener(this);
    }


    @OnClick(R.id.btn_begin)
    void click() {

        //可进行一些初始化工作

        UiUtil.startIntent(this, MainFragmentActivity.class);
        finish();
    }


    /**
     * viewpage事件
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == INTENTS.size() - 1) {
            btnBegin.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(LauncherScrollActivity.this,
                    R.anim.anim_guide_btn_begin);
            btnBegin.startAnimation(animation);
        } else {
            btnBegin.setVisibility(View.GONE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
