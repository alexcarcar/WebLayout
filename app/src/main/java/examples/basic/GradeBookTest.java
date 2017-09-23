package examples.basic;

import java.util.Scanner;

public class GradeBookTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GradeBook myGradeBook = new GradeBook("CS101 Introduction to Java Programming");
		myGradeBook.displayMessage();
		myGradeBook.determineClassAverage();
	}
}
