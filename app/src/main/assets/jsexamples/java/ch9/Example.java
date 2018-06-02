class ExcTest {
	// Generate an exception. (p 206)
	static void genException() {
		int nums[] = new int[4];
		System.out.println("Before exception is generated.");
		nums[7] = 10;
		System.out.println("this won't be displayed");
	}
}

class NonIntResultException extends Exception {
	int n;
	int d;

	NonIntResultException(int i, int j) {
		n = i;
		d = j;
	}

	public String toString() {
		return "Result of " + n + " / " + d + " is non-integer.";
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

	static void nestTrys() {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		try { // outer try
			for (int i=0; i<numer.length; i++) {
				try { // nested try
					System.out.println(numer[i]+" / "+denom[i] + " is " + numer[i]/denom[i]);
				} catch(ArithmeticException exc) {
					System.out.println("Can't divide by zero!");
				}
			}
		} catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("No matching element found.");
			System.out.println("Fatal error - program terminated.");
		}
		// 4 / 2 is 2
		// Can't divide by zero!
		// 16 / 4 is 4
		// 32 / 4 is 8
		// Can't divide by zero!
		// 128 / 8 is 16
		// No matching element found.
		// Fatal error - program terminated.		
	}

	static void throwDemo() {
		try {
			System.out.println("Before throw.");
			throw new ArithmeticException();
		} catch (ArithmeticException exc) {
			System.out.println("Exception caught.");
		}
		System.out.println("After try/catch block.");
		// Before throw.
		// Exception caught.
		// After try/catch block.		
	}

	static void rethrow() {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		for (int i=0; i<numer.length; i++) {
			try {
				System.out.println(numer[i]+" / "+denom[i] + " is " + numer[i]/denom[i]);
			} catch(ArithmeticException exc) {
				System.out.println("Can't divide by zero!");
			} catch(IndexOutOfBoundsException exc) {
				System.out.println("No matching element found.");
				throw exc; // rethrow exception
			}
		}
		// 4 / 2 is 2
		// Can't divide by zero!
		// 16 / 4 is 4
		// 32 / 4 is 8
		// Can't divide by zero!
		// 128 / 8 is 16
		// No matching element found.
		// Fatal error - program terminated.		
	}

	static void useThrowableMethods() {
		try {
			int nums[] = new int[4];
			System.out.println("Before exception is generated.");
			nums[7] = 10;
			System.out.println("This won't be displayed");
		} catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("Standard message is: ");
			System.out.println(exc);
			System.out.println("\nStack trace: ");
			exc.printStackTrace();
		}
		System.out.println("After catch statement.");
		// Before exception is generated.
		// Standard message is:
		// java.lang.ArrayIndexOutOfBoundsException: 7

		// Stack trace:
		// java.lang.ArrayIndexOutOfBoundsException: 7
		//         at Example.useThrowableMethods(Example.java:194)
		//         at Example.main(Example.java:220)
		// After catch statement.		
	}

	static void generateForFinally(int what) {
		int t;
		int nums[] = new int[2];

		System.out.println("Receiving " + what);
		try {
			switch(what) {
				case 0:
					t = 10 / what; // generate div-by-zero error
					break;
				case 1:
					nums[4] = 4; // generate array index error
					break;
				case 2:
					return;
			}
		} catch (ArithmeticException exc) {
			System.out.println("Can't divide by zero!");
			return;
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("No matching element found.");
		} finally {
			System.out.println("Leaving try.");
		}
	}

	static void useFinally() {
		for (int i=0; i<3; i++) {
			generateForFinally(i);
			System.out.println();
		}
		// Receiving 0
		// Can't divide by zero!
		// Leaving try.

		// Receiving 1
		// No matching element found.
		// Leaving try.

		// Receiving 2
		// Leaving try.		
	}

	static char prompt(String str) throws java.io.IOException {
		System.out.print(str + ": ");
		char c = ' ';
		// c = (char) System.in.read();
		if (c=='x') throw new java.io.IOException();
		return c;
	}

	static void throwsDemo() {
		char ch = '3';
		try {
			ch = prompt("Enter a letter");
		} catch(java.io.IOException exc) {
			System.out.println("I/O exception occurred.");
			ch = 'X';
		}
		System.out.println("You pressed "+ch);
		// Enter a letter: d
		// You pressed d

		// Enter a letter: x
		// I/O exception occurred.
		// You pressed X
	}

	static void multiCatch() {
		int a=88, b=0;
		int result;
		char chrs[] = {'A', 'B', 'C'};
		for (int i=0; i<2; i++) {
			try {
				if(i==0)
					result = a/b; // generate ArithmeticException
				else
					chrs[5] = 'X'; // generate ArrayIndexOutOfBoundsException
			} catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Exception caught: "+e);
			}
		}
		System.out.println("After multi-catch.");
		// Exception caught: java.lang.ArithmeticException: / by zero
		// Exception caught: java.lang.ArrayIndexOutOfBoundsException: 5
		// After multi-catch.
	}

	static void customExceptDemo() {
		int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };
		for (int i=0; i<numer.length; i++) {
			try {
				if((numer[i]%2) != 0)
					throw new NonIntResultException(numer[i], denom[i]);
				System.out.println(numer[i]+" / "+denom[i] + " is " + numer[i]/denom[i]);
			} catch(ArithmeticException exc) {
				System.out.println("Can't divide by zero!");
			} catch(IndexOutOfBoundsException exc) {
				System.out.println("No matching element found.");
			} catch(NonIntResultException exc) {
				System.out.println(exc);
			}
		}
		// 4 / 2 is 2
		// Can't divide by zero!
		// Result of 15 / 4 is non-integer.
		// 32 / 4 is 8
		// Can't divide by zero!
		// Result of 127 / 8 is non-integer.
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
		nestTrys();
		throwDemo();
		try {
			rethrow();
		} catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("Fatal error - program terminated.");
		}
		useThrowableMethods();
		useFinally();
		throwsDemo();
		multiCatch();
		customExceptDemo();
	}
}