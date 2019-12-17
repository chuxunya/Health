package com.wd.home.adapter.consultation;

import android.content.Context;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.wd.home.R;
import com.wd.home.bean.DepartmentBean;

import java.util.List;


public class ConsultationAdapter extends RecyclerView.Adapter {
    private List<DepartmentBean.ResultBean> beans;
    private Context context;

    public ConsultationAdapter(List<DepartmentBean.ResultBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_consultation_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, final int i) {

        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.consultation_name.setText(beans.get(i).getDepartmentName());
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(beans.get(i).getPic()))
                .build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(build)
                .build();
        viewholder1.simpleDraweeView.setController(draweeController);

        viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {

        private final TextView consultation_name;
        private final SimpleDraweeView simpleDraweeView;

        public Viewholder1( View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.consultation_img);
            consultation_name = itemView.findViewById(R.id.consultation_name);
        }
    }
}
