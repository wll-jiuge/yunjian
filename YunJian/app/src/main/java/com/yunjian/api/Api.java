package com.yunjian.api;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utils.StringUtils;

/**
 * @author 吴立柳
 * @package com.yunjian.api
 * @date on 2020/9/26
 * @describe  网络请求逻辑
 */
public class Api {

    //请求路径
    private static String requestUrl;
    //okhttp对象
    private static OkHttpClient client;
    //请求参数
    private static HashMap<String,Object> mParams;
    public static Api api = new Api();
    public Api(){

    }
    /**
     * 创建单例实例
     * @param url
     * @param params
     * @return api
     */
    public static Api config(String url,HashMap<String,Object> params){
        client = new OkHttpClient.Builder().build();
        requestUrl = ApiConfig.BASE_URL + url;
        mParams = params;
        return api;
    }

    public static Api configs(String url){
        client = new OkHttpClient.Builder().build();
        requestUrl = ApiConfig.BASE_URL + url;
        HashMap<String,Object> map=new HashMap();
        map.put("","");
        mParams = map;
        return api;
    }

    /**
     * post请求
     */
    public void postRequest(final YJcallback callback){
        JSONObject jsonObject = new JSONObject(mParams);
        String jsonString = jsonObject.toString();
//        请求头//根据项目修改
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonString);
//        根据实际项目修改
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("contentType","application/json;charset=utf-8")
                .post(requestBody)
                .build();
//        call回调
        final Call call = client.newCall(request);
        call.enqueue(new Callback() {
            //            请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("ttil",e.getMessage());
                callback.onFailure(e);
            }
            //            请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                得到子线程
                String result = response.body().string();
                Log.i("ttit",result);
                callback.onSuccess(result);
            }
        });
    }

    /**
     *
     * @param callback
     */
    public void getRequest(final YJcallback callback){
        String url = getAppendUrl(requestUrl,mParams);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
//        构建call对象
        Call call = client.newCall(request);
//        异步get请求
        call.enqueue(new Callback() {
            //            请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("ttil",e.getMessage());
                callback.onFailure(e);
            }
            //            请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                得到子线程
                String result = response.body().string();
                Log.i("ttit",result);
                callback.onSuccess(result);
            }
        });
    }

    /**
     * 拼接get请求参数
     * @param url
     * @param map
     * @return 请求字符串
     */
    private String getAppendUrl(String url, HashMap<String, Object> map) {
        if(map != null && !map.isEmpty()){
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Entry<String,Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Entry<String,Object> entry = iterator.next();
                if(StringUtils.isEmpty(stringBuffer.toString())){
                    stringBuffer.append("?");
                }
                else{
                    stringBuffer.append("&");
                }
//                拼接参数
                stringBuffer.append(entry.getKey()).append("=").append(entry.getValue());
            }
            url += stringBuffer.toString();
        }
        return url;
    }
}
