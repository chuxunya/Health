package com.wd.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.home.R;
import com.wd.home.adapter.consultation.IllnessAdapter;
import com.wd.home.bean.DiseaseBean;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * @name Health
 * @class name：com.wd.home.adapter
 * @anthor hp
 * @time 2019/12/23 20:15
 */
public class DiseaAdapter extends RecyclerView.Adapter {

    private List<DiseaseBean.ResultBean> result;
    private Context context;

    public DiseaAdapter(List<DiseaseBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_illness_item2, null);

        DiseaAdapter.ViewHolder viewholder1 = new DiseaAdapter.ViewHolder(view);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ViewHolder holder1 = new ViewHolder(holder.itemView);
        holder1.illness_name.setText(result.get(position).getName());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    private IllnessAdapter.OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(IllnessAdapter.OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView illness_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            illness_name = itemView.findViewById(R.id.illness_name2);
        }
    }
}
