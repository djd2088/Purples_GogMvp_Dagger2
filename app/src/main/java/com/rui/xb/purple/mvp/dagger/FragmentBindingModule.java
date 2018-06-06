package com.rui.xb.purple.mvp.dagger;

import com.rui.xb.purple.ui.fragment.FirstFragment;
import com.rui.xb.purple.ui.fragment.SecFragment;
import com.rui.xb.purple.ui.fragment.ThirdFragment;
import com.rui.xb.purple.ui.fragment.ThurFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Rui on 2018/6/1.
 */
@Module
public abstract class FragmentBindingModule {


    @FragmentScoped
    @ContributesAndroidInjector
    abstract FirstFragment firstFragment();

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract SecFragment secFragment();

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract ThirdFragment thridFragment();


    @FragmentScoped
    @ContributesAndroidInjector()
    abstract ThurFragment thurFragment();


}
