package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.widget.Button;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends BaseFragment<TestPresenter> implements TestView {

    @Inject
    public ThirdFragment() {
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initDataAndView() {

    }

    @Override
    public Button getBtnImButton() {
        return null;
    }
}

