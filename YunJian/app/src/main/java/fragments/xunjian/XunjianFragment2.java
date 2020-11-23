package fragments.xunjian;

import android.os.Bundle;
import android.util.Log;
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
import com.yunjian.adapters.currentxunjianadapters.CurrentXunjianAdapter;
import com.yunjian.adapters.finishxunjianadapters.FinishXunjianAdapter;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.currentxunjian.CurrentXunjianItemEntity;
import com.yunjian.entity.currentxunjian.CurrentXunjianResponse;
import com.yunjian.entity.finishxunjian.FinishXunjianEntity;
import com.yunjian.entity.finishxunjian.FinishXunjianResponse;

import java.util.List;

import static com.xuexiang.xutil.XUtil.runOnUiThread;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 巡检页面--已完成页面
*/
public class XunjianFragment2 extends Fragment {

    private RecyclerView xunjian_finish_recycleview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout2,container,false);
        init(view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xunjian_finish_recycleview.setLayoutManager(linearLayoutManager);
//        获取数据
        getFinishXunjian(view);
        return view;
    }
    public void init(View view){
        xunjian_finish_recycleview = view.findViewById(R.id.xunjian_finish_recycleview);
    }

    private void getFinishXunjian( View view){
        Api.configNoParams(ApiConfig.XUNJIAN_FINISH).getRequestUseHeader(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                Log.i("finish",res);
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
                FinishXunjianResponse response = new Gson().fromJson(res, FinishXunjianResponse.class);
//                请求成功
                if(response!= null && response.getCode() == 0){
                    List<FinishXunjianEntity> data = response.getData();
                    FinishXunjianAdapter adapter = new FinishXunjianAdapter(getActivity(),data);
                    xunjian_finish_recycleview.setAdapter(adapter);
                }
            }
        });
    }

}
