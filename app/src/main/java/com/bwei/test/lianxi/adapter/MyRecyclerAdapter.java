package com.bwei.test.lianxi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.test.lianxi.R;
import com.bwei.test.lianxi.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhangjie on 2016/11/10.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private Context context;
    private List<Bean.DataBean> list;
    private ImageLoader imageLoader;

    public MyRecyclerAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;

        imageLoader=ImageLoader.getInstance();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getGoods_name());
        imageLoader.displayImage(list.get(position).getGoods_img(),holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView iv;
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv=(TextView) itemView.findViewById(R.id.tv_title);
        iv=(ImageView) itemView.findViewById(R.id.iv_image);
    }
}