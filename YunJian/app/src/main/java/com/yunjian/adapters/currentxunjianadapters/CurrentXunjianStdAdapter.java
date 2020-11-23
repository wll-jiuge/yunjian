package com.yunjian.adapters.currentxunjianadapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.entity.currentxunjian.CurrentXunjianDetailsStdEntity;

import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters.currentxunjianadapters
 * @date on 2020/11/17
 * @describe 检验标准适配器
 */
public class CurrentXunjianStdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<CurrentXunjianDetailsStdEntity> data;
    private CurrentXunjianDetailsStdEntity entity;

    public CurrentXunjianStdAdapter(List<CurrentXunjianDetailsStdEntity> data){
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.xunjian_item_current_detail_std,null);
        CurrentXunjianStdAdapter.ViewHolder viewHoler=new CurrentXunjianStdAdapter.ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CurrentXunjianStdAdapter.ViewHolder myViewHolder = (CurrentXunjianStdAdapter.ViewHolder) holder;
        entity = data.get(holder.getAdapterPosition());
        myViewHolder.stdcontent.setText(data.get(position).getInspStdContent());
//        此处嵌套第3层recycleview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.recyclerView_xunjianxiangStdline.setLayoutManager(linearLayoutManager);
//        配置适配器
        CurrentXunjianStdLineAdapter adapter = new CurrentXunjianStdLineAdapter(entity.getStdLineName());
        myViewHolder.recyclerView_xunjianxiangStdline.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView stdcontent;
        private RecyclerView recyclerView_xunjianxiangStdline;
        public ViewHolder(@NonNull View view) {
            super(view);
            stdcontent =view.findViewById(R.id.xunjian_current_std_content);
            recyclerView_xunjianxiangStdline=view.findViewById(R.id.xunjian_current_stdline_recycleview);
        }
    }
}
