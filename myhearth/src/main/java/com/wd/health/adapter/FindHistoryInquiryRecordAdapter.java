package com.wd.health.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.health.DataUtils.DateUtils;
import com.wd.health.R;
import com.wd.health.bean.FindHistoryBean;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 *@describe(描述)：FindHistoryInquiryRecordAdapter
 *@data（日期）: 2019/12/28
 *@time（时间）: 10:09
 *@author（作者）: 张安恒  历史问诊adapter
 **/
public class FindHistoryInquiryRecordAdapter extends RecyclerView.Adapter {
    private List<FindHistoryBean.ResultBean> result;
    private Context context;

    public FindHistoryInquiryRecordAdapter(List<FindHistoryBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_findhistoryinquiryrecord_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
           Viewholder1 viewholder1= (Viewholder1) viewHolder;
           viewholder1.history_name.setText(result.get(i).getDoctorName());
           viewholder1.history_zhiwu.setText(result.get(i).getJobTitle());
           long releaseTime = result.get(i).getInquiryTime();
           String times = DateUtils.times(releaseTime);
           viewholder1.history_time.setText(times);
           Glide.with(context).load(result.get(i).getImagePic()).placeholder(R.drawable.default_head_5).into(viewholder1.history_img);

           viewholder1.history_pingjia.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
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

        private final ImageView history_img;
        private final TextView history_name;
        private final TextView history_zhiwu;
        private final TextView history_time;
        private final Button history_jilu;
        private final Button history_pingjia;

        public Viewholder1( View itemView) {
            super(itemView);
            history_img = itemView.findViewById(R.id.history_img);
            history_name = itemView.findViewById(R.id.history_name);
            history_zhiwu = itemView.findViewById(R.id.history_zhiwu);
            history_time = itemView.findViewById(R.id.history_time);
            history_jilu = itemView.findViewById(R.id.history_jilu);
            history_pingjia = itemView.findViewById(R.id.history_pingjia);
        }
    }
}
