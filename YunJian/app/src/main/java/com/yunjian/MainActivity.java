package com.yunjian;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.LoginResponse;
import com.yunjian.entity.PicResponse;
import com.yunjian.entity.TokenEntity;
import com.yunjian.entity.TokenResponse;

import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import utils.StringUtils;
import utils.XToastUtils;

/**
 * The type Main activity.
 *
 * @author 吴立柳
 * @package com.yunjian
 * @date on 2020/9/6
 * @describe 登录界面
 */
public class MainActivity extends BaseActivity {

    /**
     * The Btn login.
     */
    Button btn_Login;
    /**
     * The Ed username.
     */
    EditText ed_username;
    /**
     * The Ed pwd.
     */
    EditText ed_pwd;
    /**
     * The Token.
     */
    String token;
    /**
     * The Login response.
     */
    //LoginResponse loginResponse;
    //验证码
    PicResponse picResponse;
    /**
     * The Base.
     */
    BaseActivity base;

    ImageView enter_test;

    //private Handler handler;


    Bitmap bitmap;

    /**
     * The Res.
     */
    //String res ="{\"msg\": \"succeed\",\"code\": 0,\"expire\": 608455,\"token\": \"JgiGlovgwDBGvaplieaqkvrtBGbAbga\"}";

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            token=msg.getData().getString("token");
            bitmap=msg.getData().getParcelable("bitmap");
            enter_test.setImageBitmap(bitmap);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //删除token
        //deleteStringfromSp("token");
        //deleteStringfromSp("login_token");

        token=getStringFromSp("login_token");

        //SharedPreferences sharedPreferences=getSharedPreferences("sp_token",0);
        //token=sharedPreferences.getString("login_token","string");
        //Gson gson = new Gson();
        //loginResponse= gson.fromJson(res,LoginResponse.class);
        //token = loginResponse.getToken();
        if (token!=null){
            Intent intent = new Intent(MainActivity.this, Mine_Activity.class);
            startActivity(intent);
            this.finish();
        }else{
            setContentView(R.layout.activity_main);
            enter_test=findViewById(R.id.enter_test);
            ed_pwd=findViewById(R.id.txt_password);
            ed_username = findViewById(R.id.txt_user);
            btn_Login = findViewById(R.id.btn_login);
            get_test();
            btn_Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    login();
                }
            });
        }

    }

    /**
     * 登录
     */
    private void login(){
        base=new BaseActivity();

        if(StringUtils.isEmpty(ed_username.getText().toString())){
            XToastUtils.toast("请输入帐号");
        }
        else if(StringUtils.isEmpty(ed_pwd.getText().toString())){
            XToastUtils.toast("请输入密码");
        }
        //方便测试暂时不限制帐号长度（手机号 11位）
        else if(ed_username.getText().length()!=11){
            XToastUtils.toast("帐号长度错误");
        }
        //表示请求成功
        else if(!StringUtils.isEmpty(ed_username.getText().toString())&!StringUtils.isEmpty(ed_pwd.getText().toString())){
            EditText editText1=findViewById(R.id.txt_user);
            EditText editText2=findViewById(R.id.txt_password);
            EditText editText3=findViewById(R.id.txt_test);
            String userMobile=editText1.getText().toString();
            String password=editText2.getText().toString();
            String code=editText3.getText().toString();
            HashMap<String,Object> params=new HashMap<String,Object>();
            params.put("userMobile",userMobile);
            params.put("password",password);
            params.put("code",code);
            params.put("token",token);
            Api.config(ApiConfig.LOGIN,params).postRequest(new YJcallback() {
                @Override
                public void onSuccess(String res) {
                    TokenResponse tokenResponse=new Gson().fromJson(res, TokenResponse.class);
                    token=tokenResponse.getData().getToken();
                    //Log.i("login_token",token);
                    saveStringtoSp("login_token",token);
                }
                @Override
                public void onFailure(Exception e) {

                }
            });
//                   将token保存到SharedPreferences文件中
            //saveStringtoSp("token",token);
           navigateTo(Mine_Activity.class);
        }else
        {
            XToastUtils.toast("登录失败");
        }
    }

    private void get_test(){
        Api.configNoParams(ApiConfig.AUTHCODE).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                PicResponse picResponse =new Gson().fromJson(res,PicResponse.class);
                String str=picResponse.getData().getImg_src();
                token=picResponse.getData().getToken();
                //saveStringtoSp("token",token);
                Bitmap bitmap=stringToBitmap(str);
                Message msg = handler.obtainMessage();
                //msg.obj=bitmap;
                Bundle bundle=new Bundle();
                bundle.putString("token",token);
                bundle.putParcelable("bitmap",bitmap);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string.split(",")[1], Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}