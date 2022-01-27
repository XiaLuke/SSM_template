package cn.xiafan.entity;

public class Student {
    private Integer id;

    private String realName;

    private String phone;

    private String collegeProfessionalClass;

    private String email;

    private String password;

    private String studentId;
    

    public Student() {
		super();
	}

	public Student(String realName, String phone, String collegeProfessionalClass, String email,
			String password, String studentId) {
		super();
		this.realName = realName;
		this.phone = phone;
		this.collegeProfessionalClass = collegeProfessionalClass;
		this.email = email;
		this.password = password;
		this.studentId = studentId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCollegeProfessionalClass() {
        return collegeProfessionalClass;
    }

    public void setCollegeProfessionalClass(String collegeProfessionalClass) {
        this.collegeProfessionalClass = collegeProfessionalClass == null ? null : collegeProfessionalClass.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }
}