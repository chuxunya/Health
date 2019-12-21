package com.wd.home.adapter.sickcirclelist;

import android.content.Context;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.wd.home.R;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.view.OkUtlis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * date:2019/12/19
 * author:席贵
 * function:病友圈列表展示
 * */
public class RecyclerSickCircleAdapter extends RecyclerView.Adapter {


    private List<SickCircleListBean.ResultBean> datas;
    private Context context;

    public RecyclerSickCircleAdapter(List<SickCircleListBean.ResultBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_consultation_sick_circle_item, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        //设置标题
        myViewHolder.sick_circle_title.setText(datas.get(i).getTitle()+"");
        //文章需要的H币数量
        myViewHolder.sick_circle_amount.setText(datas.get(i).getAmount()+"");
        //文章发布的时间
        long releaseTime = datas.get(i).getReleaseTime();
        String times = OkUtlis.titi(releaseTime);
        myViewHolder.sick_circle_releaseTime.setText(times+"");
        //文章需要的H币数量
        myViewHolder.sick_circle_detail.setText(datas.get(i).getDetail()+"");
        //文章收藏数量
        myViewHolder.sick_circle_collectionNum.setText("收藏"+datas.get(i).getCollectionNum());
        //文章建议数量
        myViewHolder.sick_circle_commentNum.setText("建议"+datas.get(i).getCommentNum());


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sickCircleId = datas.get(i).getSickCircleId();
                mOnItemClickListener.onItemClick(i,sickCircleId);
            }
        });

    }

    //设置recycler条目的点击事件
    private OnItemClickListener mOnItemClickListener;
    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position,int sickCircleId);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<SickCircleListBean.ResultBean> sickCircleListBeanResult) {
        if (sickCircleListBeanResult.size() > 0 && sickCircleListBeanResult != null){
            datas.addAll(sickCircleListBeanResult);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //H币数量
        private final TextView sick_circle_amount;
        //收藏数量
        private final TextView sick_circle_collectionNum;
        //评论内容
        private final TextView sick_circle_detail;
        //标题
        private final TextView sick_circle_title;
        //评论的时间
        private final TextView sick_circle_releaseTime;
        //建议数量
        private final TextView sick_circle_commentNum;

        public MyViewHolder( View itemView) {
            super(itemView);
            sick_circle_amount = itemView.findViewById(R.id.sick_circle_amount);
            sick_circle_collectionNum = itemView.findViewById(R.id.sick_circle_collectionNum);
            sick_circle_detail = itemView.findViewById(R.id.sick_circle_detail);
            sick_circle_title = itemView.findViewById(R.id.sick_circle_title);
            sick_circle_releaseTime = itemView.findViewById(R.id.sick_circle_releaseTime);
            sick_circle_commentNum = itemView.findViewById(R.id.sick_circle_commentNum);
        }
    }
}
