package com.wd.home.adapter.consultation;

import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.wd.home.R;
import com.wd.home.bean.DepartmentBean;

import java.util.List;

/**
 * @author 2019/11/7
 * @author 20:41
 * 杨立朝
 */
public class DepartmentAdapter extends RecyclerView.Adapter {
    private List<DepartmentBean.ResultBean> result;
    private Context context;
    private int  Oneon;

    public DepartmentAdapter(List<DepartmentBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_department_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.department_name.setText(result.get(i).getDepartmentName());

        if (Oneon==i){
            viewholder1.department_name.setTextColor(Color.BLUE);
        }else {
            viewholder1.department_name.setTextColor(Color.GRAY);
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


        private final TextView department_name;

        public Viewholder1( View itemView) {
            super(itemView);
            department_name = itemView.findViewById(R.id.department_name);
        }
    }
}
