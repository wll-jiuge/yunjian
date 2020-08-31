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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yunjian.R;

import java.util.List;

import fragments.NotificationFragment;

public class First_Notification extends AppCompatActivity {
Toolbar toolbar;
EditText editText;
Button button;
ViewPager viewPager;
TextView textView;
Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__notification);
        init();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigation_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager(),fragment));
    }

    private void init(){
        toolbar=findViewById(R.id.toolbar_notification);
        editText=findViewById(R.id.edt_notification);
        button=findViewById(R.id.button_notification);
        viewPager=findViewById(R.id.viewpager_notification);
        textView=findViewById(R.id.txt_toolbar_notification);
        textView.setText("整改通知");
        fragment=new NotificationFragment();
    }

    //适配器类
    private class ViewAdapter extends FragmentPagerAdapter{
        private Fragment fragment;

        public ViewAdapter(@NonNull FragmentManager fm, Fragment fragment) {
            super(fm);
            this.fragment=fragment;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}