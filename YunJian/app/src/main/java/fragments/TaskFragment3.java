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
import com.yunjian.R;
import com.yunjian.adapters.TaskAdapter;
import com.yunjian.entity.TaskItemEntity;
import com.yunjian.entity.TaskItemResponse;


import java.util.List;

/**
 *@package fragments
 *@date on 2020/9/20
 *@author 何楚玥
 *@describe 任务页面--超时任务
 */

public class TaskFragment3 extends Fragment {
    private String res = "{\"msg\":\"ok\",\"listCounts\":5,\"code\":0,\"list\":[{\"name\":\"aaa\",\"method\":\"测试方法1\",\"standard\":\"测试标准一\",\"items\":\"aaa数据项内容\"},{\"name\":\"bbb\",\"method\":\"测试方法2\",\"standard\":\"测试标准二\",\"items\":\"bbb数据项内容\"},{\"name\":\"ccc\",\"method\":\"测试方法3\",\"standard\":\"测试标准三\",\"items\":\"ccc数据项内容\"},{\"name\":\"ddd\",\"method\":\"测试方法4\",\"standard\":\"测试标准四\",\"items\":\"ddd数据项内容\"},{\"name\":\"eee\",\"method\":\"测试方法5\",\"standard\":\"测试标准五\",\"items\":\"eee数据项内容\"}]}";

    /*//对应的回调接口根据网络请求返回的数据来传递不同的消息
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };*/

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        *//*Api.configNoParams(ApiConfig.TASK_OVERTIME).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                TaskItemResponse taskItemResponse=new Gson().fromJson(res,TaskItemResponse.class);
                RecyclerView recyclerView=view.findViewById(R.id.recyclerview_try);
                List<TaskItemEntity> data=taskItemResponse.getList();
                TaskAdapter taskAdapter=new TaskAdapter(getActivity(),data);
                recyclerView.setAdapter(taskAdapter);
            }
            @Override
            public void onFailure(Exception e) {

            }
        });*//*
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_layout3,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_try);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        TaskItemResponse taskItemResponse = new Gson().fromJson(res,TaskItemResponse.class);
/*        Api.configNoParams(ApiConfig.TASK_OVERTIME).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                TaskItemResponse taskItemResponse=new Gson().fromJson(res,TaskItemResponse.class);
                List<TaskItemEntity> data=taskItemResponse.getList();
                TaskAdapter taskAdapter=new TaskAdapter(getActivity(),data);
                recyclerView.setAdapter(taskAdapter);
            }
            @Override
            public void onFailure(Exception e) {

            }
        });*/
        //请求成功
        if(taskItemResponse!=null&&taskItemResponse.getCode() == 0){
            List<TaskItemEntity> data = taskItemResponse.getList();
            //传入数据
            TaskAdapter taskAdapter = new TaskAdapter(getActivity(),data);
            recyclerView.setAdapter(taskAdapter);
        }

        return view;
    }
}
