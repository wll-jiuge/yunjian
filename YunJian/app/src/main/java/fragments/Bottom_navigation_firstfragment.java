package fragments;
/*
* 我的界面
*
* */
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner;
import com.yunjian.First_LogInfomation;
import com.yunjian.First_Notification;
import com.yunjian.First_Resource;
import com.yunjian.First_Xunjian;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.DataProvider;

public class Bottom_navigation_firstfragment extends Fragment {
    SimpleImageBanner simpleImageBanner;
    GridView gridView;
    private List<BannerItem> mData;  //轮播图列表
    SimpleAdapter adapter;
    Intent intent;
    String[] titles = new String[]{"日常巡检", "日志", "资源库", "整改通知"};
    int[] images = new int[]{R.mipmap.first03,R.mipmap.first04, R.mipmap.first05,R.mipmap.first06};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_navigation_first,container,false);
//        轮播图
        simpleImageBanner = v.findViewById(R.id.banner);
        mData = DataProvider.getBannerList();  //配置数据
        simpleImageBanner.setSource(mData)
        .setOnItemClickListener(new BaseBanner.OnItemClickListener<BannerItem>() {
                    @Override
                    public void onItemClick(View view, BannerItem item, int position) {
                    }
                })
      .setIsOnePageLoop(false).startScroll();
        simpleImageBanner.setSource(mData).startScroll();

        //gridview菜单
        gridView = v.findViewById(R.id.gridView);
        List<Map<String,Object>> list = new ArrayList<>();
        //往列表中添加数据
        for(int i=0;i<titles.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name",titles[i]);
            map.put("image",images[i]);
            list.add(map);
        }
        adapter = new SimpleAdapter(getActivity(),list,R.layout.first_girdview,
                new String[]{"name","image"},new int[]{R.id.textView2,R.id.imageView3});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:{//巡检
                        intent = new Intent(getActivity(), First_Xunjian.class);
                        startActivity(intent);
                        intent=null;
                        break;
                    }
                    case 1:{//日志信息
                        intent = new Intent(getActivity(), First_LogInfomation.class);
                        startActivity(intent);
                        intent=null;
                        break;
                    }
                    case 2:{//资源库
                        intent = new Intent(getActivity(), First_Resource.class);
                        startActivity(intent);
                        intent=null;
                        break;
                    }
                    case 3://整改通知
                        intent = new Intent(getActivity(), First_Notification.class);
                        startActivity(intent);
                        intent=null;
                        break;
                }

            }
        });
        return v;
    }

}
