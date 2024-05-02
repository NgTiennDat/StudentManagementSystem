import entity.Student;
import Service.StudentRecruitment;
import exception.InvalidDobException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentRecruitment recruitment = new StudentRecruitment();
        recruitment.readFile();

        String option;
        do {
            System.out.println("*** Option list ***");
            System.out.println("1. Print list student");
            System.out.println("2. Check data validator");
            System.out.println("3. Pick candidate");
            System.out.println("4. Print all student by descending name");
            System.out.println("5. Print all student by ascending phone number");
            System.out.println("0. End the program!");
            Scanner in = ScannerUI.getScanner();
            option = in.nextLine();

            switch (option) {
                case "1": {
                    recruitment.listStudent();
                    break;
                }
                case "2": {
                    for (Student student : recruitment.getStudents()) {
                        try {
                            recruitment.checkData(student);
                            System.out.println("Data is valid for student " + student.getName());
                        } catch (InvalidFullNameException | InvalidDobException | InvalidPhoneNumberException e) {
                            System.out.println("Error validating data for student " + student.getName() + ": " + e.getMessage());
                        }
                    }
                    break;
                }
                case "3": {
                    recruitment.pickCandidates();
                    recruitment.listStudentRecruited();
                    break;
                }
                case "4": {
                    recruitment.listAllStudentByDescName();
                    break;
                }
                case "5": {
                    recruitment.listAllStudentByAscPhoneNumber();
                    break;
                }
                case "0": {
                    return;
                }
                default: {
                    System.out.println("Invalid option");
                    break;
                }
            }
        } while (true);
    }
}