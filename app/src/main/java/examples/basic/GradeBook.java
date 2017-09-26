package examples.basic;

import java.util.Scanner;

public class GradeBook {
    private String courseName;
    private int total, gradeCounter;
    private int aCount, bCount, cCount, dCount, fCount;

    public GradeBook(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public void displayMessage() {
        System.out.printf("Welcome to the grade book for\n%s!\n", getCourseName());
    }

    public void inputGrades() {
        Scanner input = new Scanner(System.in);
        int grade;
        System.out.printf("%s\n%s\n  %s\n  %s\n",
                "Enter the integer grades in the range 0-100.",
                "Type the end-of-file indicator to terminate input:",
                "On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
                "On Windows <Ctrl> z then press Enter");
        while (input.hasNext()) {
            grade = input.nextInt();
            total += grade;
            ++gradeCounter;
            incrementLetterGradeCounter(grade);
        }
    }

    public void incrementLetterGradeCounter(int grade) {
        switch (grade / 10) {
            case 9:
            case 10:
                ++aCount;
                break;
            case 8:
                ++bCount;
                break;
            case 7:
                ++cCount;
                break;
            case 6:
                ++dCount;
                break;
            default:
                ++fCount;
        }
    }

    public void displayGradeReport() {
        System.out.println("\nGrade Report:");

        if (gradeCounter != 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("Total of the %d grades entered is %d\n", gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
            System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n", "A: ", aCount, "B: ", bCount, "C: ", cCount, "D: ", dCount, "F: ", fCount);
        } else {
            System.out.printf("No grades were entered");
        }
    }
}
