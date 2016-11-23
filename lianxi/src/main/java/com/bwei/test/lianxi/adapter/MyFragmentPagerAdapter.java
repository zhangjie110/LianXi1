package com.bwei.test.lianxi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwei.test.lianxi.fragment.Fragment1;

/**
 * Created by zhangjie on 2016/11/11.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f=null;
        switch (position){
            case 0:
                f=new Fragment1();
                break;
            default:
                f= new Fragment1();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
