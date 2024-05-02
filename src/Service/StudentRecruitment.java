package Service;

import java.io.*;
import java.util.*;

import entity.ConstantVar;
import entity.GoodStudent;
import entity.NormalStudent;
import entity.Student;
import exception.InvalidDobException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

public class StudentRecruitment {
    private List<Student> students;
    private List<GoodStudent> goodStudents;
    private List<NormalStudent> normalStudents;
    private List<Student> recruitmentStudents;


    public StudentRecruitment() {
        this.students = new ArrayList<>();
        this.goodStudents = new ArrayList<>();
        this.normalStudents = new ArrayList<>();
        this.recruitmentStudents = new ArrayList<>();
    }

    public void listStudent() {
        this.students.forEach(Student::showInfo);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<GoodStudent> getGoodStudents() {
        return this.goodStudents;
    }

    public List<NormalStudent> getNormalStudents() {
        return this.normalStudents;
    }

    public List<Student> getRecruitmentStudents() {
        return recruitmentStudents;
    }

    public void readFile() {
        try {
            File filepath = new File(ConstantVar.filePath);
            Scanner scanner = new Scanner(filepath);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data[0].equals("GoodStudent")) {
                    GoodStudent goodStudent = new GoodStudent(data[1], data[2], data[3], data[4], data[5], Float.parseFloat(data[6]), data[7]);
                    this.addStudent(goodStudent);
                } else if (data[0].equals("NormalStudent")) {
                    NormalStudent normalStudent = new NormalStudent(data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]), Float.parseFloat((data[7])));
                    this.addStudent(normalStudent);
                } else {
                    System.out.println("Invalid student type: " + data[0]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assert false: "File not found: " + e.getMessage();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            assert false: "Error parsing data: " + e.getMessage();
        }
    }

    public void checkData(Student student) throws InvalidFullNameException, InvalidDobException, InvalidPhoneNumberException {
        if(student.getName().length() < 10 || student.getName().length() > 50) {
            throw new InvalidFullNameException("Invalid full name length. It should be between 10 and 50 characters.");
        }

        if(!HandlingException.isFormatDob(student.getDob())) {
            throw new InvalidDobException("Invalid date of birth format. It should be in dd/MM/YYYY format.");
        }

        if(!HandlingException.isFormatPhoneNumber(student.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Invalid phone number format. It should be start with ... and length equals 10.");
        }
    }

    public void getSize() {
        for(Student student : students) {
            this.classifyStudent(student);
        }
    }

    public void pickCandidates() {
        Scanner in = new Scanner(System.in);
        int numsStudentRecruit = in.nextInt();
        this.getSize();
        if(goodStudents.size() < numsStudentRecruit) {
            recruitmentStudents.addAll(goodStudents);
            int numsNormalStudentToAdd = Math.min(numsStudentRecruit - goodStudents.size(), normalStudents.size());
            recruitmentStudents.addAll(normalStudents.subList(0, numsNormalStudentToAdd));
        } else if(numsStudentRecruit == goodStudents.size()) {
            recruitmentStudents.addAll(goodStudents);
        } else {
            recruitmentStudents.addAll(goodStudents.subList(0, numsStudentRecruit));
        }
    }

    public void listStudentRecruited() {
        System.out.println("*** Here are students who were recruited ***");
        this.recruitmentStudents.forEach(student -> System.out.println(student.toString()));
    }

    public void classifyStudent(Student student) {
        if(student instanceof GoodStudent) {
            this.goodStudents.add((GoodStudent) student);
        } else if(student instanceof NormalStudent) {
            this.normalStudents.add((NormalStudent) student);
        }

        // Sort good student by GPA and by Name
        this.goodStudents.sort(Comparator.comparingDouble(GoodStudent::getGpa).reversed()
                .thenComparing(GoodStudent::getName));

        // Sort good student by Entry test score and by English Score
        this.normalStudents.sort(Comparator.comparingDouble(NormalStudent::getEntryTestScore)
                .thenComparing(NormalStudent::getEnglishScore).reversed()
                .thenComparing(NormalStudent::getName));
    }

    public void listAllStudentByDescName() {
        Collections.sort(students, Comparator.comparing(Student::getName).reversed());
        this.listStudent();
    }

    public void listAllStudentByAscPhoneNumber() {
        Collections.sort(students, Comparator.comparing(Student::getPhoneNumber));
        this.listStudent();
    }

}
