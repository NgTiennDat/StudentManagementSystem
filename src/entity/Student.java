package entity;

public abstract class Student {

    private String name;
    private String dob;
    private String sex;
    private String phoneNumber;
    private String gradeLevel;

    public Student(String name, String dob, String sex, String phoneNumber, String gradeLevel) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return String.format("Name: %s, Date of birth: %s, Sex: %s, Phone number: %s, Grade level: %s",
                name, dob, sex, phoneNumber, gradeLevel);
    }
}
