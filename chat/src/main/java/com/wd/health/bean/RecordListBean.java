package com.wd.health.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/24
 *@Time:14:52
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class RecordListBean {


    /**
     * message : 查询成功
     * result : [{"askTime":1577170213000,"content":"王晓义我儿子","direction":1,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577170184000,"content":"555","direction":1,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577168672000,"content":"李泽楷信球","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"}]
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * askTime : 1577170213000
         * content : 王晓义我儿子
         * direction : 1
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * msgType : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg
         */

        private long askTime;
        private String content;
        private int direction;
        private String doctorHeadPic;
        private int msgType;
        private String userHeadPic;

        public long getAskTime() {
            return askTime;
        }

        public void setAskTime(long askTime) {
            this.askTime = askTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }
    }
}
