package examples.basic;

import java.util.Scanner;

public class BasicPrintAndInput {
	public static void main(String[] args) {
		System.out.printf("%s\n%s\n\n", "Welcome to", "Java Programming!");
		int n1, n2, s;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter first integer: "); n1 = input.nextInt();
		System.out.print("Enter second integer: "); n2 = input.nextInt();
		s = n1 + n2;
		System.out.printf("\nSum is %d\n", s);

		if (n1 == n2) System.out.printf("%d == %d\n", n1, n2);
		if (n1 != n2) System.out.printf("%d != %d\n", n1, n2);
		if (n1 < n2) System.out.printf("%d < %d\n", n1, n2);
		if (n1 > n2) System.out.printf("%d > %d\n", n1, n2);
		if (n1 <= n2) System.out.printf("%d <= %d\n", n1, n2);
		if (n1 >= n2) System.out.printf("%d >= %d\n", n1, n2);
	}
}