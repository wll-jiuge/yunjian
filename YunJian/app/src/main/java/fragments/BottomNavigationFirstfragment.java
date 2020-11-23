package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.yunjian.firstactivities.First_LogInfomationActivity;
import com.yunjian.firstactivities.First_NotificationActivity;
import com.yunjian.firstactivities.First_ResourceActivity;
import com.yunjian.firstactivities.xunjianactivities.First_XunjianActivity;
import com.yunjian.R;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.banner.BannerResourceEntity;
import com.yunjian.entity.banner.BannerResourceResponse;
import com.yunjian.widget.RadiusImageBanner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xuexiang.xutil.XUtil.runOnUiThread;

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
    RadiusImageBanner banner;
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

    TextView today_things_month,today_things_day,today_things_week;
    int[] images = new int[]{R.mipmap.first01,R.mipmap.first02, R.mipmap.first03,R.mipmap.first04};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_navigation_first,container,false);
        init(v);
        updateDate();
        //轮播图实现
        banner = v.findViewById(R.id.banner);
//        请求资源
        getBannerResourse(v);
//        getResourceImage(v);

        //配置数据
//        mData = DataProvider.getBannerList();
//        simpleImageBanner.setSource(mData)
//        .setOnItemClickListener(new BaseBanner.OnItemClickListener<BannerItem>() {
//                    @Override
//                    public void onItemClick(View view, BannerItem item, int position) {
//                    }
//                })
//      .setIsOnePageLoop(false).startScroll();
//        banner.setSource(mData).startScroll();

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

    private void init(View view){
        today_things_month = view.findViewById(R.id.today_things_month);
        today_things_day = view.findViewById(R.id.today_things_day);
        today_things_week = view.findViewById(R.id.today_things_week);
    }

    /**
     * 更新每日待做时间
     */
    private void updateDate(){
//        final SimpleDateFormat sdf = new SimpleDateFormat("MMM", Locale.getDefault());
//        String month = sdf.format(new Date());
//        DateTime.Now.ToString("MMMM",new System.Globalization.CultureInfo("en-us"));
        Calendar c = Calendar.getInstance();
        int month,day;
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        today_things_month.setText(String.valueOf(month+1)+"月");
        today_things_day.setText(String.valueOf(day)+"日");
        today_things_week.setText(getWeek(c));
    }

    private String getWeek(Calendar c){
        int week = c.get(Calendar.DAY_OF_WEEK);
        String s;
        switch (week){
            case 1:
                s= "周日";
                break;
            case 2:
                s= "周一";
            break;
            case 3:
                s="周二";
            break;
            case 4:
                s="周三";
            break;
            case 5:
                s="周四";
            break;
            case 6:
                s="周五";
            break;
            case 7:
                s="周六";
            break;
            default:
                return "";
        }
        return s;
    }

    /**
     * 获取轮播图
     */
    private void getBannerResourse(View view){
        Api.configNoParams(ApiConfig.BANNER_RESOURCE).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                BannerResourceResponse bannerResourceResponse = new Gson().fromJson(res,BannerResourceResponse.class);
                if(bannerResourceResponse != null && bannerResourceResponse.getCode() == 0) {
                    List<BannerResourceEntity> data = bannerResourceResponse.getData();
                    mData = new ArrayList<>();
                    //图片url数组
                    for(int i=0;i<data.size();i++){
                        BannerItem item = new BannerItem();
                        item.title="";
                        item.imgUrl = data.get(i).getGraphUrl();
                        mData.add(item);
                    }
                    //更改ui
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            banner.setSource(mData).startScroll();
                        }
                    });

                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private void getResourceImage(View view){
        HashMap<String,Object> map = new HashMap();
        map.put("pageNum",0);
        map.put("pageSize",5);
        Api.config(ApiConfig.RESOURCE_IMAGE,map).getRequest(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                Log.i("img",res);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }



}
