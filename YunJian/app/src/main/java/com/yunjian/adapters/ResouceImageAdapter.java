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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 吴立柳
 * @package com.yunjian.adapters
 * @date on 2020/9/23
 * @describe  图片资源适配器
 */
public class ResouceImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater layoutInflater;

    public ResouceImageAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = layoutInflater.inflate(R.layout.resource_imglist_min,parent,false);
        return new ResouceImageAdapter.MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ResouceImageAdapter.MyViewHolder myViewHolder = (ResouceImageAdapter.MyViewHolder) holder;
        //获取系统时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date curdate = new Date(System.currentTimeMillis());
        String str = formatter.format(curdate);
        myViewHolder.resource_image_time.setText(str);
        myViewHolder.resource_image_title.setText("图片名"+"图片标题");
        myViewHolder.resource_image_series.setText("系列"+"系列名");
        myViewHolder.resource_image_author.setText("上传者"+"名字");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView resource_image_bigtitle,
                resource_image_title,
                resource_image_series,
                resource_image_author,
                resource_image_time;
        public ImageView resource_image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resource_image_bigtitle = itemView.findViewById(R.id.resource_image_bigtitle);
            resource_image_title = itemView.findViewById(R.id.resource_image_title);
            resource_image_series = itemView.findViewById(R.id.resource_image_series);
            resource_image_author = itemView.findViewById(R.id.resource_image_author);
            resource_image_time = itemView.findViewById(R.id.resource_image_time);
            resource_image = itemView.findViewById(R.id.resource_image);
        }
    }
}
