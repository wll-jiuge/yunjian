package com.yunjian;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.List;

import fragments.LoginfomationFragment1;
import fragments.LoginfomationFragment2;
import fragments.LoginfomationFragment3;

/**
 * The type First log infomation.
 *
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 首页 --日志信息页面
 */
<<<<<<< HEAD
public class First_LogInfomationActivity extends BaseActivity {
=======
public class First_LogInfomationActivity extends AppCompatActivity {
>>>>>>> 64bad1da5154bbd5a4485ac98446534ed230edbb
    /**
     * The Toolbar.
     */
    Toolbar toolbar;
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Tab layout.
     */
    TabLayout tabLayout;
    /**
     * The Text view.
     */
    TextView textView;
    /**
     * The Title.
     */
    String[] title = {"日志列表", "添加日志", "更多"};
    /**
     * The Loginformation normal.
     */
    int[] loginformation_normal = new int[]{R.mipmap.ic_loginfomation_log_normal,
            R.mipmap.ic_loginfomation_addlog_normal,R.mipmap.ic_loginfomation_more_normal};
    /**
     * The Fragments.
     */
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__loginfomation);
        init();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigation_back_white);
        initFragments();
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_loginfomation_log_selected);  //默认选择
        for(int i=1;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(loginformation_normal[i]);
        }
        HandleTab();

    }

    private void init(){
        toolbar=findViewById(R.id.toolbar_loginfomation);
        viewPager=findViewById(R.id.viewpager_loginfomation);
        tabLayout=findViewById(R.id.tablayout_loginfomation);
        textView=findViewById(R.id.txt_toolbar_loginfomation);
        textView.setText("日志信息");
    }

    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new LoginfomationFragment1());
        fragments.add(new LoginfomationFragment2());
        fragments.add(new LoginfomationFragment3());
    }

<<<<<<< HEAD
    /**
     * 适配器类
     */
=======
    //适配器类
>>>>>>> 64bad1da5154bbd5a4485ac98446534ed230edbb
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

        //进行关联
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    /**
     * tab事件处理
     */
    private void HandleTab(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTab(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabNormal(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * tab选中
     * @param tab
     */
    private void updateTab(TabLayout.Tab tab){
        String title ="";
        title=tab.getText().toString();
        if(title.equals("日志列表")){
            tab.setIcon(R.mipmap.ic_loginfomation_log_selected);
        }else if(title.equals("添加日志")){
            tab.setIcon(R.mipmap.ic_loginfomation_addlog_selected);
        }
        else{
            tab.setIcon(R.mipmap.ic_loginfomation_more_selected);
        }
    }

    /**
     * tab未选中
     * @param tab
     */
    private  void updateTabNormal(TabLayout.Tab tab){
        String title ="";
        title=tab.getText().toString();
        if(title.equals("日志列表")){
            tab.setIcon(R.mipmap.ic_loginfomation_log_normal);
        }else if(title.equals("添加日志")){
            tab.setIcon(R.mipmap.ic_loginfomation_addlog_normal);
        }
        else{
            tab.setIcon(R.mipmap.ic_loginfomation_more_normal);
        }
    }

}