package com.wd.home.adapter.consultation;

import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.wd.home.R;
import com.wd.home.bean.InformationBean;

import java.util.List;


public class PlateListAdapter extends RecyclerView.Adapter {
    private List<InformationBean.ResultBean> beanResult;
    private Context context;
    private int  Oneon;

    public PlateListAdapter(List<InformationBean.ResultBean> beanResult, Context context) {
        this.beanResult = beanResult;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_platelist_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
         Viewholder1 viewholder1= (Viewholder1) viewHolder;
         viewholder1.platelist_name.setText(beanResult.get(i).getName());

        if (Oneon==i){
            viewholder1.platelist_name.setTextColor(Color.BLUE);
        }else {
            viewholder1.platelist_name.setTextColor(Color.GRAY);
        }
         viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Oneon=i;
                 notifyDataSetChanged();
                 mOnItemClickListener.onItemClick(beanResult.get(i).getId());
             }
         });

    }

    @Override
    public int getItemCount() {
        return beanResult.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {

        private final TextView platelist_name;

        public Viewholder1(View itemView) {
            super(itemView);
            platelist_name = itemView.findViewById(R.id.platelist_name);
        }
    }
}
