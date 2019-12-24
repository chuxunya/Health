package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:9:29
 *@Description:
 **/

public class MyWalletBean {

    /**
     * result : 0
     * message : 查询成功
     * status : 0000
     */

    private int result;
    private String message;
    private String status;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
