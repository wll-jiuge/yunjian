package com.yunjian;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The type Base activity.
 *
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 公共基本类, 定义共有数据和方法
 */
public class BaseActivity  extends AppCompatActivity {
    /**
     * The M context.
     */
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

    /**
     * Save stringto sp.存储token
     *
     * @param key   the key
     * @param value the value
     */

    protected void saveStringtoSp(String key,String value){
        SharedPreferences sp = getSharedPreferences("sp_token",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }




}
