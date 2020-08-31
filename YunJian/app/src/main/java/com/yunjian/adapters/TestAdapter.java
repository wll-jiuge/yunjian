package com.yunjian.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.XunjianItemActivity;
import com.yunjian.entity.XunjianItemEntity;
import com.yunjian.entity.XunjianItemResponse;

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
        vh.txt_testname.setText(xunjianItemEntity.getName());
        vh.txt_testfangfa.setText(xunjianItemEntity.getMethod());
        vh.txt_teststanda.setText(xunjianItemEntity.getStandard());
        vh.txt_testxiang.setText(xunjianItemEntity.getItems());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonentity = data.get(position);
                Intent intent = new Intent(mContext,XunjianItemActivity.class);
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
        private TextView txt_testname;
        private TextView txt_testfangfa;
        private TextView txt_teststanda;
        private TextView txt_testxiang;
        public ViewHoler(@NonNull View view) {
            super(view);
            txt_testname = view.findViewById(R.id.txt_test_tesname);
            txt_testfangfa = view.findViewById(R.id.txt_test_testfangfa);
            txt_teststanda = view.findViewById(R.id.txt_test_teststandard);
            txt_testxiang = view.findViewById(R.id.txt_test_testxiang);
        }
    }

}
