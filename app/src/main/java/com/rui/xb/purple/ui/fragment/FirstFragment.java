package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.widget.Button;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;
import com.rui.xb.purple.zFunctionTest.ui.HeadImageActivity;
import com.rui.xb.purple.zFunctionTest.ui.MvpTestActivity;
import com.rui.xb.purple.zFunctionTest.ui.NetTestActivity;
import com.rui.xb.purple.zFunctionTest.ui.RecycleViewTestActivity;
import com.rui.xb.purple.zFunctionTest.ui.WebViewActivity;
import com.rui.xb.rui_core.utils.UiUtil;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment<TestPresenter> implements TestView {

    @Inject
    public FirstFragment() {
    }

    @OnClick(R.id.btn_net_test)
    void click() {
        UiUtil.startIntent(getContext(), NetTestActivity.class);
    }

    @OnClick(R.id.btn_recycle_view_test)
    void click2(){
        UiUtil.startIntent(getContext(), RecycleViewTestActivity.class);
    }

    @OnClick(R.id.btn_web_view_test)
    void click3(){
        UiUtil.startIntent(getContext(), WebViewActivity.class);
    }

    @OnClick(R.id.btn_head_img_test)
    void click4(){
        UiUtil.startIntent(getContext(), HeadImageActivity.class);
    }

    @OnClick(R.id.btn_mvp_test)
    void click6(){
        UiUtil.startIntent(getContext(), MvpTestActivity.class);
    }


    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int initMainView() {
        return R.layout.first_fragment;
    }

    @Override
    protected void initDataAndView() {

    }

    @Override
    public Button getBtnImButton() {
        return null;
    }
}
