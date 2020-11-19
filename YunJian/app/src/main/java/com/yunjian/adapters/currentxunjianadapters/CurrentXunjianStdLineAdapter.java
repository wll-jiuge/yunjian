package com.yunjian.adapters.currentxunjianadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.entity.currentxunjian.CurrentXunjianDetailsStdEntity;
import com.yunjian.entity.currentxunjian.CurrentXunjianDetailsStdLineEntity;

import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters.currentxunjianadapters
 * @date on 2020/11/17
 * @describe 标准线适配器
 */
public class CurrentXunjianStdLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CurrentXunjianDetailsStdLineEntity> data;

    public CurrentXunjianStdLineAdapter(List<CurrentXunjianDetailsStdLineEntity> data){
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.xunjian_item_current_detail_stdline,parent,false);
        CurrentXunjianStdLineAdapter.ViewHolder viewHoler=new CurrentXunjianStdLineAdapter.ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CurrentXunjianStdLineAdapter.ViewHolder myViewHolder = (CurrentXunjianStdLineAdapter.ViewHolder) holder;
        myViewHolder.stdlinename.setText(data.get(position).getStdLineName());
        myViewHolder.stdlinevalue.setText(String.valueOf(data.get(position).getStdLineSinglevalue()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView stdlinename;
        private TextView stdlinevalue;
        public ViewHolder(@NonNull View view) {
            super(view);
            stdlinename =view.findViewById(R.id.xunjian_current_stdline_name);
            stdlinevalue=view.findViewById(R.id.xunjian_current_stdline_value);
        }
    }
}
