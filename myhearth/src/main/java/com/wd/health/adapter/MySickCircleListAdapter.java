package com.wd.health.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/27
 *@Time:10:54
 *@Description:
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.activity.MySickActivity;
import com.wd.health.bean.MySickCircleListBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MySickCircleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MySickCircleListBean.ResultBean> result;
    Context context;

    public MySickCircleListAdapter(List<MySickCircleListBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mysickcircle_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.mysickcircleitem_name.setText(result.get(position).getTitle());
        myViewHolder.mysickcircleitem_text.setText(result.get(position).getDetail());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(result.get(position).getReleaseTime());
        myViewHolder.mysickcircleitem_tiem.setText(format);
        myViewHolder.mysickcircleitem_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    itemOnClick.onitem(result.get(position).getSickCircleId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mysickcircleitem_name;
        private final TextView mysickcircleitem_tiem;
        private final TextView mysickcircleitem_text;
        private final TextView mysickcircleitem_pinglun;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mysickcircleitem_tiem = itemView.findViewById(R.id.mysickcircleitem_tiem);
            mysickcircleitem_name = itemView.findViewById(R.id.mysickcircleitem_name);
            mysickcircleitem_text = itemView.findViewById(R.id.mysickcircleitem_text);
            mysickcircleitem_pinglun = itemView.findViewById(R.id.mysickcircleitem_pinglun);
        }
    }
    ItemOnClick itemOnClick;

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public interface ItemOnClick{
        void onitem(String id);
    }
}
