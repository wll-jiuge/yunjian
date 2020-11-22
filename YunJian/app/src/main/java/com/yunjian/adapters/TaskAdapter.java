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
import com.yunjian.TaskItemActivity;
import com.yunjian.entity.TaskItemEntity;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<TaskItemEntity> data;
    private TaskItemEntity jsonentity;

    static class ViewHoler extends RecyclerView.ViewHolder{
        private TextView txt_task_name;
        private TextView txt_task_method;
        private TextView txt_task_standard;
        private TextView txt_task_project;
        private TextView txt_task_time;

        public ViewHoler(View view) {
            super(view);
            txt_task_name = view.findViewById(R.id.txt_task_name);
            txt_task_method = view.findViewById(R.id.txt_task_method);
            txt_task_standard = view.findViewById(R.id.txt_task_standard);
            txt_task_project = view.findViewById(R.id.txt_task_project);
            txt_task_time=view.findViewById(R.id.day_time);
        }
    }

    public TaskAdapter(Context context,List<TaskItemEntity> data){
        this.mContext=context;
        this.data=data;
    }

    @NotNull
    @Override
    public ViewHoler onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(mContext).inflate(R.layout.task_item_min,parent,false);
        ViewHoler viewHoler=new ViewHoler(view);
        return viewHoler;
    }

//绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        ViewHoler vh = (ViewHoler)holder;
        final TaskItemEntity taskItemEntity= data.get(position);
        vh.txt_task_name.setText(taskItemEntity.getTaskName());
        vh.txt_task_method.setText(taskItemEntity.getTaskNote());
        vh.txt_task_standard.setText(taskItemEntity.getTaskTypeName());
        vh.txt_task_project.setText(taskItemEntity.getTaskTypeName());
        vh.txt_task_time.setText(taskItemEntity.getTaskPlanDate());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonentity = data.get(position);
                Intent intent = new Intent(mContext, TaskItemActivity.class);
//                传递单个列表对象
                intent.putExtra("listentity", String.valueOf(jsonentity));
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
