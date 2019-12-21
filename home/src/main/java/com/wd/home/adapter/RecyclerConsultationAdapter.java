package com.wd.home.adapter;

import android.content.Context;
import android.graphics.Color;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.wd.home.R;
import com.wd.home.bean.DepartmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/12/19
 * author:席贵
 * function:
 */
public class RecyclerConsultationAdapter extends RecyclerView.Adapter {


    //科室列表集合
    private List<DepartmentBean.ResultBean> result = new ArrayList<>();
    private Context context;
    private int Oneon;

    public RecyclerConsultationAdapter(List<DepartmentBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_sick_circle_item, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.consultation_name.setText(result.get(i).getDepartmentName());

        if (Oneon==i){
            myViewHolder.consultation_name.setTextColor(Color.BLUE);
        }else {
            myViewHolder.consultation_name.setTextColor(Color.GRAY);
        }
        //传点击的id
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Oneon = i;
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public void addData(List<DepartmentBean.ResultBean> result) {
        if (result.size() > 0 && result != null){
            result.addAll(result);
        }
        notifyDataSetChanged();
    }

    //设置recycler条目的点击事件
    private OnItemClickListener mOnItemClickListener;
    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView consultation_name;

        public MyViewHolder( View itemView) {
            super(itemView);
            consultation_name = itemView.findViewById(R.id.consultation_name);
        }
    }

}
