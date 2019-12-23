package com.wd.home.adapter.consultation;

import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.wd.home.R;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DrugsBean;

import java.util.List;


public class DrugAdapter extends RecyclerView.Adapter {

    private List<DrugsBean.ResultBean> result;
    private Context context;
    private int  Oneon;

    public DrugAdapter(List<DrugsBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_drug_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.drug_name.setText(result.get(i).getName());


        if (Oneon==i){
            viewholder1.drug_name.setBackgroundColor(Color.WHITE);
        }else {
            viewholder1.drug_name.setBackgroundColor(Color.LTGRAY);
        }
        viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Oneon=i;
                notifyDataSetChanged();
                mOnItemClickListener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {


        private final TextView drug_name;

        public Viewholder1(View itemView) {
            super(itemView);
            drug_name = itemView.findViewById(R.id.drug_name);
        }
    }
}
