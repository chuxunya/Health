package com.wd.health.adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.bean.FindDoctorBean;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 2019/11/14
 * @author 20:29
 * 杨立朝
 * 查询我的关注适配器
 */
public class FindUserDoctorFollowListAdapter extends RecyclerView.Adapter {
    private List<FindDoctorBean.ResultBean> result;
      private Context context;
    private int doctorId;

    public FindUserDoctorFollowListAdapter(List<FindDoctorBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override

    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_finduserdoctorfollowlist_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1= (Viewholder1) viewHolder;
        viewholder1.attention_doctor_name.setText(result.get(i).getName());
        viewholder1.attention_doctor_inauguralhospital.setText(result.get(i).getInauguralHospital());
        viewholder1.attention_doctor_jobtitle.setText(result.get(i).getJobTitle());
        viewholder1.attention_doctor_praise.setText(result.get(i).getPraise());
        viewholder1.attention_doctor_praiseNum.setText(result.get(i).getPraiseNum()+"");
        Glide.with(context).load(result.get(i).getImagePic()).placeholder(R.drawable.default_head_5).into(viewholder1.attention_doctor_imagePic);
        doctorId = result.get(i).getDoctorId();

        ((Viewholder1) viewHolder).quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("xxxxx", "onClick: "+doctorId);
                setDeleteListen.setdelete(doctorId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public  setDeleteListen setDeleteListen;

    public void setSetDeleteListen(FindUserDoctorFollowListAdapter.setDeleteListen setDeleteListen) {
        this.setDeleteListen = setDeleteListen;
    }

    public  interface  setDeleteListen{
        void  setdelete(int id);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {


        private final ImageView attention_doctor_imagePic;
        private final TextView attention_doctor_name;
        private final TextView attention_doctor_jobtitle;
        private final TextView attention_doctor_inauguralhospital;
        private final TextView attention_doctor_praise;
        private final TextView attention_doctor_praiseNum;
        private final Button quxiao;


        public Viewholder1( View itemView) {
            super(itemView);

            attention_doctor_imagePic = itemView.findViewById(R.id.attention_doctor_imagePic);
            attention_doctor_name = itemView.findViewById(R.id.attention_doctor_name);
            attention_doctor_jobtitle = itemView.findViewById(R.id.attention_doctor_jobtitle);
            attention_doctor_inauguralhospital = itemView.findViewById(R.id.attention_doctor_inauguralhospital);
            attention_doctor_praise = itemView.findViewById(R.id.attention_doctor_praise);
            attention_doctor_praiseNum = itemView.findViewById(R.id.attention_doctor_praiseNum);
            quxiao = itemView.findViewById(R.id.quxiao);
        }
    }
}
