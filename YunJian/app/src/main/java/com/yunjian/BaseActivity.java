package com.yunjian;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity  extends AppCompatActivity {
   public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

//导航
//    public void navigateTo(Class c1,Class c2){
//        Intent intent = new Intent(,c2);
//        startActivity(intent);
//    }

//    存储shared ...不知道为什么没成功
    protected void saveStringtoSp(String key,String value){
        SharedPreferences sp = getSharedPreferences("sp_token",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }




}
