package com.wd.health.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/23
 *@Time:19:00
 *@Description:${DESCRIPTION}
 **/

public class ConsultDoctorBean {

    /**
     * doctorUserName : FG2VzIP7uV0pYbZXAfJ/QWe5Ptq1ra6Zsyo8vjksNww5f6Yxo58AeaTbmVAVyh9N5VpDtB1/CL7YRS9hx0tWyMI+qsUaFmXaQIndA67hxisqHIJNYEzHQL2ib5EZWaXOsgDkbEpFporcmrKrGpLlnzO+OgUO7/Fm9RTFPjzSnJI=
     * message : 查询成功
     * status : 0000
     */

    private String doctorUserName;
    private String message;
    private String status;

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
