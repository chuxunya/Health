package com.wd.health.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dueeeke.videoplayer.player.IjkVideoView;
import com.wd.health.R;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.VideoInfoBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
/**
 *@describe(描述)：MyVideoAdapter  我的视频
 *@data（日期）: 2019/12/25
 *@time（时间）: 9:15
 *@author（作者）: 张安恒
 **/
public class MyVideoAdapter extends RecyclerView.Adapter {
    private List<MyBuyVideoBean.ResultBean> result;
    private Context context;


    public MyVideoAdapter(List<MyBuyVideoBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_myvideo, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(result.get(i).getCreateTime());
        myViewHolder.video_createtime.setText(format);

        myViewHolder.bought.setVisibility(View.VISIBLE);
        myViewHolder.myadapter_video_ijkplayer.setUrl(result.get(i).getOriginalUrl());
        myViewHolder.myadapter_video_ijkplayer.start();

        //设置播放监听
        myViewHolder.myadapter_video_ijkplayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //如果正在播放(点击暂停、播放)
                if (myViewHolder.myadapter_video_ijkplayer.isPlaying()){
                    myViewHolder.myadapter_video_ijkplayer.pause();
                    myViewHolder.adapter_vvideo_start_stop.setVisibility(View.VISIBLE);
                }else {
                    myViewHolder.myadapter_video_ijkplayer.start();
                    myViewHolder.adapter_vvideo_start_stop.setVisibility(View.GONE);
                }
                return false;
            }
        });


        myViewHolder.video_del.setOnClickListener(new View.OnClickListener() {
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView adapter_video_volist_buyNum;
        private final TextView video_createtime;
        private final TextView video_del;
        private final IjkVideoView myadapter_video_ijkplayer;
        private final ImageView adapter_vvideo_start_stop;
        private final ImageView bought;

        public MyViewHolder( View itemView) {
            super(itemView);
            adapter_video_volist_buyNum = itemView.findViewById(R.id.video_buynum);
            video_createtime = itemView.findViewById(R.id.video_createtime);
            adapter_vvideo_start_stop = itemView.findViewById(R.id.adapter_vvideo_start_stop);
            video_del = itemView.findViewById(R.id.video_del);
            myadapter_video_ijkplayer = itemView.findViewById(R.id.myadapter_video_ijkplayer);
            bought = itemView.findViewById(R.id.bought);
        }
    }
}
