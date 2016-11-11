package com.bwei.test.lianxi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.test.lianxi.R;
import com.bwei.test.lianxi.adapter.MyRecyclerAdapter;
import com.bwei.test.lianxi.bean.Bean;
import com.bwei.test.lianxi.okhttp.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by zhangjie on 2016/11/11.
 */
public class Fragment1 extends Fragment {

    private RecyclerView recycler;
    private List<Bean.DataBean> list=new ArrayList<>();
    private MyRecyclerAdapter adapter;
    private String s="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment1,null);
        recycler=(RecyclerView) view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
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
}
