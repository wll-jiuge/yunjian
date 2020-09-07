package fragments;

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
import com.yunjian.First_LogInfomationActivity;
import com.yunjian.First_NotificationActivity;
import com.yunjian.First_ResourceActivity;
import com.yunjian.First_XunjianActivity;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.DataProvider;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 首页fragment
*/
public class BottomNavigationFirstfragment extends BaseFragment {
    /**
     * 轮播图组件
     */
    SimpleImageBanner simpleImageBanner;
    /**
     * The Grid view.
     */
    GridView gridView;
    /**
     * 轮播图列表
     */
    private List<BannerItem> mData;
    /**
     * The Adapter.
     */
    SimpleAdapter adapter;
    /**
     * The Intent.
     */
    Intent intent;
    /**
     * The Titles.
     */
    String[] titles = new String[]{"日常巡检", "日志", "资源库", "整改通知"};
    /**
     * The Images.
     */
    int[] images = new int[]{R.mipmap.first03,R.mipmap.first04, R.mipmap.first05,R.mipmap.first06};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_navigation_first,container,false);
        //轮播图实现
        simpleImageBanner = v.findViewById(R.id.banner);
        //配置数据
        mData = DataProvider.getBannerList();
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
                    //巡检
                    case 0:{
//                        intent = new Intent(getActivity(), First_XunjianActivity.class);
//                        startActivity(intent);
                        navigateTo(First_XunjianActivity.class);
                        intent=null;
                        break;
                    }
                    //日志信息
                    case 1:{
//                        intent = new Intent(getActivity(), First_LogInfomationActivity.class);
//                        startActivity(intent);
                        navigateTo(First_LogInfomationActivity.class);
                        intent=null;
                        break;
                    }
                    //资源库
                    case 2:{
//                        intent = new Intent(getActivity(), First_ResourceActivity.class);
//                        startActivity(intent);
                        navigateTo(First_ResourceActivity.class);
                        intent=null;
                        break;
                    }
                    //整改通知
                    case 3:
//                        intent = new Intent(getActivity(), First_NotificationActivity.class);
//                        startActivity(intent);
                        navigateTo(First_NotificationActivity.class);
                        intent=null;
                        break;
                }

            }
        });
        return v;
    }

}
