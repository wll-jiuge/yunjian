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
import com.yunjian.firstactivities.xunjianactivities.XunjianItemTimeoutActivity;
import com.yunjian.entity.currentxunjian.XunjianItemEntity;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<XunjianItemEntity> data;
    private XunjianItemEntity jsonentity;
    public TestAdapter(Context context, List<XunjianItemEntity> data){
        this.mContext = context;
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.xunjian_item_min,parent,false);
        ViewHoler viewHoler = new ViewHoler(view);
        return viewHoler;
    }
//绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHoler vh = (ViewHoler)holder;
        final XunjianItemEntity xunjianItemEntity = data.get(position);
        vh.txt_current_name.setText(xunjianItemEntity.getName());
        vh.txt_current_content.setText(xunjianItemEntity.getMethod());
        vh.txt_current_type.setText(xunjianItemEntity.getStandard());

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonentity = data.get(position);
                Intent intent = new Intent(mContext, XunjianItemTimeoutActivity.class);
//                传递单个列表对象
                intent.putExtra("listentity",jsonentity);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHoler extends RecyclerView.ViewHolder{
        private TextView txt_current_name;
        private TextView txt_current_content;
        private TextView txt_current_type;
        public ViewHoler(@NonNull View view) {
            super(view);
            txt_current_name = view.findViewById(R.id.txt_current_name);
            txt_current_content = view.findViewById(R.id.txt_current_content);
            txt_current_type = view.findViewById(R.id.txt_current_type);
        }
    }

}
