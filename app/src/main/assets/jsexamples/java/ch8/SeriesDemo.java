import java.util.Arrays;

// Implement Series. (p  280)
class ByTwos implements Series {
	int start;
	int val;
	int prev;

	ByTwos() {
		start = 0;
		val = 0;
		prev = -2;
	}

	public int getNext() {
		prev = val;
		val += 2;
		return val;
	}

	public void reset() {
		val = start;
		prev = start - 2;
	}

	public void setStart(int x) {
		start = x;
		val = x;
	}

	int getPrevious() {
		return prev;
	}
}

class ByThrees implements Series {
	int start;
	int val;

	ByThrees() {
		start = 0;
		val = 0;
	}

	public int getNext() {
		val += 3;
		return val;
	}

	public void reset() {
		val = start;
	}

	public void setStart(int x) {
		start = x;
		val = x;
	}
}

class SeriesDemo {

	public static void example1() {
		ByTwos ob = new ByTwos();
		for (int i=0; i<5; i++) {
			System.out.println("Next value is " + ob.getNext());
		}
		System.out.println("\nResetting");
		ob.reset();
		for (int i=0; i<5; i++) {
			System.out.println("Next value is " + ob.getNext());
		}
		System.out.println("\nStarting at 100");
		ob.setStart(100);
		for (int i=0; i<5; i++) {
			System.out.println("Next value is " + ob.getNext());
		}

		System.out.println("Previous value is " + ob.getPrevious());

		// Next value is 2
		// Next value is 4
		// Next value is 6
		// Next value is 8
		// Next value is 10

		// Resetting
		// Next value is 2
		// Next value is 4
		// Next value is 6
		// Next value is 8
		// Next value is 10

		// Starting at 100
		// Next value is 102
		// Next value is 104
		// Next value is 106
		// Next value is 108
		// Next value is 110

		// Previous value is 108
	}

	public static void example2() {
		ByTwos twoOb = new ByTwos();
		ByThrees threeOb = new ByThrees();
		Series ob;

		for (int i=0; i<5; i++) {
			ob = twoOb;
			System.out.println("Next ByTwos value is " + ob.getNext());
			ob = threeOb;
			System.out.println("Next ByThrees value is " + ob.getNext());
		}
		// Next ByTwos value is 2
		// Next ByThrees value is 3
		// Next ByTwos value is 4
		// Next ByThrees value is 6
		// Next ByTwos value is 6
		// Next ByThrees value is 9
		// Next ByTwos value is 8
		// Next ByThrees value is 12
		// Next ByTwos value is 10
		// Next ByThrees value is 15

		System.out.println(Arrays.toString(threeOb.getNextArray(10)));
		// [18, 21, 24, 27, 30, 33, 36, 39, 42, 45]

		System.out.println(Arrays.toString(threeOb.skipAndGetNextArray(5, 10)));
		// [63, 66, 69, 72, 75, 78, 81, 84, 87, 90]
	}

	public static void main(String[] args) {
		example1();
		example2();
	}
}
