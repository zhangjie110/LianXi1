package com.bwei.test.lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwei.test.lianxi.adapter.MyRecyclerAdapter;
import com.bwei.test.lianxi.bean.Bean;
import com.bwei.test.lianxi.okhttp.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecycler;
    private MyRecyclerAdapter adapter;
    private List<Bean.DataBean> list = new ArrayList<>();
    private String s="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mrecycler = (RecyclerView) findViewById(R.id.recycler);
        //设置布局管理器
        //listview
        mrecycler.setLayoutManager(new LinearLayoutManager(this));
        //gridview
        // mrecycler.setLayoutManager(new GridLayoutManager(this,4));
        //瀑布流
        // mrecycler.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        adapter = new MyRecyclerAdapter(this, list);
        mrecycler.setAdapter(adapter);

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
