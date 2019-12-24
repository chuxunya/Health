package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:11:47
 *@Description:
 **/

import java.util.List;

public class VideoInfoBean {

    /**
     * result : [{"buyNum":21,"createTime":1575593391000,"duration":61,"id":2068,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek4.mp4","price":80,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek4.mp4","title":"儿科医生鱼小南","videoId":4,"whetherBuy":2},{"buyNum":7,"createTime":1575593388000,"duration":53,"id":2067,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek3.mp4","price":300,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek3.mp4","title":"儿科医生雨滴","videoId":3,"whetherBuy":2},{"buyNum":32,"createTime":1575593385000,"duration":55,"id":2066,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek2.mp4","price":50,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek2.mp4","title":"儿科医生雨滴","videoId":2,"whetherBuy":2},{"buyNum":63,"createTime":1575593377000,"duration":26,"id":2065,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek1.mp4","price":100,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek1.mp4","title":"南方健康","videoId":1,"whetherBuy":2}]
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
         * buyNum : 21
         * createTime : 1575593391000
         * duration : 61
         * id : 2068
         * originalUrl : http://172.17.8.100/video/health/original/ek/ek4.mp4
         * price : 80
         * shearUrl : http://172.17.8.100/video/health/cut/ek/ek4.mp4
         * title : 儿科医生鱼小南
         * videoId : 4
         * whetherBuy : 2
         */

        private int buyNum;
        private long createTime;
        private int duration;
        private int id;
        private String originalUrl;
        private int price;
        private String shearUrl;
        private String title;
        private int videoId;
        private int whetherBuy;

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getShearUrl() {
            return shearUrl;
        }

        public void setShearUrl(String shearUrl) {
            this.shearUrl = shearUrl;
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

        public int getWhetherBuy() {
            return whetherBuy;
        }

        public void setWhetherBuy(int whetherBuy) {
            this.whetherBuy = whetherBuy;
        }
    }
}
