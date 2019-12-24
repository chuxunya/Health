package com.wd.health.adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.bean.AddInfoCollectBean;


import java.text.SimpleDateFormat;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 2019/11/7
 * @author 9:54
 * 杨立朝
 */
public class AdvisoryAdapter extends RecyclerView.Adapter {
    private List<AddInfoCollectBean.ResultBean> result;
    private Context context;
    private int Oneon;

    public AdvisoryAdapter(List<AddInfoCollectBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_advisorylist_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1= (Viewholder1) viewHolder;


        viewholder1.advisorylist_name.setText(result.get(i).getTitle());
     //   viewholder1.advisorylist_source.setText(result.get(i).getSource()+"");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(result.get(i).getCreateTime());
        viewholder1.advisorylist_releaseTime.setText(format);

        String[] split = result.get(i).getThumbnail().split(";");
        for (int j = 0; j <split.length ; j++) {
            Glide.with(context).load(split[j]).into(viewholder1.advisorylist_img);
        }

        viewholder1.quxiao.setOnClickListener(new View.OnClickListener() {
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

        private final TextView advisorylist_name;
        private final ImageView advisorylist_img,quxiao;
        private final TextView advisorylist_source;
        private final TextView advisorylist_releaseTime;

        public Viewholder1( View itemView) {
            super(itemView);
            advisorylist_name = itemView.findViewById(R.id.advisorylist_name);
            advisorylist_img = itemView.findViewById(R.id.advisorylist_img);
            advisorylist_source = itemView.findViewById(R.id.advisorylist_source);
            advisorylist_releaseTime = itemView.findViewById(R.id.advisorylist_releaseTime);
            quxiao = itemView.findViewById(R.id.quxiao);

        }
    }
}
