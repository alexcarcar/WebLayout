package examples.basic;

import java.util.Scanner;

public class GradeBookTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GradeBook myGradeBook = new GradeBook("");

		System.out.printf("Initial course name is: %s\n\n", myGradeBook.getCourseName());
		System.out.printf("Please enter the course name:");
		String theName = input.nextLine();
		myGradeBook.setCourseName(theName);
		System.out.println();
		myGradeBook.displayMessage();

		GradeBook gradeBook1 = new GradeBook("CS101 Introduction to Java Programming");
		GradeBook gradeBook2 = new GradeBook("CS102 Data Structures in Java");
		System.out.printf("gradeBook1 course name is: %s\n", gradeBook1.getCourseName());
		System.out.printf("gradeBook2 course name is: %s\n", gradeBook2.getCourseName());
	}
}
