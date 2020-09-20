package com.yunjian.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;
import com.xuexiang.xui.widget.tabbar.vertical.ITabView;
import com.yunjian.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters
 * @date on 2020/9/17
 * @describe 日志列表适配器
 */
public class LoginfoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater layoutInflater;

    public LoginfoListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = layoutInflater.inflate(R.layout.loginfo_list_min,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.loginfo_list_min_name.setText("测试任务");
        //获取系统时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date curdate = new Date(System.currentTimeMillis());
        String str = formatter.format(curdate);
        myViewHolder.loginfo_list_min_time.setText(str);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView loginfo_list_min_name,
                loginfo_list_min_situation,
                loginfo_list_progress,
                loginfo_list_min_time,
                loginfo_list_min_weather;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            loginfo_list_min_name = itemView.findViewById(R.id.loginfo_list_min_name);
            loginfo_list_min_situation = itemView.findViewById(R.id.loginfo_list_min_situation);
            loginfo_list_progress = itemView.findViewById(R.id.loginfo_list_progress);
            loginfo_list_min_time = itemView.findViewById(R.id.loginfo_list_min_time);
            loginfo_list_min_weather = itemView.findViewById(R.id.loginfo_list_min_weather);
        }
    }
}
