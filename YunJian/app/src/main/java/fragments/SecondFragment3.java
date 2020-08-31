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
import com.yunjian.adapters.TestAdapter;
import com.yunjian.entity.XunjianItemEntity;
import com.yunjian.entity.XunjianItemResponse;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment3 extends Fragment {
    private String res = "{\"msg\":\"ok\",\"listCounts\":5,\"code\":0,\"list\":[{\"name\":\"aaa\",\"method\":\"测试方法1\",\"standard\":\"测试标准一\",\"items\":\"aaa数据项内容\"},{\"name\":\"bbb\",\"method\":\"测试方法2\",\"standard\":\"测试标准二\",\"items\":\"bbb数据项内容\"},{\"name\":\"ccc\",\"method\":\"测试方法3\",\"standard\":\"测试标准三\",\"items\":\"ccc数据项内容\"},{\"name\":\"ddd\",\"method\":\"测试方法4\",\"standard\":\"测试标准四\",\"items\":\"ddd数据项内容\"},{\"name\":\"eee\",\"method\":\"测试方法5\",\"standard\":\"测试标准五\",\"items\":\"eee数据项内容\"}]}";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout3,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_second);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        XunjianItemResponse xunjianItemResponse = new Gson().fromJson(res,XunjianItemResponse.class);
        if(xunjianItemResponse!=null&&xunjianItemResponse.getCode() == 0){//请求成功
            List<XunjianItemEntity> data = xunjianItemResponse.getList();
            TestAdapter testAdapter = new TestAdapter(getActivity(),data); //传入数据
            recyclerView.setAdapter(testAdapter);
        }
//        List<XunjianItemResponse> data = new ArrayList<>();
//        for(int i=0;i<8;i++){
//            XunjianItemResponse xunjianItemResponse = new XunjianItemResponse();
//            xunjianItemResponse.setTestname("测试标题");
//            xunjianItemResponse.setTestfangfa("测试方法");
//            xunjianItemResponse.setTeststandard("测试标准");
//            xunjianItemResponse.setTestxiang("测试项");
//            data.add(xunjianItemResponse);
//        }
//        TestAdapter testAdapter = new TestAdapter(getActivity(),data);
//        recyclerView.setAdapter(testAdapter);
        return view;
    }
}
