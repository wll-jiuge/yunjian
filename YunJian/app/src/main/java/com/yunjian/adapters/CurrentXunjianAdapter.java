package com.yunjian.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.XunjianItemCurrentActivity;
import com.yunjian.entity.currentxunjian.CurrentXunjianItemEntity;

import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters
 * @date on 2020/9/27
 * @describe 当前巡检页面适配器
 */
public class CurrentXunjianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<CurrentXunjianItemEntity> data;
    private int currentXunjianId;
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
        myViewHolder.txt_current_name.setText(currentXunjianItemEntity.getTaskName());
        myViewHolder.txt_current_content.setText(currentXunjianItemEntity.getTaskNote());
        myViewHolder.txt_current_type.setText(currentXunjianItemEntity.getTaskTypeName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentXunjianId = data.get(position).getTaskId();
                Intent intent = new Intent(mContext, XunjianItemCurrentActivity.class);
//                传递ID,便于后面的数据请求
                intent.putExtra("id",currentXunjianId);
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_current_name;
        private TextView txt_current_content;
        private TextView txt_current_type;
        public ViewHolder(@NonNull View view) {
            super(view);
            txt_current_name = view.findViewById(R.id.txt_current_name);
            txt_current_content = view.findViewById(R.id.txt_current_content);
            txt_current_type = view.findViewById(R.id.txt_current_type);
        }
    }
}
