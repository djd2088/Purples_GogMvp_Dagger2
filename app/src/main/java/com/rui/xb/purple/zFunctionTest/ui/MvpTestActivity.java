package com.rui.xb.purple.zFunctionTest.ui;

import android.widget.Button;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;
import com.rui.xb.purple.utils.UrlRoute;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class MvpTestActivity extends BaseActivity<TestPresenter> implements TestView {

    @BindView(R.id.btn_im_test)
    Button btnTest;


    @Override
    protected void initTitleBar() {
        letfClose();
        setTvTitle("我是个Title");
        setLlTitleBgColor(R.color.colorPrimary);
        showIvRightSetRes(R.mipmap.arrow_right); //一般图片文字二选一
        showTvRightSetText("提交");
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_mvp_test;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this);

    }

    @Override
    public Button getBtnImButton() {
        return btnTest;
    }

    @OnClick(R.id.btn_im_test)
    void clickBtn(){
        mPresenter.requestBaiduChangeData();
    }
}
