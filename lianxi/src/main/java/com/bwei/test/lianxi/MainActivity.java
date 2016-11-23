package com.bwei.test.lianxi;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.test.lianxi.adapter.MyFragmentPagerAdapter;
import com.bwei.test.lianxi.fragment.Fragment1;


public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private Fragment1 fragment1;
    private MyFragmentPagerAdapter adapter;
    private RadioButton rb3;
    private RadioButton rb2;
    private RadioButton rb1;
    private RadioButton rb4;
    private RadioButton rb5;
    private FragmentManager manager = getSupportFragmentManager();
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=(RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        vp = (ViewPager) findViewById(R.id.vp);

        vp.setOffscreenPageLimit(5);

        fragment1 = new Fragment1();

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        rg.check(R.id.rb1);
                        break;
                    case 1:
                        rg.check(R.id.rb2);
                        break;
                    case 2:
                        rg.check(R.id.rb3);
                        break;
                    case 3:
                        rg.check(R.id.rb4);
                        break;
                    case 4:
                        rg.check(R.id.rb5);
                        break;


                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
    }



}
