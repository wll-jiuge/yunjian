package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yunjian.MainActivity;
import com.yunjian.R;
import com.yunjian.adapters.CurrentXunjianAdapter;
import com.yunjian.adapters.TestAdapter;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.CurrenXunjianResponse;
import com.yunjian.entity.CurrentXunjianItemEntity;
import com.yunjian.entity.XunjianItemEntity;
import com.yunjian.entity.XunjianItemResponse;

import java.util.HashMap;
import java.util.List;

import utils.StringUtils;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 巡检页面--当前任务
*/
public class XunjianFragment1 extends BaseFragment {
    private RecyclerView recyclerView;

    private String res = "{\"msg\":\"ok\",\"listCounts\":5,\"code\":0,\"list\":[{\"name\":\"aaa\",\"method\":\"测试方法1\",\"standard\":\"测试标准一\",\"items\":\"aaa数据项内容\"},{\"name\":\"bbb\",\"method\":\"测试方法2\",\"standard\":\"测试标准二\",\"items\":\"bbb数据项内容\"},{\"name\":\"ccc\",\"method\":\"测试方法3\",\"standard\":\"测试标准三\",\"items\":\"ccc数据项内容\"},{\"name\":\"ddd\",\"method\":\"测试方法4\",\"standard\":\"测试标准四\",\"items\":\"ddd数据项内容\"},{\"name\":\"eee\",\"method\":\"测试方法5\",\"standard\":\"测试标准五\",\"items\":\"eee数据项内容\"}]}";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout1,container,false);
        recyclerView = view.findViewById(R.id.xunjianfragment2_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        CurrenXunjianResponse currenXunjianResponse = new Gson().fromJson(res,CurrenXunjianResponse.class);
        //数据请求---get请求
        if(currenXunjianResponse!=null&&currenXunjianResponse.getCode() == 0){
            List<CurrentXunjianItemEntity> data = currenXunjianResponse.getList();
            //传入数据
            CurrentXunjianAdapter adapter = new CurrentXunjianAdapter(getActivity(),data);
            recyclerView.setAdapter(adapter);
        }
//        getXunjianlist(view);

        return view;
    }

    public void getXunjianlist(View view){
        //从shareperence中获取token
        String token = getStringFromSp("token");
        if(!StringUtils.isEmpty(token)){
            HashMap<String,Object> params = new HashMap<>();
            params.put("token",token);
            Api.config(ApiConfig.XUNJIAN_CURRENT,params).getRequest(new YJcallback() {
//                请求成功
                @Override
                public void onSuccess(String res) {
                    //把接收到的res转成响应类

//                    CurrenXunjianResponse currenXunjianResponse = new Gson().fromJson(res,CurrenXunjianResponse.class);
//                    List<CurrentXunjianItemEntity> data = currenXunjianResponse.getList();
//                    CurrentXunjianAdapter adapter = new CurrentXunjianAdapter(getActivity(),data);
//                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Exception e) {

                }
            });
        }
        else{
//            否则跳回登录界面
            navigateTo(MainActivity.class);
        }
    }
}
