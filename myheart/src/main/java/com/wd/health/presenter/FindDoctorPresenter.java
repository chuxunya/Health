package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/23
 *@Time:15:35
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.contract.FindDoctorContract;

public class FindDoctorPresenter extends BasePresenter<FindDoctorContract.Iview> implements FindDoctorContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";
    private FindDoctorPresenter findDoctorPresenter;

    @Override
    protected void initModel() {
        findDoctorPresenter = new FindDoctorPresenter();
    }

    @Override
    public void FindDoctor(String page, String count) {

    }
}
