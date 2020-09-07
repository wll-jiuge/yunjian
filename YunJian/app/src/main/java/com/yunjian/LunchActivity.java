package com.yunjian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

/**
 *@package com.yunjian
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 启动界面
*/
public class LunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 这里可以睡几秒钟，如果要放广告的话
                        try {
                            Thread.sleep(2000);
                            navigateTo(MainActivity.class);
//                            Intent intent = new Intent(LunchActivity.this, MainActivity.class);
//                            startActivity(intent);
                            LunchActivity.this.finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } ).start();
    }
}