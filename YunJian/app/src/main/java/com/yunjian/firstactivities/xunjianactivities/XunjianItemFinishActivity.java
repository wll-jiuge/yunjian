package com.yunjian.firstactivities.xunjianactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yunjian.BaseActivity;
import com.yunjian.R;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.finishxunjian.FinishXunjianDetailResponse;

import java.util.HashMap;

import utils.StringUtils;
import utils.XToastUtils;

/**
 *@package com.yunjian.firstactivities.xunjianactivities
 *@date on 2020/11/20
 *@author 吴立柳
 *@describe 巡检已完成---页面展示
*/
public class XunjianItemFinishActivity extends BaseActivity {
    private int finishXunjianId;
    private TextView finishname, finishdescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xunjian_item_finish);
        init();
        finishXunjianId = getIntent().getIntExtra("id", 0);
//        请求数据
        getFinishXunjianDetail(finishXunjianId);
    }

    private void init() {
        finishname = findViewById(R.id.xunjian_finish_detail_name);
        finishdescribe = findViewById(R.id.xunjian_finish_detail_describe);

    }

    private void getFinishXunjianDetail(int finishXunjianId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("taskId", finishXunjianId);
        Log.i("id", String.valueOf(finishXunjianId));
        Api.config(ApiConfig.XUNJIAN_FINISH_DETAIL, params).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                Log.i("finishdetail", res);
//                更改UI
                changeUI(res);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private void changeUI(String res) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FinishXunjianDetailResponse response = new Gson().fromJson(res, FinishXunjianDetailResponse.class);
                if (!StringUtils.isEmpty(res) && response.getCode() == 0) {
                    finishname.setText(response.getData().getTaskName());
                    finishdescribe.setText(response.getData().getTaskResultDesc());
                }
            }
        });
    }
}