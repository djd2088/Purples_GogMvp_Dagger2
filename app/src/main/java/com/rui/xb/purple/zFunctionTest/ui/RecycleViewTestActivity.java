package com.rui.xb.purple.zFunctionTest.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.zFunctionTest.adapterAndModel.TestAdapter;
import com.rui.xb.purple.zFunctionTest.adapterAndModel.TestModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewTestActivity extends AppCompatActivity {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mSmartRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    TestAdapter adapter;

    List<TestModel> models = new ArrayList<>();

    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_test);

        ButterKnife.bind(this);
        initRecycleView(); //初始recycleView;

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(RecycleViewTestActivity.this, "item" + position, Toast
                        .LENGTH_SHORT).show();
                ((TestModel)adapter.getItem(position)).setName("abcd");
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(RecycleViewTestActivity.this, "子Button点击" + position, Toast
                        .LENGTH_SHORT).show();
            }
        });

        mSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                num = 1;
                adapter.setNewData(moreData());
                refreshLayout.finishRefresh(1000);
                refreshLayout.setNoMoreData(false);

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (adapter.getItemCount() > 15) {
                    Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                    refreshLayout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
                } else {
                    adapter.addData(moreData());
                    refreshLayout.finishLoadMore(1000);
                }
            }
        });
    }

    private void initRecycleView() {
        mSmartRefreshLayout.autoRefresh();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new TestAdapter(R.layout.item_recycleview_test,models);
        mRecyclerView.setAdapter(adapter);
    }

    private List moreData() {
        List<TestModel> list = new ArrayList<>();
        for (int i = 0 ; i < 6;i++){
            TestModel model = new TestModel();
            model.setId(i);
            model.setName("name" + num);
            list.add(model);
            num++;
        }
        return list;
    }
}

