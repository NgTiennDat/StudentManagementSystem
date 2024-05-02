package entity;

public class GoodStudent extends Student {

    private float gpa;
    private String bestReward;

    public GoodStudent(String name, String dob, String sex, String phoneNumber, String gradeLevel,
                       float gpa, String bestReward) {
        super(name, dob, sex, phoneNumber, gradeLevel);
        this.gpa = gpa;
        this.bestReward = bestReward;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getBestReward() {
        return bestReward;
    }

    public void setBestReward(String bestReward) {
        this.bestReward = bestReward;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
       return String.format("Good student   {" + super.toString() + ", GPA: %.2f, Best reward: %s", gpa, bestReward);
    }
}
