package com.yunjian.adapters.currentxunjianadapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.entity.currentxunjian.CurrentXunjianDetailsVosEntity;

import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters.currentxunjianadapters
 * @date on 2020/11/15
 * @describe  当前巡检页面巡检项适配器
 */
public class CurrentXunjianXiangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<CurrentXunjianDetailsVosEntity> data;

    public CurrentXunjianXiangAdapter(Context context, List<CurrentXunjianDetailsVosEntity> data){
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.xunjian_item_current_datail_xunjianxiang,parent,false);
        CurrentXunjianXiangAdapter.ViewHolder viewHoler=new CurrentXunjianXiangAdapter.ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CurrentXunjianXiangAdapter.ViewHolder myViewHolder = (CurrentXunjianXiangAdapter.ViewHolder) holder;
        myViewHolder.xunjianxiang.setText(data.get(position).getInspItemName());
        myViewHolder.xunjian_current_xunjianxiang_method.setText(data.get(position).getInspMethodContent().toString());
        Log.i("第三层",data.get(position).getInspStdContent().toString());
//        此处嵌套第三层recycleview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.recyclerView_xunjianxiangStd.setLayoutManager(linearLayoutManager);
//        配置适配器
        CurrentXunjianStdAdapter adapter = new CurrentXunjianStdAdapter(data.get(position).getInspStdContent());
        myViewHolder.recyclerView_xunjianxiangStd.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView xunjianxiang;
        private TextView xunjian_current_xunjianxiang_method;
        private RecyclerView recyclerView_xunjianxiangStd;
        public ViewHolder(@NonNull View view) {
            super(view);
            xunjianxiang = view.findViewById(R.id.xunjian_current_xunjianxiang);
            xunjian_current_xunjianxiang_method =view.findViewById(R.id.xunjian_current_xunjianxiang_method);
            recyclerView_xunjianxiangStd=view.findViewById(R.id.xunjian_current_std);
        }
    }
}
