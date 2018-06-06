package com.rui.xb.purple.zFunctionTest.adapterAndModel;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;

import java.util.List;

/**
 * Created by Rui on 2018/5/11.
 */

public class TestAdapter extends BaseQuickAdapter<TestModel,BaseViewHolder> {


    public TestAdapter(int layoutResId, @Nullable List<TestModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, TestModel item) {

        helper.setText(R.id.Textviewname,item.getName());
        helper.addOnClickListener(R.id.btn_test);
//           helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));


    }

}
