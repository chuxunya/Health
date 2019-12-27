package com.wd.health.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/27
 *@Time:10:54
 *@Description:
 **/

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.activity.MySickCircleCommentActivity;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MySickCircleCommentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MySickCircleCommentListBean.ResultBean result;
    Context context;

    public MySickCircleCommentListAdapter(MySickCircleCommentListBean.ResultBean result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.info_list_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        List<MySickCircleCommentListBean.ResultBean.OtherSickCircleCommentListBean> otherSickCircleCommentList = result.getOtherSickCircleCommentList();
        Glide.with(context).load(otherSickCircleCommentList.get(position).getHeadPic()).into(myViewHolder.info_list_headPic);
        myViewHolder.info_list_nickName.setText(otherSickCircleCommentList.get(position).getNickName());
        Log.i("xxxgetNickName", "onBindViewHolder: "+otherSickCircleCommentList.get(position).getNickName());
        myViewHolder.info_list_content.setText(otherSickCircleCommentList.get(position).getContent());
        myViewHolder.info_list_supportNum.setText(otherSickCircleCommentList.get(position).getSupportNum()+"");
        myViewHolder.info_list_opposeNum.setText(otherSickCircleCommentList.get(position).getOpposeNum()+"");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(otherSickCircleCommentList.get(position).getCommentTime());
        myViewHolder.info_list_commentTime.setText(format);
    }

    @Override
    public int getItemCount() {
        return result.getOtherSickCircleCommentList().size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView info_list_nickName,info_list_content,info_list_commentTime,info_list_supportNum,info_list_opposeNum,info_list_caina;
        private final ImageView info_list_headPic,zantong,fandui,img_caina;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            info_list_nickName = itemView.findViewById(R.id.info_list_nickName);
            info_list_content = itemView.findViewById(R.id.info_list_content);
            info_list_commentTime = itemView.findViewById(R.id.info_list_commentTime);
            info_list_supportNum = itemView.findViewById(R.id.info_list_supportNum);
            info_list_opposeNum = itemView.findViewById(R.id.info_list_opposeNum);
            info_list_caina = itemView.findViewById(R.id.info_list_caina);
            info_list_headPic = itemView.findViewById(R.id.info_list_headPic);
            zantong = itemView.findViewById(R.id.zantong);
            fandui = itemView.findViewById(R.id.fandui);
            img_caina = itemView.findViewById(R.id.img_caina);

        }
    }

}
