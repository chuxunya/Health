package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/28
 *@Time:9:05
 *@Description:
 **/

import java.util.List;

public class FindHistoryBean {

    /**
     * result : [{"departmentId":0,"doctorId":162,"doctorName":"呆志3","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image7.jpg","inquiryTime":1577435835000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","jobTitle":"主任","recordId":3965,"userName":"ZmmTM7xcx485131108"},{"departmentId":0,"doctorId":162,"doctorName":"呆志3","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image7.jpg","inquiryTime":1577435795000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","jobTitle":"主任","recordId":3964,"userName":"ZmmTM7xcx485131108"},{"departmentId":0,"doctorId":158,"doctorName":"董先生","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg","inquiryTime":1577423901000,"jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"主任","recordId":3958,"userName":"l42lX41758992398"},{"departmentId":0,"doctorId":164,"doctorName":"fan","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image6.jpg","inquiryTime":1577423280000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","jobTitle":"主治医师","recordId":3957,"userName":"OE5xbK326445811"},{"departmentId":0,"doctorId":158,"doctorName":"董先生","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg","inquiryTime":1577418294000,"jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"主任","recordId":3952,"userName":"l42lX41758992398"}]
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
         * departmentId : 0
         * doctorId : 162
         * doctorName : 呆志3
         * evaluateStatus : 1
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image7.jpg
         * inquiryTime : 1577435835000
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * jobTitle : 主任
         * recordId : 3965
         * userName : ZmmTM7xcx485131108
         */

        private int departmentId;
        private int doctorId;
        private String doctorName;
        private int evaluateStatus;
        private String imagePic;
        private long inquiryTime;
        private String jiGuangPwd;
        private String jobTitle;
        private int recordId;
        private String userName;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
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

        public int getEvaluateStatus() {
            return evaluateStatus;
        }

        public void setEvaluateStatus(int evaluateStatus) {
            this.evaluateStatus = evaluateStatus;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
