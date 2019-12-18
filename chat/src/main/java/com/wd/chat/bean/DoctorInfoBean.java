package com.wd.chat.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/17
 *@Time:20:45
 *@Description:医生详细信息
 **/
public class DoctorInfoBean {

    /**
     * result : {"badNum":28,"commentList":[{"commentTime":1575009104000,"content":"啊啊拍","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"},{"commentTime":1575008809000,"content":"啥时间到家","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"},{"commentTime":1574906149000,"content":"大巴","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"}],"commentNum":34,"doctorId":63,"doctorName":"杨帅","doctorReceiveGiftList":[{"giftName":"鲜花","giftPic":"http://172.17.8.100/images/health/gift/gift1.jpg","meaning":"鲜花是一种认可","receiveNum":3,"worth":20},{"giftName":"证书","giftPic":"http://172.17.8.100/images/health/gift/gift2.jpg","meaning":"证书是一种象征","receiveNum":2,"worth":50},{"giftName":"奖杯","giftPic":"http://172.17.8.100/images/health/gift/gift3.jpg","meaning":"奖杯是一种荣誉","receiveNum":7,"worth":100}],"followFlag":2,"goodField":"各种擅长","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg","inauguralHospital":"北京人民医院","jobTitle":"住院医师","personalProfile":"菜鸡水平","praise":"50.00%","praiseNum":6,"serverNum":172,"servicePrice":500}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "DoctorInfoBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * badNum : 28
         * commentList : [{"commentTime":1575009104000,"content":"啊啊拍","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"},{"commentTime":1575008809000,"content":"啥时间到家","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"},{"commentTime":1574906149000,"content":"大巴","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg","nickName":"soqkWox"}]
         * commentNum : 34
         * doctorId : 63
         * doctorName : 杨帅
         * doctorReceiveGiftList : [{"giftName":"鲜花","giftPic":"http://172.17.8.100/images/health/gift/gift1.jpg","meaning":"鲜花是一种认可","receiveNum":3,"worth":20},{"giftName":"证书","giftPic":"http://172.17.8.100/images/health/gift/gift2.jpg","meaning":"证书是一种象征","receiveNum":2,"worth":50},{"giftName":"奖杯","giftPic":"http://172.17.8.100/images/health/gift/gift3.jpg","meaning":"奖杯是一种荣誉","receiveNum":7,"worth":100}]
         * followFlag : 2
         * goodField : 各种擅长
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg
         * inauguralHospital : 北京人民医院
         * jobTitle : 住院医师
         * personalProfile : 菜鸡水平
         * praise : 50.00%
         * praiseNum : 6
         * serverNum : 172
         * servicePrice : 500
         */

        private int badNum;
        private int commentNum;
        private int doctorId;
        private String doctorName;
        private int followFlag;
        private String goodField;
        private String imagePic;
        private String inauguralHospital;
        private String jobTitle;
        private String personalProfile;
        private String praise;
        private int praiseNum;
        private int serverNum;
        private int servicePrice;
        private List<CommentListBean> commentList;
        private List<DoctorReceiveGiftListBean> doctorReceiveGiftList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "badNum=" + badNum +
                    ", commentNum=" + commentNum +
                    ", doctorId=" + doctorId +
                    ", doctorName='" + doctorName + '\'' +
                    ", followFlag=" + followFlag +
                    ", goodField='" + goodField + '\'' +
                    ", imagePic='" + imagePic + '\'' +
                    ", inauguralHospital='" + inauguralHospital + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", personalProfile='" + personalProfile + '\'' +
                    ", praise='" + praise + '\'' +
                    ", praiseNum=" + praiseNum +
                    ", serverNum=" + serverNum +
                    ", servicePrice=" + servicePrice +
                    ", commentList=" + commentList +
                    ", doctorReceiveGiftList=" + doctorReceiveGiftList +
                    '}';
        }

        public int getBadNum() {
            return badNum;
        }

        public void setBadNum(int badNum) {
            this.badNum = badNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public int getFollowFlag() {
            return followFlag;
        }

        public void setFollowFlag(int followFlag) {
            this.followFlag = followFlag;
        }

        public String getGoodField() {
            return goodField;
        }

        public void setGoodField(String goodField) {
            this.goodField = goodField;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getServerNum() {
            return serverNum;
        }

        public void setServerNum(int serverNum) {
            this.serverNum = serverNum;
        }

        public int getServicePrice() {
            return servicePrice;
        }

        public void setServicePrice(int servicePrice) {
            this.servicePrice = servicePrice;
        }

        public List<CommentListBean> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<CommentListBean> commentList) {
            this.commentList = commentList;
        }

        public List<DoctorReceiveGiftListBean> getDoctorReceiveGiftList() {
            return doctorReceiveGiftList;
        }

        public void setDoctorReceiveGiftList(List<DoctorReceiveGiftListBean> doctorReceiveGiftList) {
            this.doctorReceiveGiftList = doctorReceiveGiftList;
        }

        public static class CommentListBean {
            /**
             * commentTime : 1575009104000
             * content : 啊啊拍
             * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_5.jpg
             * nickName : soqkWox
             */

            private long commentTime;
            private String content;
            private String headPic;
            private String nickName;

            @Override
            public String toString() {
                return "CommentListBean{" +
                        "commentTime=" + commentTime +
                        ", content='" + content + '\'' +
                        ", headPic='" + headPic + '\'' +
                        ", nickName='" + nickName + '\'' +
                        '}';
            }

            public long getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(long commentTime) {
                this.commentTime = commentTime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }
        }

        public static class DoctorReceiveGiftListBean {
            /**
             * giftName : 鲜花
             * giftPic : http://172.17.8.100/images/health/gift/gift1.jpg
             * meaning : 鲜花是一种认可
             * receiveNum : 3
             * worth : 20
             */

            private String giftName;
            private String giftPic;
            private String meaning;
            private int receiveNum;
            private int worth;

            @Override
            public String toString() {
                return "DoctorReceiveGiftListBean{" +
                        "giftName='" + giftName + '\'' +
                        ", giftPic='" + giftPic + '\'' +
                        ", meaning='" + meaning + '\'' +
                        ", receiveNum=" + receiveNum +
                        ", worth=" + worth +
                        '}';
            }

            public String getGiftName() {
                return giftName;
            }

            public void setGiftName(String giftName) {
                this.giftName = giftName;
            }

            public String getGiftPic() {
                return giftPic;
            }

            public void setGiftPic(String giftPic) {
                this.giftPic = giftPic;
            }

            public String getMeaning() {
                return meaning;
            }

            public void setMeaning(String meaning) {
                this.meaning = meaning;
            }

            public int getReceiveNum() {
                return receiveNum;
            }

            public void setReceiveNum(int receiveNum) {
                this.receiveNum = receiveNum;
            }

            public int getWorth() {
                return worth;
            }

            public void setWorth(int worth) {
                this.worth = worth;
            }
        }
    }
}
