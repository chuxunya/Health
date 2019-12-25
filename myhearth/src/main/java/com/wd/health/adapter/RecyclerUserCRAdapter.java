package com.wd.health.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wd.health.DataUtils.DateUtils;
import com.wd.health.R;
import com.wd.health.bean.FindUserCRBean;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 *@describe(描述)：RecyclerUserCRAdapter    查询用户消费记录
 *@data（日期）: 2019/12/24
 *@time（时间）: 20:30
 *@author（作者）: 张安恒
 **/
public class RecyclerUserCRAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<FindUserCRBean.ResultBean> datas = new ArrayList<>();

    public RecyclerUserCRAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_wallet_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        //判断类型
        int type = datas.get(i).getType();
        //	消费 1为收入，2为支出
        int direction = datas.get(i).getDirection();
        /*
         *消费具体方式：1=签到，2=病友圈首评，3=首发病友圈，4=完善档案，
         * 5=健康评测 6=悬赏消费 7=悬赏奖励 8=邀请奖励 9=问诊消费 10=问诊收入，
         * 11=观看资讯 12=送礼物 13=绑定身份证 14=绑定银行卡 15=充值 16=提现
         *，17 = 购买健康视频
         *
         * */
        if (direction == 1) {
            myViewHolder.adapter_user_cr_tv_changeNum.setTextColor(Color.RED);
            myViewHolder.adapter_user_cr_tv_changeNum.setText("+" + datas.get(i).getChangeNum());
            if (type == 1) {
                myViewHolder.adapter_user_cr_tv_type.setText("签到");
            } else if (type == 2) {
                myViewHolder.adapter_user_cr_tv_type.setText("病友圈首评");

            } else if (type == 3) {
                myViewHolder.adapter_user_cr_tv_type.setText("首发病友圈");

            } else if (type == 4) {
                myViewHolder.adapter_user_cr_tv_type.setText("完善档案");

            } else if (type == 5) {
                myViewHolder.adapter_user_cr_tv_type.setText("健康评测");

            } else if (type == 6) {
                myViewHolder.adapter_user_cr_tv_type.setText("悬赏消费");

            } else if (type == 7) {
                myViewHolder.adapter_user_cr_tv_type.setText("悬赏奖励");

            } else if (type == 8) {
                myViewHolder.adapter_user_cr_tv_type.setText("邀请奖励");

            } else if (type == 9) {
                myViewHolder.adapter_user_cr_tv_type.setText("问诊消费");

            } else if (type == 10) {
                myViewHolder.adapter_user_cr_tv_type.setText("问诊收入");

            } else if (type == 11) {
                myViewHolder.adapter_user_cr_tv_type.setText("观看资讯");

            } else if (type == 12) {
                myViewHolder.adapter_user_cr_tv_type.setText("送礼物");

            } else if (type == 13) {
                myViewHolder.adapter_user_cr_tv_type.setText("绑定身份证");

            } else if (type == 14) {
                myViewHolder.adapter_user_cr_tv_type.setText("绑定银行卡");

            } else if (type == 15) {
                myViewHolder.adapter_user_cr_tv_type.setText("充值");
            } else if (type == 16) {
                myViewHolder.adapter_user_cr_tv_type.setText("提现");

            } else if (type == 17) {
                myViewHolder.adapter_user_cr_tv_type.setText("购买健康视频");
            }
        } else if (direction == 2) {
            myViewHolder.adapter_user_cr_tv_changeNum.setTextColor(Color.BLUE);
            myViewHolder.adapter_user_cr_tv_changeNum.setText(datas.get(i).getChangeNum() + "");
            if (type == 1) {
                myViewHolder.adapter_user_cr_tv_type.setText("签到");
            } else if (type == 2) {
                myViewHolder.adapter_user_cr_tv_type.setText("病友圈首评");

            } else if (type == 3) {
                myViewHolder.adapter_user_cr_tv_type.setText("首发病友圈");

            } else if (type == 4) {
                myViewHolder.adapter_user_cr_tv_type.setText("完善档案");

            } else if (type == 5) {
                myViewHolder.adapter_user_cr_tv_type.setText("健康评测");

            } else if (type == 6) {
                myViewHolder.adapter_user_cr_tv_type.setText("悬赏消费");

            } else if (type == 7) {
                myViewHolder.adapter_user_cr_tv_type.setText("悬赏奖励");

            } else if (type == 8) {
                myViewHolder.adapter_user_cr_tv_type.setText("邀请奖励");

            } else if (type == 9) {
                myViewHolder.adapter_user_cr_tv_type.setText("问诊消费");

            } else if (type == 10) {
                myViewHolder.adapter_user_cr_tv_type.setText("问诊收入");

            } else if (type == 11) {
                myViewHolder.adapter_user_cr_tv_type.setText("观看资讯");

            } else if (type == 12) {
                myViewHolder.adapter_user_cr_tv_type.setText("送礼物");

            } else if (type == 13) {
                myViewHolder.adapter_user_cr_tv_type.setText("绑定身份证");

            } else if (type == 14) {
                myViewHolder.adapter_user_cr_tv_type.setText("绑定银行卡");

            } else if (type == 15) {
                myViewHolder.adapter_user_cr_tv_type.setText("充值");

            } else if (type == 16) {
                myViewHolder.adapter_user_cr_tv_type.setText("提现");

            } else if (type == 17) {
                myViewHolder.adapter_user_cr_tv_type.setText("购买健康视频");
            }
        }
        long createTime = datas.get(i).getCreateTime();
        String times = DateUtils.times(createTime);
        myViewHolder.wallet_item_time.setText(times + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<FindUserCRBean.ResultBean> userCRResult) {
        if (userCRResult != null && userCRResult.size() > 0) {
            datas.addAll(userCRResult);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView adapter_user_cr_tv_type;
        private final TextView wallet_item_time;
        private final TextView adapter_user_cr_tv_changeNum;


        public MyViewHolder( View itemView) {
            super(itemView);
            adapter_user_cr_tv_type = itemView.findViewById(R.id.wallet_item_TextView);
            wallet_item_time = itemView.findViewById(R.id.wallet_item_time);
            adapter_user_cr_tv_changeNum = itemView.findViewById(R.id.wallet_item_consumption);

        }
    }
}
