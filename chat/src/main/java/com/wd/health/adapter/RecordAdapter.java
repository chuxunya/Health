package com.wd.health.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.bean.RecordListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:李泽楷
 *@Date: 2019/12/18
 *@Time:15:09
 *@Description:聊天消息适配器
 **/
public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RecordListBean.ResultBean> list;
    Context context;



    public RecordAdapter(List<RecordListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getDirection() == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.liaotianleft_adapter, parent, false);
            return new MyHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.liaotianright_adapter, parent, false);
            return new MyHolder2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 1:
                if (holder instanceof MyHolder) {
                    ((MyHolder) holder).textLiao1huanzhe.setText(list.get(position).getContent());
                    ((MyHolder) holder).simLiaoZphuanzhe.setImageURI(list.get(position).getDoctorHeadPic());
                }
                break;
            case 2:
                if (holder instanceof MyHolder2) {
                    ((MyHolder2) holder).textLiao2docior.setText(list.get(position).getContent());
                    ((MyHolder2) holder).simLiaoImagedocior.setImageURI(list.get(position).getDoctorHeadPic());
                }
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.sim_liao_zphuanzhe)
        SimpleDraweeView simLiaoZphuanzhe;
        @BindView(R2.id.text_liao1huanzhe)
        TextView textLiao1huanzhe;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyHolder2 extends RecyclerView.ViewHolder {
        @BindView(R2.id.sim_liao_imagedocior)
        SimpleDraweeView simLiaoImagedocior;
        @BindView(R2.id.text_liao2docior)
        TextView textLiao2docior;
        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
