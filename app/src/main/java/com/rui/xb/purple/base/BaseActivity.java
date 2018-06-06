package com.rui.xb.purple.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.rui.xb.rui_core.app.AppManager;
import com.rui.xb.rui_core.ui.loader.RuiLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import qiu.niorgai.StatusBarCompat;

public abstract class BaseActivity<P extends BaseMVPPresenter> extends DaggerAppCompatActivity
        implements BaseMVPView{


    @BindView(R.id.ll_title)
    LinearLayout llTitleBar;

    @BindView(R.id.iv_left)
    ImageView ivLeft;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_right)
    ImageView ivRight;

    @BindView(R.id.tv_right)
    TextView tvRight;

    LinearLayout llContent;

    @Inject
    protected P mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_base);
        bindView(initMainView());
        ButterKnife.bind(this);
        initTitleBar();
        initDataAndView();
        StatusBarCompat.translucentStatusBar(this,true);
        // 添加到应用管理
        AppManager.getInstance().addActivity(this);
        //设置标题栏
    }


    @Override
    protected void onDestroy() {
        // 从应用管理移除
        AppManager.getInstance().removeActivity(this);
        // 界面销毁时取消订阅
        if (mPresenter != null) {
            mPresenter.dispose();
            mPresenter.onDetachView();
        }
        super.onDestroy();
    }



    /**
     * 初始化标题栏
     */
    protected abstract void initTitleBar();

    /**
     * 初始化主视图
     */
    protected abstract int initMainView();

    /**
     * 初始化数据和视图
     */
    protected abstract void initDataAndView();

    /**
     * 设置内容View
     */
    private void bindView(int resId){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llContent = findViewById(R.id.ll_content);
        inflater.inflate(resId, llContent);
    }

    /**
     * 设置titleBarColor
     */
    protected void setLlTitleBgColor(int color){
        llTitleBar.setBackgroundResource(color);
    }


    /**
     * 隐藏titleBar
     */
    protected void hideTitleBar(){
        llTitleBar.setVisibility(View.GONE);
    }

    /**
     * 设置title
     */
    protected void setTvTitle(String title){
        tvTitle.setText(title);
    }

    /**
     * 隐藏ivLeft
     */
    protected void hideIvLeft(String title){
        ivLeft.setVisibility(View.GONE);
    }

    /**
     * 设置ivLeft图片
     */
    protected void setIvLeftRes(int resId){
        ivLeft.setImageResource(resId);
    }

    /**
     * 设置ivRight图片
     */
    protected void showIvRightSetRes(int resId){
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(resId);
    }

    /**
     * 设置ivRight图片
     */
    protected void showTvRightSetText(String rt){
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(rt);
    }

    /**
     * 获取左边iv
     */
    protected ImageView getIvLeft(){
        return ivLeft;
    }
    /**
     * 获取右边iv
     */
    protected ImageView getIvRight(){
        return ivRight;
    }
    /**
     * 获取右边tv
     */
    protected TextView getTvRight(){
        return tvRight;
    }

    protected void letfClose(){
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    public void showLoading() {
        RuiLoader.showLoading(this);
    }

    @Override
    public void disLoading() {
        RuiLoader.stopLoading();
    }
}
