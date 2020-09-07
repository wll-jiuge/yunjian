package com.yunjian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.yunjian.entity.LoginResponse;

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
<<<<<<< HEAD
public class MainActivity extends BaseActivity {
=======
public class MainActivity extends AppCompatActivity {
>>>>>>> 64bad1da5154bbd5a4485ac98446534ed230edbb
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
    LoginResponse loginResponse;
    /**
     * The Base.
     */
    BaseActivity base;
    /**
     * The Res.
     */
    String res ="{\"msg\": \"succeed\",\"code\": 0,\"expire\": 608455,\"token\": \"JgiGlovgwDBGvaplieaqkvrtBGbAbga\"}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        loginResponse= gson.fromJson(res,LoginResponse.class);
        token = loginResponse.getToken();
//        if (token!=null||token.length()>0){
//            intent = new Intent(MainActivity.this, Mine_Activity.class);
//            startActivity(intent);
//            this.finish();
//        }else{
            setContentView(R.layout.activity_main);
            ed_pwd=findViewById(R.id.txt_password);
            ed_username = findViewById(R.id.txt_user);
            btn_Login = findViewById(R.id.btn_login);
            btn_Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    login();
                }
            });
//        }

    }

    /**
     * 登录
     */
    private void login(){
        base=new BaseActivity();

        if(StringUtils.isEmpty(ed_pwd.getText().toString()) || StringUtils.isEmpty(ed_username.getText().toString()) ){
            XToastUtils.toast("请输入账号或密码");
        }
        //表示请求成功
        else if(loginResponse.getCode() == 0){
//                   将token保存到SharedPreferences文件中
//            base.saveStringtoSp("token",token);
<<<<<<< HEAD
           navigateTo(Mine_Activity.class);
=======
            Intent intent = new Intent(MainActivity.this, Mine_Activity.class);
            startActivity(intent);
>>>>>>> 64bad1da5154bbd5a4485ac98446534ed230edbb
        }else
        {
            XToastUtils.toast("登录失败");
        }
    }
}