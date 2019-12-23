package com.wd.home.adapter.consultation;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.wd.home.R;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.view.ConditionDetailActivity;
import com.wd.home.view.ConditionDetailsActivity;


import java.util.List;


public class QueryDrugAdapter extends RecyclerView.Adapter {
    private List<DrugsKnowBean.ResultBean> result1;
    private Context context;

    public QueryDrugAdapter(List<DrugsKnowBean.ResultBean> result1, Context context) {
        this.result1 = result1;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_querydrug_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {

        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.querydrug_name.setText(result1.get(i).getName());

        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(result1.get(i).getPicture()))
                .build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(build)
                .build();
        viewholder1.querydrug_img.setController(draweeController);


        viewholder1.querydrug_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ConditionDetailActivity.class);
                intent.putExtra("id",result1.get(i).getId());
                intent.putExtra("name",result1.get(i).getName());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return result1.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {


        private final TextView querydrug_name;
        private final SimpleDraweeView querydrug_img;

        public Viewholder1( View itemView) {
            super(itemView);
            querydrug_name = itemView.findViewById(R.id.querydrug_name);
            querydrug_img = itemView.findViewById(R.id.querydrug_img);
        }
    }
}
