package entity;

public class NormalStudent extends Student {
    private int englishScore;
    private float entryTestScore;

    public NormalStudent(String name, String dob, String sex, String phoneNumber, String gradeLevel,
                         int englishScore, float entryTestScore) {
        super(name, dob, sex, phoneNumber, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public float getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(float entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Normal Student {" + super.toString() + ", English score: %d, Entry test score: %.2f",
                englishScore, entryTestScore);
    }
}
