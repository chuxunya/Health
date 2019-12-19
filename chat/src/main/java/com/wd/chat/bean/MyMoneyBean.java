package com.wd.chat.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/19
 *@Time:14:06
 *@Description:我的钱包
 **/
public class MyMoneyBean {
    /**
     * result : 500
     * message : 查询成功
     * status : 0000
     */

    private int result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "MyMoneyBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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
