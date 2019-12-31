package com.wd.health.bean;
 /**
  *@describe(描述)：CurrentInquiryRecordBean
  *@data（日期）: 2019/12/30
  *@time（时间）: 14:45
  *@author（作者）: 张安恒 当前问诊
  **/
public class CurrentInquiryRecordBean {

    /**
     * result : {"department":"骨科","departmentId":2,"doctorId":2,"doctorName":"安安","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inquiryTime":1573556471000,"jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"主治医师","recordId":2745,"userName":"t3vKzr1586503085"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

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
         * department : 骨科
         * departmentId : 2
         * doctorId : 2
         * doctorName : 安安
         * evaluateStatus : 1
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg
         * inquiryTime : 1573556471000
         * jiGuangPwd : enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=
         * jobTitle : 主治医师
         * recordId : 2745
         * userName : t3vKzr1586503085
         */

        private String department;
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

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

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
