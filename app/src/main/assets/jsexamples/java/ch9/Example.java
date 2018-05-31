class ExcTest {
	// Generate an exception. (p 206)
	static void genException() {
		int nums[] = new int[4];
		System.out.println("Before exception is generated.");
		nums[7] = 10;
		System.out.println("this won't be displayed");
	}
}

class Example {

	// Demonstrate exception handling. (p 304)
	static void excDemo1() {
		int nums[] = new int[4];
		try {
			System.out.println("Before exception is generated.");
			nums[7] = 10;
			System.out.println("this won't be displayed");
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Index out-of-bounds!");
		}
		System.out.println("After catch statement.");
		// Before exception is generated.
		// Index out-of-bounds!
		// After catch statement.
	}

	static void excDemo2() {
		try {
			ExcTest.genException();
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Index out-of-bounds!");
		}
		System.out.println("After catch statement.");
		// Before exception is generated.
		// Index out-of-bounds!
		// After catch statement.
	}

	static void notHandled() {
		int nums[] = new int[4];
		System.out.println("Before exception is generated.");
		//nums[7] = 10;
		/*
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 7
        at Example.notHandled(Example.java:44)
        at Example.main(Example.java:50) */
	}

	static void excTypeMismatch() {
		int nums[] = new int[4];
		try {
			System.out.println("Before exception is generated.");
			// nums[7] = 10;
			/* Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 7
	        at Example.excTypeMismatch(Example.java:55)
	        at Example.main(Example.java:68) */
			System.out.println("this won't be displayed");
		} catch (ArithmeticException exc) {
			// Can't catch array boundary error with an ArithmeticException
			System.out.println("Index out-of-bounds!");
		}
		System.out.println("After catch statement.");
	}

	static void excDemo3() {
		int numer[] = { 4, 8, 16, 32, 64, 128 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		for (int i=0; i<numer.length; i++) {
			try {
				System.out.println(numer[i] + " / " + denom[i] + " is " + numer[i]/denom[i]);
			} catch (ArithmeticException exc) {
				System.out.println("Can't divide by Zero!");
			}
		}
		// 4 / 2 is 2
		// Can't divide by Zero!
		// 16 / 4 is 4
		// 32 / 4 is 8
		// Can't divide by Zero!
		// 128 / 8 is 16
	}

	static void excDemo4() {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		for (int i=0; i<numer.length; i++) {
			try {
				System.out.println(numer[i] + " / " + denom[i] + " is " + numer[i]/denom[i]);
			} catch (ArithmeticException exc) {
				System.out.println("Can't divide by Zero!");
			} catch (ArrayIndexOutOfBoundsException exc) {
				System.out.println("No matching element found.");
			}
		}
		// 4 / 2 is 2
		// Can't divide by Zero!
		// 16 / 4 is 4
		// 32 / 4 is 8
		// Can't divide by Zero!
		// 128 / 8 is 16
		// No matching element found.
		// No matching element found.
	}

	static void excDemo5() {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		for (int i=0; i<numer.length; i++) {
			try {
				System.out.println(numer[i] + " / " + denom[i] + " is " + numer[i]/denom[i]);
			} catch (ArrayIndexOutOfBoundsException exc) { // catch subclass
				System.out.println("No matching element found.");
			} catch (Throwable exc) { // catch superclass
				System.out.println("Some exception occurred.");
			}
		}
		// 4 / 2 is 2
		// Some exception occurred.
		// 16 / 4 is 4
		// 32 / 4 is 8
		// Some exception occurred.
		// 128 / 8 is 16
		// No matching element found.
		// No matching element found.
	}

	public static void main(String[] args) {
		excDemo1();
		excDemo2();
		notHandled();
		excTypeMismatch();
		excDemo3();
		excDemo4();
		excDemo5();
	}
}