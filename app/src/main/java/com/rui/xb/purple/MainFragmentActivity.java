package com.rui.xb.purple;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.rui.xb.purple.ui.fragment.FirstFragment;
import com.rui.xb.purple.ui.fragment.SecFragment;
import com.rui.xb.purple.ui.fragment.ThirdFragment;
import com.rui.xb.purple.ui.fragment.ThurFragment;
import com.rui.xb.purple.ui.fragment.ot.BottomTabBean;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainFragmentActivity extends DaggerAppCompatActivity implements View.OnClickListener{

    @Inject
    FirstFragment firstFragment;

    @Inject
    SecFragment secFragment;

    @Inject
    ThirdFragment thirdFragment;

    @Inject
    ThurFragment thurFragment;

    @BindView(R.id.bottom_bar)
    LinearLayoutCompat mBottomBar;

    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();
    private final ArrayList<Fragment> FRAGMENTS = new ArrayList<>();
    private static int mCurrentFragment = 0;
    private final int mClickedColor = Color.RED;
    private final int mNormalColor = Color.GRAY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();

    }

    /** 根据需要修改*/
    private void initData() {
        // 初始化底部信息
        TAB_BEANS.add(new BottomTabBean("首页1",getDrawableByMip(R.mipmap.tab_home),
                getDrawableByMip(R.mipmap.tab_home_hover)));
        TAB_BEANS.add(new BottomTabBean("首页2",getDrawableByMip(R.mipmap.tab_class),
                getDrawableByMip(R.mipmap.tab_class_hover)));
        TAB_BEANS.add(new BottomTabBean("首页3",getDrawableByMip(R.mipmap.tab_patients),
                getDrawableByMip(R.mipmap.tab_patients_hover)));
        TAB_BEANS.add(new BottomTabBean("首页4",getDrawableByMip(R.mipmap.tab_doctor),
                getDrawableByMip(R.mipmap.tab_doctor_hover)));

        //初始化fragment
        FRAGMENTS.add(firstFragment);
        FRAGMENTS.add(secFragment);
        FRAGMENTS.add(thirdFragment);
        FRAGMENTS.add(thurFragment);
    }


    /** 无需修改 */
    private void initView() {
        final int size = TAB_BEANS.size();
        for (int i = 0; i < size; i++) {
            LayoutInflater.from(this).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            final LinearLayout item = (LinearLayout) mBottomBar.getChildAt(i);
            //设置每个item的点击事件
            item.setTag(i);
            item.setOnClickListener(this);
            final AppCompatImageView itemIcon = (AppCompatImageView) item.getChildAt(0);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            final BottomTabBean bean = TAB_BEANS.get(i);
            //初始化数据
            itemIcon.setImageDrawable(bean.getICON_NOMAL());
            itemTitle.setText(bean.getTitle());
        }
        replaceFragment(mCurrentFragment);
    }


    /** 无需修改 */
    private Drawable getDrawableByMip(int rid) {
        return getResources().getDrawable(rid);
    }

    /** 无需修改 */
    private void replaceFragment(int tabIndex) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.bottom_bar_fragment_container, FRAGMENTS.get(tabIndex));
        fragmentTransaction.commit();
        changeColor(tabIndex);
    }

    /** 无需修改 */
    @Override
    public void onClick(View view) {
        int tag = (int) view.getTag();
        replaceFragment(tag);
        mCurrentFragment = tag;
    }

    /** 无需修改 */
    private void resetColor() {
        final int count = mBottomBar.getChildCount();
        for (int i = 0; i < count; i++) {
            final LinearLayout item = (LinearLayout) mBottomBar.getChildAt(i);
            final AppCompatImageView itemIcon = (AppCompatImageView) item.getChildAt(0);
            itemIcon.setImageDrawable(TAB_BEANS.get(i).getICON_NOMAL());
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemTitle.setTextColor(mNormalColor);
        }
    }
    /** 无需修改 */
    public void changeColor(int tabIndex) {
        resetColor();
        final LinearLayout item = (LinearLayout) mBottomBar.getChildAt(tabIndex);
        final AppCompatImageView itemIcon = (AppCompatImageView) item.getChildAt(0);
        itemIcon.setImageDrawable(TAB_BEANS.get(tabIndex).getICON_CHOOSE());
        final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemTitle.setTextColor(mClickedColor);
    }
}

