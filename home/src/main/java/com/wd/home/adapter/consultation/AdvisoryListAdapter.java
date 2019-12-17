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
import com.wd.home.bean.InformationListBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AdvisoryListAdapter extends RecyclerView.Adapter {
    private List<InformationListBean.ResultBean> resultBeans = new ArrayList<>();
    private Context context;
    private int Oneon;

    public AdvisoryListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_advisorylist_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int i) {
        Viewholder1 viewholder1= (Viewholder1) viewHolder;


        viewholder1.advisorylist_name.setText(resultBeans.get(i).getTitle());
        viewholder1.advisorylist_source.setText(resultBeans.get(i).getSource()+"");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(resultBeans.get(i).getReleaseTime());
        viewholder1.advisorylist_releaseTime.setText(format);

        String[] split = resultBeans.get(i).getThumbnail().split(";");

        for (int j = 0; j <split.length ; j++) {

            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(split[j]))
                    .build();
            DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(build)
                    .build();
            viewholder1.advisorylist_img.setController(draweeController);
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }



    public void addData(List<InformationListBean.ResultBean> result) {
        if (result != null && result.size() > 0){
            resultBeans.addAll(result);
        }
        notifyDataSetChanged();
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {

        private final TextView advisorylist_name;
        private final SimpleDraweeView advisorylist_img;
        private final TextView advisorylist_source;
        private final TextView advisorylist_releaseTime;

        public Viewholder1( View itemView) {
            super(itemView);
            advisorylist_name = itemView.findViewById(R.id.advisorylist_name);
            advisorylist_img = itemView.findViewById(R.id.advisorylist_img);
            advisorylist_source = itemView.findViewById(R.id.advisorylist_source);
            advisorylist_releaseTime = itemView.findViewById(R.id.advisorylist_releaseTime);

        }
    }
}
