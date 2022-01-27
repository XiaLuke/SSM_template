package cn.xiafan.entity;

public class TClass {
    private String collegeId;
    private String professionalId;


    public TClass() {
    }

    public TClass(String collegeId, String professionalId) {
        this.collegeId = collegeId;
        this.professionalId = professionalId;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }
}
