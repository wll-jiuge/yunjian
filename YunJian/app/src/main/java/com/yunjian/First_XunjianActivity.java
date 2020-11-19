package com.yunjian;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;

import java.util.ArrayList;
import java.util.List;

import fragments.XunjianFragment1;
import fragments.XunjianFragment2;
import fragments.XunjianFragment3;

/**
 * The type First xunjian_current_xunjianxiangshape activity.
 *
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 首页 --巡检页面
 */
public class First_XunjianActivity extends BaseActivity {
    /**
     * The Tab layout.
     */
    TabLayout tabLayout;
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Toolbar.
     */
    Toolbar toolbar;
    /**
     * The Text view.
     */
    TextView textView;
    /**
     * The Title.
     */
    String[] title = {"当前任务", "已完成任务", "超时任务"};
    /**
     * The Fragments.
     */
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__xunjian);
        //初始化
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


//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(First_XunjianActivity.this,"新建任务",Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }


    /**
     * 初始化fragment
     */
    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new XunjianFragment1());
        fragments.add(new XunjianFragment2());
        fragments.add(new XunjianFragment3());
    }

    /**
     * 适配器类
     */
    private class ViewAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        /**
         * Instantiates a new View adapter.
         *
         * @param fm   the fm
         * @param list the list
         */
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

        /**
         * 进行关联
         * @param position
         * @return
         */
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    /**
     * 浮动按钮点击事件
     * 数据请求应该在点击页面的时候就发生
     */
    public void navigate(View view){
        navigateTo(AddXunjianActivity.class);
        }


    /**
     * 重写菜单方法
     * @param menu
     * @return
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_xunjian,menu);
//        return true;
//    }
//
//    /**
//     * 使菜单显示图标
//     * @param featureId
//     * @param menu
//     * @return
//     */
//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (menu != null) {
//            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
//                try {
//                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                    method.setAccessible(true);
//                    method.invoke(menu, true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }


}