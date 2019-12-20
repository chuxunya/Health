package com.wd.aclass.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/19
 *@Time:8:14
 *@Description:videoadapter
 **/

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.wd.aclass.R;
import com.wd.aclass.bean.VideoBean;
import java.util.List;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;

public class VideoAdapter extends RecyclerView .Adapter<VideoAdapter.Holder> {
    List<VideoBean.ResultBean> result;
    Context context;
    private int ids;
    public CheckBox cb_collecte;
    public CheckBox cb_barrage;

    public VideoAdapter(List<VideoBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }




    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_ada, parent, false);
        cb_collecte = inflate.findViewById(R.id.cb_collecte);
        cb_barrage = inflate.findViewById(R.id.cb_barrage);

        cb_barrage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (cb_barrage.isChecked()) {
                    cb_barrage.setChecked(true);
                } else {
                    cb_barrage.setChecked(false);
                }
                return false;
            }
        });
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String originalUrl = result.get(position).getOriginalUrl();
        //biaoti
        holder.video_title.setText(result.get(position).getTitle());
        holder.video_text.setText(result.get(position).getAbstracts());
        ids = result.get(position).getId();

        //视频
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

        //点击购买
        holder.qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("购买本视频将扣除100H币!");
                builder.setPositiveButton("立即购买", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Log.i("apositssion", "onBindViewHolder: "+ ids);
                        Toast.makeText(context, "购买成功", Toast.LENGTH_SHORT).show();
                        holder.qian.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                setOnClickListent.onCallBank(ids);
                            }
                        });
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        //点击收藏
        cb_collecte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==false){
                    cb_collecte.setBackgroundResource(R.drawable.video_common_button_collection_small_n);
                }else {
                    Toast.makeText(context, "收藏了", Toast.LENGTH_SHORT).show();
                    cb_collecte.setBackgroundResource(R.drawable.video_common_button_collection_small_s);
                    cb_collecte.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setAddListen.onAddCallBack(ids);
                        }
                    });
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
        public ImageView video_pause,qian;
        public TextView video_title,video_text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            video_view = itemView.findViewById(R.id.video_view);
            video_pause = itemView.findViewById(R.id.video_pause);
            video_title = itemView.findViewById(R.id.video_title);
            video_text = itemView.findViewById(R.id.video_text);
            qian = itemView.findViewById(R.id.qian);

        }
    }
    //回调购买
    public SetOnClickListent setOnClickListent;

    public void setSetOnClickListent(SetOnClickListent setOnClickListent) {
        this.setOnClickListent = setOnClickListent;
    }

    public  interface  SetOnClickListent{
        void  onCallBank(int id);
    }
    //回调收藏
    public  SetAddListen setAddListen;

    public void setSetAddListen(SetAddListen setAddListen) {
        this.setAddListen = setAddListen;
    }

    public  interface  SetAddListen{
        void  onAddCallBack(int id);
    }
}
