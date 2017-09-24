package examples.basic;

import java.util.Scanner;

public class GradeBook {
    private String courseName;

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

    public void determineClassAverage() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grade or -1 to quit: ");
        int total = 0, gradeCounter = 0, grade = input.nextInt();
        double average;
        while (grade != -1) {
            total += grade;
            gradeCounter++;
            System.out.print("Enter grade or -1 to quit: ");
            grade = input.nextInt();
        }
        if (gradeCounter != 0) {
            average = (double) total / gradeCounter;
            System.out.printf("\nTotal of all %d grades is %d\n", gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
        } else {
            System.out.println("No grades were entered");
        }
    }
}
