import java.util.*;

class Dice {
	public static void main(String[] args) {
		Random generator = new Random();
		int value = generator.nextInt();
		System.out.println("The random number is "+value);

		// % java Dice
		// The random number is 813786086

		// % java Dice
		// The random number is -950040776

		// % java Dice
		// The random number is 1658504727
	}	
}