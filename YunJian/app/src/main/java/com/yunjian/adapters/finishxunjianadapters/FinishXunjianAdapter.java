package com.yunjian.adapters.finishxunjianadapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.adapters.currentxunjianadapters.CurrentXunjianAdapter;
import com.yunjian.entity.finishxunjian.FinishXunjianEntity;
import com.yunjian.firstactivities.xunjianactivities.XunjianItemFinishActivity;

import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters.finishxunjianadapters
 * @date on 2020/11/19
 * @describe  巡检已完成适配器
 */
public class FinishXunjianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private int finishXunjianId;
    private List<FinishXunjianEntity> data;
    public FinishXunjianEntity entity;


    public FinishXunjianAdapter(Context mContext,List<FinishXunjianEntity> data){
        this.mContext=mContext;
        this.data=data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.xunjian_item_min_finish,parent,false);
        FinishXunjianAdapter.ViewHolder viewHoler=new FinishXunjianAdapter.ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FinishXunjianAdapter.ViewHolder myViewHolder = (FinishXunjianAdapter.ViewHolder) holder;
        entity=data.get(position);
        myViewHolder.txt_finish_name.setText(entity.getTaskName());
        myViewHolder.txt_finish_content.setText(entity.getTaskNote());
        myViewHolder.txt_finish_type.setText(entity.getTaskTypeName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, XunjianItemFinishActivity.class);
                int finishXunjianId= entity.getTaskId();
                intent.putExtra("id",finishXunjianId);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_finish_name;
        private TextView txt_finish_content;
        private TextView txt_finish_type;
        public ViewHolder(@NonNull View view) {
            super(view);
            txt_finish_name = view.findViewById(R.id.txt_finish_name);
            txt_finish_content=view.findViewById(R.id.txt_finish_content);
            txt_finish_type = view.findViewById(R.id.txt_finish_type);
        }
    }
}
