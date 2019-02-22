import java.util.Random;
import java.util.Scanner;

public class RandomSquare {

	static Random rnd = new Random();

	private static void square(int f, int r) {
		int file =  (int) 'a' + f;
		char fileChar = (char) file;
		int rank = r + 1;
		String rankChar = "" + rank;
		System.out.print(fileChar+rankChar + " (b/w/q)? ");
	}

	private static String color(int f, int r) {
		return (f+r)%2 == 0 ? "b" : "w";
	}

	private static String randomString() {
		int file = rnd.nextInt(8);
		int rank = rnd.nextInt(8);
		square(file,rank);
		return color(file,rank);
	}

	private static String stats(int t,int c) {
		return " ("+c+"/"+t+")";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s;
		int tries = 0;
		int correct = 0;
		do {
			tries++;
			String ans = randomString();
			s = in.next().toLowerCase();
			if (s.equals("q")) break;
			if (ans.equals(s)) {
				correct++;
				System.out.println("y"+stats(tries,correct));
			} else {
				System.out.println("n"+stats(tries,correct));
			}
		} while(true);
	}
}