// Demonstrate two simple lambda expressions.

// A functional interface.
interface MyValue {
	double getValue();
}

// Another functional interface.
interface MyParamValue {
	double getValue(double v);
}

// Use the same functional interface with three different lambda expressions.
interface NumericTest {
	boolean test(int n, int m);
}

// A functional interface that tests two strings.
interface StringTest {
	boolean test(String aStr, String bStr);
}

// A block lambda that finds the smallest positive factor of an int value.
interface NumericFunc {
	int func(int n);
}

class Example {
	static void lambdaDemo() {
		MyValue myVal = () -> 98.6;
		System.out.println("A constant value: " + myVal.getValue());
		// A constant value: 98.6

		MyParamValue myPVal = (n) -> 1.0 / n;
		System.out.println("Reciprocal of 4 is " + myPVal.getValue(4.0));
		System.out.println("Reciprocal of 8 is " + myPVal.getValue(8.0));
		// Reciprocal of 4 is 0.25
		// Reciprocal of 8 is 0.125
	}

	static void lambdaDemo2() {
		NumericTest isFactor = (n, d) -> (n % d) == 0;
		System.out.println("2 is " + (isFactor.test(10,2)?"":"not ") + "a factor of 10");
		System.out.println("3 is " + (isFactor.test(10,3)?"":"not ") + "a factor of 10");
		// 2 is a factor of 10
		// 3 is not a factor of 10

		NumericTest lessThan = (n, m) -> (n < m);
		System.out.println("2 is " + (lessThan.test(2,10)?"":"not ") + "less than 10");
		System.out.println("10 is " + (lessThan.test(10,2)?"":"not ") + "less than 2");
		// 2 is less than 10
		// 10 is not less than 2

		NumericTest absEqual = (n, m) -> (n<0?-n:n) == (m<0?-m:m);
		System.out.println("Absolute values of 4 and -4 are "+(absEqual.test(4,-4)?"":"not ")+"equal");
		System.out.println("Absolute values of 4 and -5 are "+(absEqual.test(4,-5)?"":"not ")+"equal");
		// Absolute values of 4 and -4 are equal
		// Absolute values of 4 and -5 are not equal
	}

	static void lambdaDemo3() {
		StringTest isIn = (a,b) -> a.indexOf(b)!=-1;
		String str = "This is a test";
		System.out.println("Testing string: " + str);
		System.out.println("'is a' "+ (isIn.test(str, "is a")?"":"not ") + "found.");
		System.out.println("'xyz' "+ (isIn.test(str, "xyz")?"":"not ") + "found.");
		// Testing string: This is a test
		// 'is a' found.
		// 'xyz' not found.
	}

	static void blockLambdaDemo() {
		NumericFunc smallestF = (n) -> {
			int result = 1;
			n = n<0?-n:n; // get absolute value of n
			for (int i=2; i<=n/i; i++) {
				if((n%i)==0) {
					result = i;
					break;
				}
			}
			return result;
		};
		System.out.println("Smallest factor of 12 is " + smallestF.func(12));
		System.out.println("Smallest factor of 11 is " + smallestF.func(11));
		// Smallest factor of 12 is 2
		// Smallest factor of 11 is 1
	}

	public static void main(String[] args) {
		lambdaDemo();
		lambdaDemo2();
		lambdaDemo3();
		blockLambdaDemo();
	}
}