package com.yunjian;

import android.app.Application;
import android.util.Log;


import com.xuexiang.xui.XUI;

import java.util.List;
/**
 *@package com.yunjian
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 初始化类
*/
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化UI框架
        XUI.init(this);
        //开启UI框架调试日志
        XUI.debug(true);
    }
}
