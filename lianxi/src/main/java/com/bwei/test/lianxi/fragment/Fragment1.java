package com.bwei.test.lianxi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwei.test.lianxi.R;
import com.bwei.test.lianxi.adapter.MyRecyclerAdapter;
import com.bwei.test.lianxi.bean.Bean;
import com.bwei.test.lianxi.okhttp.OkHttp;
import com.bwei.test.lianxi.util.RecyclerItem;
import com.bwei.test.lianxi.view.PullBaseView;
import com.bwei.test.lianxi.view.PullRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by zhangjie on 2016/11/11.
 */
public class Fragment1 extends Fragment implements PullBaseView.OnHeaderRefreshListener, PullBaseView.OnFooterRefreshListener {

    private PullRecyclerView recycler;
    private List<Bean.DataBean> list=new ArrayList<>();
    private MyRecyclerAdapter adapter;
    private String s="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,container,false);
        recycler=(PullRecyclerView) view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置下拉监听
        recycler.setOnHeaderRefreshListener(this);
        //设置上拉监听
        recycler.setOnFooterRefreshListener(this);
        //点击监听
        recycler.addOnItemTouchListener(new RecyclerItem(getActivity(),new RecyclerItem.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),list.get(position).getGoods_name(),Toast.LENGTH_SHORT).show();

            }
        }));


//        recycler.setCanScrollAtRereshing(true);//设置正在刷新时是否可以滑动，默认不可滑动
//        recycler.setCanPullDown(false);//设置是否可下拉
//        recycler.setCanPullUp(false);//设置是否可上拉


        initData();
        adapter=new MyRecyclerAdapter(getActivity(),list);
        recycler.setAdapter(adapter);

        return view;
    }
    protected void initData() {
        OkHttp.getAsync(s, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                Bean bean=gson.fromJson(result,Bean.class);
                list.addAll(bean.getData());
            }
        });

    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  mDatas.add(0, "TEXT新增");
                adapter.notifyDataSetChanged();
                recycler.onHeaderRefreshComplete();
            }
        }, 3000);
    }

    @Override
    public void onFooterRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
                recycler.onFooterRefreshComplete();
            }
        },2000);
    }
}
