package com.yunjian;
/*
*
* 巡检页面
* */


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import fragments.SecondFragment1;
import fragments.SecondFragment2;
import fragments.SecondFragment3;

public class First_Xunjian extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    TextView textView;
    String[] title = {"当前任务", "已完成任务", "超时任务"};
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__xunjian);

//        初始化
        tabLayout=findViewById(R.id.tablayout_xunjian);
        toolbar = findViewById(R.id.toolbar_xunjian);
        viewPager = findViewById(R.id.viewpager_xunjian);
        textView=findViewById(R.id.txt_toolbar_xunjian);
        textView.setText("日常巡检");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigation_back_white);
       initFragments();
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(First_Xunjian.this,"新建任务",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    //初始化fragments
    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new SecondFragment1());
        fragments.add(new SecondFragment2());
        fragments.add(new SecondFragment3());
    }

    //适配器类
    private class ViewAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;
        public ViewAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //进行关联
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_xunjian,menu);
        return true;
    }
    //使菜单显示图标
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}