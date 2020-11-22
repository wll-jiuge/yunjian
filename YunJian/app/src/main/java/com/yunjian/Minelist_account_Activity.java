package com.yunjian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fragments.minelist.Minelist_myaccount;
import fragments.minelist.Minelist_mydeptment;
import fragments.minelist.Minelist_myteam;

/**
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 我的页面 --列表
 */
public class Minelist_account_Activity extends BaseActivity {
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Fragments.
     */
    List<Fragment> fragments;
    /**
     * The Intent.
     */
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_list);
        viewPager = findViewById(R.id.viewpager_minelist);
        initFragment();
        intent = getIntent();
        int position = intent.getIntExtra("position",0);
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);

    }

    /**
     * 初始化fragment
     */
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new Minelist_myaccount());
    }

    /*
    * 适配器类
    * */
    private class ViewAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        /**
         * Instantiates a new View adapter.
         *
         * @param fm        the fm
         * @param fragments the fragments
         */
        public ViewAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}