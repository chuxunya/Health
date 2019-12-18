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
     * result : {"badNum":0,"commentList":[],"commentNum":0,"doctorId":1,"doctorName":"张医生","doctorReceiveGiftList":[{"giftName":"鲜花","giftPic":"http://172.17.8.100/images/health/gift/gift1.jpg","meaning":"鲜花是一种认可","receiveNum":4,"worth":20},{"giftName":"奖杯","giftPic":"http://172.17.8.100/images/health/gift/gift3.jpg","meaning":"奖杯是一种荣誉","receiveNum":1,"worth":100}],"followFlag":2,"goodField":"各种儿童疑难杂症","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inauguralHospital":"北京清华大学附属医院","jobTitle":"主治医师","personalProfile":"毕业于清华大学医学院，有五年的专业经验，多次获得奖项","praise":"0.00%","praiseNum":0,"serverNum":46,"servicePrice":500}
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
         * badNum : 0
         * commentList : []
         * commentNum : 0
         * doctorId : 1
         * doctorName : 张医生
         * doctorReceiveGiftList : [{"giftName":"鲜花","giftPic":"http://172.17.8.100/images/health/gift/gift1.jpg","meaning":"鲜花是一种认可","receiveNum":4,"worth":20},{"giftName":"奖杯","giftPic":"http://172.17.8.100/images/health/gift/gift3.jpg","meaning":"奖杯是一种荣誉","receiveNum":1,"worth":100}]
         * followFlag : 2
         * goodField : 各种儿童疑难杂症
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg
         * inauguralHospital : 北京清华大学附属医院
         * jobTitle : 主治医师
         * personalProfile : 毕业于清华大学医学院，有五年的专业经验，多次获得奖项
         * praise : 0.00%
         * praiseNum : 0
         * serverNum : 46
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
        private List<?> commentList;
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

        public List<?> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<?> commentList) {
            this.commentList = commentList;
        }

        public List<DoctorReceiveGiftListBean> getDoctorReceiveGiftList() {
            return doctorReceiveGiftList;
        }

        public void setDoctorReceiveGiftList(List<DoctorReceiveGiftListBean> doctorReceiveGiftList) {
            this.doctorReceiveGiftList = doctorReceiveGiftList;
        }

        public static class DoctorReceiveGiftListBean {
            /**
             * giftName : 鲜花
             * giftPic : http://172.17.8.100/images/health/gift/gift1.jpg
             * meaning : 鲜花是一种认可
             * receiveNum : 4
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
