package http;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/**
 *@package http
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 网络请求
*/
public class Okhttp{
//    请求url,根据项目修改
    private String url = "https://www.baidu.com/home/other/data/weatherInfo?city=%E6%B5%B7%E5%8F%A3&indextype=manht&_req_seqid=0xacf3d06f0000d71f&asyn=1&t=1598359444031&sid=32658_1467_32141_31660_32045_32117_31708_26350_32505";

//    get请求
    private void get(){
//        获取okhttp对象
        OkHttpClient client = new OkHttpClient.Builder().build();
//        构建request对象
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
            }
//            请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                得到子线程
                String result = response.body().toString();
                Log.i("ttit",result);
            }
        });
    }

    private void psot(){
//        构建okhttp对象
//        表单提交数据
        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody body = new FormBody.Builder()
                .add("username","userData")
                .add("password","pwdData")
                .build();
//        Json提交 因为是示例是本地url,所以转换成json字符串提交,实际项目看需求是表单提交还是json提交
        Map map = new HashMap();
        map.put("username","userData");
        map.put("password","pwdData");
        JSONObject jsonObject = new JSONObject(map);
        String jsonString = jsonObject.toString();
//        请求头//根据项目修改
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonString);
//        根据实际项目修改
        Request request = new Request.Builder()
                .url("http/.....")
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
            }
            //            请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                得到子线程
                String result = response.body().toString();
                Log.i("ttit",result);
            }
        });
    }
}
