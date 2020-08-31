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

import fragments.ResourceFragment1;
import fragments.ResourceFragment2;
import fragments.ResourceFragment3;

public class First_Resource extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    TextView textView;
    String[] title = {"图片", "文档", "视频"};
    int[] resource_normal = new int[]{R.mipmap.ic_resource_image_normal,
            R.mipmap.ic_resource_file_normal,R.mipmap.ic_resource_video_normal};
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__resource);
        init();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigation_back_white);
        initFragments();
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_resource_image_selected);  //默认选择
        for(int i=1;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(resource_normal[i]);
        }
        HandleTab();

    }

    private void init(){
        toolbar=findViewById(R.id.toolbar_resource);
        viewPager=findViewById(R.id.viewpager_resource);
        tabLayout=findViewById(R.id.tablayout_resource);
        textView=findViewById(R.id.txt_toolbar_resource);
        textView.setText("资源库");
    }

    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new ResourceFragment1());
        fragments.add(new ResourceFragment2());
        fragments.add(new ResourceFragment3());
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
    //    tab选择事件处理
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

    //    tab选中
    private void updateTab(TabLayout.Tab tab){
        String title ="";
        title=tab.getText().toString();
        if(title.equals("图片")){
            tab.setIcon(R.mipmap.ic_resource_image_selected);
        }else if(title.equals("文档")){
            tab.setIcon(R.mipmap.ic_resource_file_selected);
        }
        else{
            tab.setIcon(R.mipmap.ic_resource_video_selected);
        }
    }
    //  tab未选中
    private  void updateTabNormal(TabLayout.Tab tab){
        String title ="";
        title=tab.getText().toString();
        if(title.equals("图片")){
            tab.setIcon(R.mipmap.ic_resource_image_normal);
        }else if(title.equals("文档")){
            tab.setIcon(R.mipmap.ic_resource_file_normal);
        }
        else{
            tab.setIcon(R.mipmap.ic_resource_video_normal);
        }
    }

}