import java.util.Random;

class Game {
	public static void main(String[] args) {
		System.out.println("Guessing Game");
		System.out.println("-------------");
		System.out.println("by Simon Carcar (c) 2018");
		System.out.println();

		// 1. Computer picks a number from 1 to 100
		Random rand = new Random();
		int secret = rand.nextInt(100) + 1;
		// System.out.println(secret);

		// 2. print"pick a number between
		// 3. guess = get a number  
		// 4. If guess > secret print (too low) and goto step 2
		// 5. If guess < secret print (too high) and goto step 2
		// 6. else you got my number
	}
}