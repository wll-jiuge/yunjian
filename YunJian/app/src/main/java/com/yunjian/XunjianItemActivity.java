package com.yunjian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.renderscript.Sampler;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yunjian.entity.XunjianItemEntity;
import com.yunjian.entity.XunjianItemResponse;

import java.util.ArrayList;
import java.util.List;

import utils.XToastUtils;

public class XunjianItemActivity extends AppCompatActivity {
TextView xunjianitem_name,xunjianitem_method,xunjianitem_standard,xunjianitem_xiang;
Intent intent;
private XunjianItemEntity xunjianItemEntity;
private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xunjian_item);
        init();
        intent = getIntent();
        xunjianItemEntity = (XunjianItemEntity) getIntent().getSerializableExtra("listentity");
        position = intent.getIntExtra("position",0);
        changetext();
    }
    private void init(){
        xunjianitem_name = findViewById(R.id.txt_xunjianitem_name);
        xunjianitem_method = findViewById(R.id.txt_xunjianitem_fangfa);
        xunjianitem_standard = findViewById(R.id.txt_xunjianitem_standard);
        xunjianitem_xiang = findViewById(R.id.txt_xunjianitem_xiang);
    }
    private void changetext(){
        xunjianitem_name.setText(xunjianItemEntity.getName());
        xunjianitem_method.setText(xunjianItemEntity.getMethod());
        xunjianitem_standard.setText(xunjianItemEntity.getStandard());
        xunjianitem_xiang.setText(xunjianItemEntity.getItems());
    }
}