// A simple generic class.  Here, T is a type parameter that will be replaced by a
// real type when an object of type Gen is created.
//

class Gen<T> { // Declare a generic class.  T is the generic type parameter.
	T ob; // declare an object of type T

	// Pass the constructor a reference to an object of type T.
	Gen(T o) {
		ob = o;
	}

	// Return ob.
	T getob() {
		return ob;
	}

	// Show type of T.
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}

	public static void demo() {
		// Create a Gen reference for Integers.
		Gen<Integer> iOb = new Gen<>(88);
		iOb.showType();
		int v = iOb.getob();
		System.out.println("value: " + v);
		System.out.println();
		// Type of T is java.lang.Integer
		// value: 88

		// Create a Gen object for Strings.
		Gen<String> strOb = new Gen<>("Generics Test");
		strOb.showType();
		String str = strOb.getob();
		System.out.println("value: " + str);
		// Type of T is java.lang.String
		// value: Generics Test
	}
}

// A simple generic class with two type parameters: T and V. (p 452)
class TwoGen<T, V> {
	T ob1;
	V ob2;

	TwoGen(T o1, V o2) {
		ob1 = o1;
		ob2 = o2;
	}

	void showTypes() {
		System.out.println("Type of T is " + ob1.getClass().getName());
		System.out.println("Type of V is " + ob2.getClass().getName());
	}

	T getob1() {
		return ob1;
	}

	V getob2() {
		return ob2;
	}

	public static void demo() {
		TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics");
		tgObj.showTypes();
		// Type of T is java.lang.Integer
		// Type of V is java.lang.String

		int v = tgObj.getob1();
		System.out.println("value: " + v);
		// value: 88

		String str = tgObj.getob2();
		System.out.println("value: " + str);
		// value: Generics

		TwoGen<String, String> stringsObj = new TwoGen<>("Red", "Balloon");
		stringsObj.showTypes();
		// Type of T is java.lang.String
		// Type of V is java.lang.String

		System.out.println("values: " + stringsObj.getob1() + " " + stringsObj.getob2());
		// values: Red Balloon
	}
}

class NumericFns<T extends Number> {
	T num;

	NumericFns(T n) {
		num = n;
	}

	double reciprocal() {
		return 1/num.doubleValue();
	}

	double fraction() {
		return num.doubleValue() - num.intValue();
	}

	boolean absEqual(NumericFns<?> ob) {
		if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) {
			return true;
		}
		return false;
	}

	public static void demo() {
		NumericFns<Integer> iOb = new NumericFns<>(5);
		System.out.println("Reciprocal of iOb is " + iOb.reciprocal());
		System.out.println("Fractional component of iOb is " + iOb.fraction());
		// Reciprocal of iOb is 0.2
		// Fractional component of iOb is 0.0

		NumericFns<Double> dOb = new NumericFns<>(5.25);
		System.out.println("Reciprocal of dOb is " + dOb.reciprocal());
		System.out.println("Fractional component of dOb is " + dOb.fraction());
		// Reciprocal of dOb is 0.19047619047619047
		// Fractional component of dOb is 0.25

		// NumericFns<String> sOb = new NumericFns<>("Test");
		// inferred type does not conform to upper bound(s)
	}

	public static void wildCardDemo() {
		NumericFns<Integer> iOb = new NumericFns<>(6);
		NumericFns<Double> dOb = new NumericFns<>(-6.0);
		NumericFns<Long> lOb = new NumericFns<>(5L);

		System.out.println("Testing iOb and dOb: " + iOb.absEqual(dOb)); // true
		System.out.println("Testing iOb and lOb: " + iOb.absEqual(lOb)); // false
	}
}


// Bounded Wildcards (p 460)
class A {}
class B extends A {}
class C extends A {}
 // Note D does NOT extend A.
class D {
	// Uses a bounded wild card
	static void test(Gen<? extends A> o) {
		System.out.println("Testing OK: " + o.getClass().getName() + o.ob.getClass().getName());
	}

	static void useBoundedWildcard() {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();

		Gen<A> w = new Gen<>(a);
		Gen<B> w2 = new Gen<>(b);
		Gen<C> w3 = new Gen<>(c);
		Gen<D> w4 = new Gen<>(d);

		test(w);
		test(w2);
		test(w3);
		// Testing OK: GenA
		// Testing OK: GenB
		// Testing OK: GenC

		// test(w4); // Error because w4 is not a subclass of A
	}
}

// Demonstrate a simple generic method.
class GenericMethodDemo {
	// Determine if the contents of two arrays are the same.
	// A generic method.
	static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
		if (x.length != y.length) return false;
		for (int i=0; i<x.length; i++) {
			if(!x[i].equals(y[i])) return false;
		}
		return true;
	}

	public static void demo() {
		Integer nums[] = {1, 2, 3, 4, 5};
		Integer nums2[] = {1, 2, 3, 4, 5};
		Integer nums3[] = {1, 2, 7, 4, 5};
		Integer nums4[] = {1, 2, 7, 4, 5, 6};

		if (arraysEqual(nums, nums)) System.out.println("nums equals nums");
		if (arraysEqual(nums, nums2)) System.out.println("nums equals nums2");
		if (arraysEqual(nums, nums3)) System.out.println("nums equals nums3");
		if (arraysEqual(nums, nums4)) System.out.println("nums equals nums4");
		// nums equals nums
		// nums equals nums2

		Double dVals[] = {1.1, 2.2, 3.3, 4.4, 5.5};
		// if (arraysEqual(nums, dVals)) System.out.println("nums equals dVals");
		// -- won't compile because nums and dvals are not of the same type.
	}
}

// Use a generic constructor.
class Summation {
	private int sum;

	<T extends Number> Summation(T arg) {
		sum = 0;
		for (int i=0; i<= arg.intValue(); i++)
			sum += i;
	}

	int getSum() {
		return sum;
	}

	public static void demo() {
		Summation ob = new Summation(4.0); // 1+2+3+4 = 10
		System.out.println("Summation of 4.0 is " + ob.getSum());
		// Summation of 4.0 is 10
	}
}

// A generic interface example.  A generic containment interface.  This interface implies that
// an implementing class contains one or more values.
interface Containment<T> {
	// The contains() method tests if a specific item is contained within an object that
	// implements Containment.
	boolean contains(T o);
}

// Implement Containment using an array to hold values.
class MyClass<T> implements Containment<T> {
	T[] arrayRef;

	MyClass(T[] o) {
		arrayRef = o;
	}

	// Implement contains()
	public boolean contains(T o) {
		for (T x : arrayRef) {
			if(x.equals(o)) return true;
		}
		return false;
	}

	public static void demo() {
		Integer x[] = {1, 2, 3};
		MyClass<Integer> ob = new MyClass<>(x);
		System.out.println("2 is " + (ob.contains(2)?"":"NOT") + " in ob");
		System.out.println("5 is " + (ob.contains(5)?"":"NOT") + " in ob");
		// 2 is  in ob
		// 5 is NOT in ob

		// *** if (ob.contains(9.25)) System.out.println("Will not compile");
		// Example.java:257: error: incompatible types: double cannot be converted to Integer
	}
	
	}

// Demonstrate a raw type. (p 473)
class GenRaw<T> {
	T ob;
	GenRaw(T o) {
		ob = o;
	}

	T getob() {
		return ob;
	}

	public static void demo() {
		GenRaw<Integer> iOb = new GenRaw<Integer>(88);
		GenRaw<String> strOb = new GenRaw<String>("Generics Test");
		// When no type argument is supplied, a raw type is created.
		GenRaw raw = new GenRaw(98.6);
		double d = (Double) raw.getob();
		System.out.println("value: "+d); // value: 98.6
		strOb = raw;
		raw = iOb; // 88
		System.out.println(raw.getob());
		// System.out.println(strOb.getob());
		// Exception in thread "main" java.lang.ClassCastException: java.lang.Double cannot
 		// be cast to java.lang.String
	}
}

class Example {
	public static void main(String[] args) {
		Gen.demo();
		TwoGen.demo();
		NumericFns.demo();
		NumericFns.wildCardDemo();
		D.useBoundedWildcard();
		GenericMethodDemo.demo();
		Summation.demo();
		MyClass.demo();
		GenRaw.demo();
	}
}