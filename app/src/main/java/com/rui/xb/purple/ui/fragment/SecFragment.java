package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.widget.Button;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecFragment extends BaseFragment<TestPresenter> implements TestView{


    private static final String TAG = "SecFragment";

    @BindView(R.id.btn_im_test1)
    Button btnTest;

    @Inject
    public SecFragment() {
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_sec;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this);
    }

    @Override
    public Button getBtnImButton() {
        return btnTest;
    }

    @OnClick(R.id.btn_im_test1)
    void clickBtn(){
        mPresenter.requestBaiduChangeData();
    }
}
