package fragments.xunjian;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yunjian.R;
import com.yunjian.adapters.currentxunjianadapters.CurrentXunjianAdapter;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.currentxunjian.CurrentXunjianResponse;
import com.yunjian.entity.currentxunjian.CurrentXunjianItemEntity;

import java.util.List;

import fragments.BaseFragment;

import static com.xuexiang.xutil.XUtil.runOnUiThread;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 巡检页面--当前任务
*/
public class XunjianFragment1 extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.xunjianfragment2_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //请求数据
        getCurrentXunjian(view);


    }

    /**
     *
     * @param
     */
    private void getCurrentXunjian(View view){
        Api.configNoParams(ApiConfig.XUNJIAN_CURRENT).getRequestUseHeader(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                Log.i("current",res);
                changeUI(view,res);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public void changeUI(View view,String res){
        runOnUiThread(new Runnable(){

            @Override
            public void run() {
                CurrentXunjianResponse response = new Gson().fromJson(res, CurrentXunjianResponse.class);
//                请求成功
                if(response!= null && response.getCode() == 0){
                    List<CurrentXunjianItemEntity> data = response.getData();
                    CurrentXunjianAdapter adapter = new CurrentXunjianAdapter(getActivity(),data);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }


}
