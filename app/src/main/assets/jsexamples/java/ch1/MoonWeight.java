import java.util.Scanner;

class MoonWeight {
	private static final double gravityMoon = 0.17;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your weight in pounds: ");
		double weight = in.nextDouble();
		System.out.println("Your weight on the moon is " + weight*gravityMoon + " pounds.");
		// Enter your weight in pounds: 200
		// Your weight on the moon is 34.0 pounds.
	}
}