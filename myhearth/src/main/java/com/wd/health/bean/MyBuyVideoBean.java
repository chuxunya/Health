package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:15:32
 *@Description:
 **/

import java.util.List;

public class MyBuyVideoBean {

    /**
     * result : [{"createTime":1577172647000,"duration":55,"id":737,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek2.mp4","title":"儿科医生雨滴","videoId":2},{"createTime":1577172486000,"duration":61,"id":734,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek4.mp4","title":"儿科医生鱼小南","videoId":4},{"createTime":1577172489000,"duration":44,"id":735,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek6.mp4","title":"儿科儿保专家说","videoId":6},{"createTime":1577172500000,"duration":61,"id":736,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek7.mp4","title":"儿科医生雨滴","videoId":7},{"createTime":1577172649000,"duration":22,"id":738,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs3.mp4","title":"仲景植萃","videoId":11},{"createTime":1577172658000,"duration":11,"id":739,"originalUrl":"http://172.17.8.100/video/health/original/js/js4.mp4","title":"零基础健身","videoId":20}]
     * message : 查询成功
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
         * createTime : 1577172647000
         * duration : 55
         * id : 737
         * originalUrl : http://172.17.8.100/video/health/original/ek/ek2.mp4
         * title : 儿科医生雨滴
         * videoId : 2
         */

        private long createTime;
        private int duration;
        private int id;
        private String originalUrl;
        private String title;
        private int videoId;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }
    }
}
