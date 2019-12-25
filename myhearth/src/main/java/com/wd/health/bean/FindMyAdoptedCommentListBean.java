package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/25
 *@Time:10:10
 *@Description:
 **/

import java.util.List;

public class FindMyAdoptedCommentListBean {


    /**
     * result : []
     * message : 查询成功  被采纳的建议
     * status : 0000
     */

    private String message;
    private String status;
    private List<?> result;

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

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
