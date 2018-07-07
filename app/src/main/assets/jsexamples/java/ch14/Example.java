import java.io.*;
import java.util.Arrays;
import java.util.function.Predicate;

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

// Use a generic functional interface.
interface SomeTest<T> {
	boolean test(T n, T m);
}

// An example of capturing a local variable from the enclosing scope.
interface MyFunc {
	int func(int n);
}

interface MyIOAction {
	boolean ioAction(Reader rdr) throws IOException;
}

interface MyTransform<T> {
	void transform(T[] a);
}

class MyIntPredicates {
	// Demonstrate a method reference for a static method.
	interface IntPredicate {
		boolean test(int n);
	}

	static boolean isPrime(int n) {
		if (n<2) return false;
		for (int i=2; i<n/i; i++) {
			if((n%i)==0) return false;
		}
		return true;
	}

	static boolean isEven(int n) {
		return (n%2) == 0;
	}

	static boolean isPositive(int n) {
		return n>0;
	}

	static boolean numTest(IntPredicate p, int v) {
		return p.test(v);
	}

	static void demo() {
		boolean result;
		result = numTest(MyIntPredicates::isPrime, 17);
		if(result) System.out.println("17 is prime.");
		// 17 is prime.

		result = numTest(MyIntPredicates::isEven, 12);
		if(result) System.out.println("12 is even.");
		// 12 is even.

		result = numTest(MyIntPredicates::isPositive, 10);
		if(result) System.out.println("10 is positive.");
		// 10 is positive.
	}
}

// Use a method reference to an instance method.
class MyIntNum {
	interface IntPredicate {
		boolean test(int n);
	}

	private int v;
	MyIntNum(int x) {
		v = x;
	}

	int getNum() {
		return v;
	}

	boolean isFactor(int n) {
		return (v%n) == 0;
	}

	static void demo() {
		boolean result;
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		IntPredicate ip = myNum::isFactor;
		result = ip.test(3);
		if (result) System.out.println("3 is a factor of " + myNum.getNum());
		// 3 is a factor of 12

		ip = myNum2::isFactor;
		result = ip.test(3);
		if (!result) System.out.println("3 is not a factor of " + myNum2.getNum());
		// 3 is not a factor of 16
	}

	// Use an instance method reference to refer to any instance.
	interface MyIntNumPredicate {
		boolean test(MyIntNum mv, int n);
	}

	static void demo2() {
		boolean result;
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		MyIntNumPredicate inp = MyIntNum::isFactor;
		result = inp.test(myNum, 3);
		if (result) System.out.println("3 is a factor of " + myNum.getNum());
		// 3 is a factor of 12
		result = inp.test(myNum2, 3);
		if (!result) System.out.println("3 is not a factor of " + myNum2.getNum());
		// 3 is not a factor of 16
	}
}

class MyGenericReference {
	interface SomeTest<T> {
		boolean test(T n, T m);
	}

	static <T> boolean myGenMeth(T x, T y) {
		boolean result = false;
		return x.equals(y);
	}

	static void main() {
		SomeTest<Integer> mRef = MyGenericReference::<Integer>myGenMeth;
		System.out.println(mRef.test(12, 12)); // true
		System.out.println(mRef.test(12, 13)); // false
	}
}

// Demonstrate a Constructor reference.
class ConstructorReferences {
	interface MyFunc {
		ConstructorReferences func(String s);
	}

	private String str;
	ConstructorReferences(String s) {
		str = s;
	}

	// Default constructor
	ConstructorReferences() {
		str = "";
	}

	String getStr() {
		return str;
	}

	static void demo() {
		MyFunc myClassCons = ConstructorReferences::new;
		ConstructorReferences mc = myClassCons.func("Testing");
		System.out.println("str in mc is " + mc.getStr());
		// str in mc is Testing
	}
}


class UsePredicateInterface {
	public static void demo() {
		Predicate<Integer> isEven = (n) -> (n%2) == 0;
		if (isEven.test(4)) System.out.println("4 is even");
		if (!isEven.test(5)) System.out.println("5 is odd");
		// 4 is even
		// 5 is odd
	}
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

	public static void genericFunctionalInterfaceDemo() {
		SomeTest<Integer> isFactor = (n,d) -> (n%d) == 0;
		if (isFactor.test(10,2)) {
			System.out.println("2 is a factor of 10");
		}
		// 2 is a factor of 10

		SomeTest<Double> isFactorD = (n,d) -> (n%d) == 0;
		if (isFactorD.test(212.0,4.0)) {
			System.out.println("4.0 is a factor of 212.0");
		}
		// 4.0 is a factor of 212.0

		SomeTest<String> isIn = (a,b) -> a.indexOf(b) != -1;
		String str = "Generic Functional Interface";
		System.out.println("Testing string: " + str);
		if (isIn.test(str, "face")) {
			System.out.println("'face' is found.");
		} else {
			System.out.println("'face' not found.");
		}
		// Testing string: Generic Functional Interface
		// 'face' is found.
	}

	static void varCapture() {
		int num = 10; // A local variable that can be captured.
		MyFunc myLambda = (n) -> {
			// This use of num is OK.  It does not modify num.
			int v = num + n;
			// However, the following is illegal because it attempts to modify the value of num.

			/** local variables referenced from a lambda expression must be final or effectively final
			num++; */

			return v;
		};
		System.out.println(myLambda.func(8));

		/** local variables referenced from a lambda expression must be final or effectively final
		num = 9; */
	}

	static void lambdaExceptionDemo() throws Exception {
		// This block lambda could throw an IOException.  Thus, IOException must be specified in a
		// throws clase of ioAction() in MyIOAction.
		MyIOAction myIO = (rdr) -> {
			int ch = rdr.read(); // could throw IOException
			// ...
			return true;
		};
		System.out.println(myIO.ioAction(new InputStreamReader(System.in)));
	}

	static void transformDemo() {
		MyTransform<Double> sqrts = (v) -> {
			for (int i=0; i<v.length; i++) {
				v[i] = Math.sqrt(v[i]);
			}
		};
		Double doubles[] = {1.2, 4.3, 9.5, 12.4};
		sqrts.transform(doubles);
		System.out.println(Arrays.toString(doubles));
		// [1.0954451150103321, 2.073644135332772, 3.082207001484488, 3.521363372331802]
	}

	public static void main(String[] args) throws Exception {
		lambdaDemo();
		lambdaDemo2();
		lambdaDemo3();
		blockLambdaDemo();
		genericFunctionalInterfaceDemo();
		varCapture();
		// lambdaExceptionDemo();
		transformDemo();
		MyIntPredicates.demo();
		MyIntNum.demo();
		MyIntNum.demo2();
		MyGenericReference.main();
		ConstructorReferences.demo();
		UsePredicateInterface.demo();
	}
}