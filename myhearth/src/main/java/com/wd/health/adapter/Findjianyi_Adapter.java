package com.wd.health.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wd.health.R;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 *@describe(描述)：Findjianyi_Adapter  被采纳的意见
 *@data（日期）: 2019/12/25
 *@time（时间）: 10:29
 *@author（作者）: 张安恒
 **/
public class Findjianyi_Adapter extends RecyclerView.Adapter {
      private List<?> result;
      private Context context;

    public Findjianyi_Adapter(List<?> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_findjianyi_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {




    }

    @Override
    public int getItemCount() {
        return result.size();
    }



    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public class Viewholder1 extends RecyclerView.ViewHolder {



        public Viewholder1( View itemView) {
            super(itemView);

        }
    }
}
