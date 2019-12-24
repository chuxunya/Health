package com.wd.health.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.bean.FindquanBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 *@describe(描述)：FindUserSickCollectionListAdapter   病友圈
 *@data（日期）: 2019/12/24
 *@time（时间）: 15:00
 *@author（作者）: 张安恒
 **/
public class FindUserSickCollectionListAdapter extends RecyclerView.Adapter  {
    private List<FindquanBean.ResultBean> result;
    private Context context;

    public FindUserSickCollectionListAdapter(List<FindquanBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_findquan_item, null);

        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1= (Viewholder1) viewHolder;
        viewholder1.usersick_title.setText(result.get(i).getTitle());
        viewholder1.usersick_disease.setText(result.get(i).getDisease());
        viewholder1.usersick_collectionnum.setText("收藏  "+result.get(i).getCollectionNum());
        viewholder1.usersick_commentnum.setText("           建议"+result.get(i).getCommentNum());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(result.get(i).getCreateTime());
        viewholder1.usersick_createtime.setText(format);



    }

    @Override
    public int getItemCount() {
        return result.size();
    }


    public class Viewholder1 extends RecyclerView.ViewHolder {


        private final TextView usersick_title;
        private final TextView usersick_disease;
        private final TextView usersick_collectionnum;
        private final TextView usersick_commentnum;
        private final TextView usersick_createtime;

        public Viewholder1( View itemView) {
            super(itemView);
            usersick_title = itemView.findViewById(R.id.usersick_title);
            usersick_disease = itemView.findViewById(R.id.usersick_disease);
            usersick_collectionnum = itemView.findViewById(R.id.usersick_collectionnum);
            usersick_commentnum = itemView.findViewById(R.id.usersick_commentnum);
            usersick_createtime = itemView.findViewById(R.id.usersick_createtime);
        }
    }
}



