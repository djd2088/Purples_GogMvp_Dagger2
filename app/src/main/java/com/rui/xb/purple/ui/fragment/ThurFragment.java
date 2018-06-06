package com.rui.xb.purple.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThurFragment extends BaseFragment<TestPresenter> implements TestView {


    @Inject
    public ThurFragment() {
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_thur;
    }

    @Override
    protected void initDataAndView() {

    }

    @Override
    public Button getBtnImButton() {
        return null;
    }
}
