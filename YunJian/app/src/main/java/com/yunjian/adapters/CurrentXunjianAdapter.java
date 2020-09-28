package com.yunjian.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.entity.CurrentXunjianItemEntity;
import com.yunjian.entity.TaskItemEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters
 * @date on 2020/9/27
 * @describe 当前巡检页面
 */
public class CurrentXunjianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<CurrentXunjianItemEntity> data;
    private CurrentXunjianItemEntity jsonentity;
    public CurrentXunjianAdapter(Context context,List<CurrentXunjianItemEntity> data){
        this.mContext=context;
        this.data=data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.xunjian_item_min_current,parent,false);
        CurrentXunjianAdapter.ViewHolder viewHoler=new CurrentXunjianAdapter.ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CurrentXunjianAdapter.ViewHolder myViewHolder = (CurrentXunjianAdapter.ViewHolder) holder;
        final CurrentXunjianItemEntity currentXunjianItemEntity= data.get(position);
        myViewHolder.txt_test_tesname.setText(currentXunjianItemEntity.getName());
        myViewHolder.txt_test_testfangfa.setText(currentXunjianItemEntity.getMethod());
        myViewHolder.txt_test_teststandard.setText(currentXunjianItemEntity.getStandard());
        myViewHolder.txt_test_testxiang.setText(currentXunjianItemEntity.getItems());
        //获取系统时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date curdate = new Date(System.currentTimeMillis());
        String str = formatter.format(curdate);
        myViewHolder.txt_test_time.setText(str);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_test_tesname;
        private TextView txt_test_testfangfa;
        private TextView txt_test_teststandard,txt_test_time;
        private TextView txt_test_testxiang;
        public ViewHolder(@NonNull View view) {
            super(view);
            txt_test_tesname = view.findViewById(R.id.txt_test_tesname);
            txt_test_testfangfa = view.findViewById(R.id.txt_test_testfangfa);
            txt_test_teststandard = view.findViewById(R.id.txt_test_teststandard);
            txt_test_testxiang = view.findViewById(R.id.txt_test_testxiang);
            txt_test_time = view.findViewById(R.id.txt_test_time);
        }
    }
}
