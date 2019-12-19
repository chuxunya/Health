package com.wd.aclass.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/19
 *@Time:8:14
 *@Description:videoadapter
 **/

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.wd.aclass.R;
import com.wd.aclass.bean.VideoBean;
import java.util.List;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
public class VideoAdapter extends RecyclerView .Adapter<VideoAdapter.Holder> {
    List<VideoBean.ResultBean> result;
    Context context;

    public VideoAdapter(List<VideoBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    public CheckBox cb_collecte;
    private CheckBox cb_barrage;


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_ada, parent, false);
        cb_collecte = inflate.findViewById(R.id.cb_collecte);
        cb_barrage = inflate.findViewById(R.id.cb_barrage);

        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String originalUrl = result.get(position).getOriginalUrl();
        Log.i("originalUrlsss", "onBindViewHolder: "+originalUrl);
        String[] split = originalUrl.split(",");
        holder.video_view
                .setVideoPath(split[0]);
        holder.video_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (holder.video_view.isPlaying()){
                    holder.video_view.pause();
                    holder.video_pause.setVisibility(View.VISIBLE);
                }else {
                    holder.video_view.start();
                    holder.video_pause.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        cb_collecte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==false){
                    Toast.makeText(context, "收藏了", Toast.LENGTH_SHORT).show();
                    cb_collecte.setBackgroundResource(R.mipmap.common_button_collection_large_n);
                }else {
                    cb_collecte.setBackgroundResource(R.mipmap.common_button_collection_large_s);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public IjkVideoView video_view;
        public ImageView video_pause;
        public Holder(@NonNull View itemView) {
            super(itemView);
            video_view = itemView.findViewById(R.id.video_view);
            video_pause = itemView.findViewById(R.id.video_pause);
        }
    }
}
