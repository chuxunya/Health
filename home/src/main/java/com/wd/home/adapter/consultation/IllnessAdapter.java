package com.wd.home.adapter.consultation;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.wd.home.R;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.view.ConditionDetailsActivity;

import java.util.List;


public class IllnessAdapter extends RecyclerView.Adapter {
    private List<DiseaseBean.ResultBean> result1;
    private Context context;

    public IllnessAdapter(List<DiseaseBean.ResultBean> result1, Context context) {
        this.result1 = result1;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_illness_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.illness_name.setText(result1.get(i).getName());

       viewholder1.illness_name.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, ConditionDetailsActivity.class);
               intent.putExtra("id",result1.get(i).getId());
               intent.putExtra("name",result1.get(i).getName());
               context.startActivity(intent);

           }
       });

        viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result1.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {


        private final TextView illness_name;

        public Viewholder1(View itemView) {
            super(itemView);
            illness_name = itemView.findViewById(R.id.illness_name);
        }
    }
}
