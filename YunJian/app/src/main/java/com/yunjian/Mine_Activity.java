package com.yunjian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xuexiang.xqrcode.XQRCode;
import com.xuexiang.xqrcode.util.QRCodeAnalyzeUtils;
import com.xuexiang.xutil.app.PathUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import fragments.Bottom_navigation_firstfragment;
import fragments.Bottom_navigation_lastfragment;
import fragments.Bottom_navigation_secondfragment;
import fragments.Bottom_navigation_thirdfragment;
import utils.XToastUtils;

import static com.xuexiang.xui.XUI.getContext;


public class Mine_Activity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TextView txt_toolbar;
    BottomNavigationView bottomNavigationView;  //引入底部导航栏和页面
    List<Fragment> fragments;  //fragment集合
    MenuItem menuItem;  //菜单项
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        viewPager=findViewById(R.id.viewPager);
        bottomNavigationView=findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);
        txt_toolbar = findViewById(R.id.txt_toolbar);

//导航栏
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
//                    case R.id.add:{
//                        Toast.makeText(Mine_Activity.this,"添加",Toast.LENGTH_SHORT).show();
//                        break;
//                    }
                    case R.id.erweima:{ //处理二维码
                        XQRCode.startScan(Mine_Activity.this, REQUEST_CODE);

                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });





        fragments = new ArrayList<>();  //实例化
        fragments.add(new Bottom_navigation_firstfragment());
        fragments.add(new Bottom_navigation_secondfragment());
        fragments.add(new Bottom_navigation_thirdfragment());
        fragments.add(new Bottom_navigation_lastfragment()); //加载fragment页面
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

//        通过底部导航改变页面
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //根据ID判断
                switch (item.getItemId()){
                    case R.id.menu_item1: {
                        viewPager.setCurrentItem(0);
                        txt_toolbar.setText("首页");
                        break;
                    }
                    case (R.id.menu_item2):{
                        viewPager.setCurrentItem(1);
                        txt_toolbar.setText("任务");
                        break;
                    }
                    case R.id.menu_item3:{
                        viewPager.setCurrentItem(2);
                        txt_toolbar.setText("质量诊断");
                        break;
                    }
                    case R.id.menu_item4:{
                        viewPager.setCurrentItem(3);
                        txt_toolbar.setText("我的");
                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        });

        //页面改变事件

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem==null){ //没有初始化,默认为首页
                    menuItem = bottomNavigationView.getMenu().getItem(0);
                }
//                将上次的选择设为false,等待下次的选择
                menuItem.setChecked(false);
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
/*
* 适配器类*/
    private class MyAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragments;  //接收fragments
        public MyAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

//        返回具体值
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

//        返回具体数量
        @Override
        public int getCount() {
            return fragments.size();
        }

    }


    //重写菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.head_toolbar,menu);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理二维码扫描结果
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //处理扫描结果（在界面上显示）
            handleScanResult(data);
        }

        //选择系统图片并解析
        else if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                getAnalyzeQRCodeResult(uri);
            }
        }
    }

    /**
     * 处理二维码扫描结果
     *
     * @param data
     */
    private void handleScanResult(Intent data) {
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                if (bundle.getInt(XQRCode.RESULT_TYPE) == XQRCode.RESULT_SUCCESS) {
                    String result = bundle.getString(XQRCode.RESULT_DATA);
                    XToastUtils.toast("解析结果:" + result, Toast.LENGTH_LONG);
                } else if (bundle.getInt(XQRCode.RESULT_TYPE) == XQRCode.RESULT_FAILED) {
                    XToastUtils.toast("解析二维码失败", Toast.LENGTH_LONG);
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void getAnalyzeQRCodeResult(Uri uri) {
        XQRCode.analyzeQRCode(PathUtils.getFilePathByUri(getContext(), uri), new QRCodeAnalyzeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                XToastUtils.toast("解析结果:" + result, Toast.LENGTH_LONG);
            }

            @Override
            public void onAnalyzeFailed() {
                XToastUtils.toast("解析二维码失败", Toast.LENGTH_LONG);
            }
        });
    }

}