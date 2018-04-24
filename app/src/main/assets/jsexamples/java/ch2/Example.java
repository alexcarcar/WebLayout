class Example {

	// Compute the number of cubic inches in 1 cubic mile. (p 36)
	static void cubicInchesInCubicMile() {
		long ci;
		long im;
		im = 5280 * 12;
		ci = im * im * im;
		System.out.println("There are "+ci+" cubic inches in cubic mile.");
		// There are 254358061056000 cubic inches in cubic mile.
	}

	// Use the Pythagorian theorem to find the length of the hypotenuse. (p 37)
	static void calculateHypotenuse() {
		double x, y, z;
		x=3;
		y=4;
		z=Math.sqrt(x*x + y*y);
		System.out.println("Hypotenuse is "+z);
		// Hypotenuse is 5.0
	}

	// Character variables can be handled like integers. (p 38)
	static void charArithDemo() {
		char ch;
		ch = 'X';
		System.out.println("ch contains "+ch);
		ch++;
		System.out.println("ch is now "+ch);
		ch=90; // give ch the value Z
		System.out.println("ch is now "+ch);
		// ch contains X
		// ch is now Y
		// ch is now Z
	}

	// Demonstrates boolean values. (p 39)
	static void boolDemo() {
		boolean b;
		b=false;
		System.out.println("b is "+b);
		b=true;
		System.out.println("b is "+b);
		if (b) System.out.println("This is executed");
		b=false;
		if (b) System.out.println("This is not executed");
		System.out.println("10>9 is " + (10>9));
		// b is false
		// b is true
		// This is executed
		// 10>9 is true
	}

	// Demonstrates escape sequences in strings. (p 43)
	static void strDemo() {
		System.out.println("First line\nSecond line");
		System.out.println("A\tB\tC");
		System.out.println("D\tE\tF");
		// First line
		// Second line
		// A       B       C
		// D       E       F
	}

	// Demonstrate dynamic initialization. (p 45)
	static void dynInit() {
		double radius = 4, height = 5;
		// dynamically initialize volume
		double volume = Math.PI * radius * radius * height;
		System.out.println("Volume of cylinder is "+volume);
		// Volume of cylinder is 251.32741228718345
	}

	// Demonstrates block scope. (p 46)
	static void scopeDemo() {
		int x;
		x = 10;
		if (x==10) {
			int y = 20;
			System.out.println("x and y: "+x+" "+y);
			x = y * 2;
		}
		// y = 100; // Error! y not known here
		// x is still known here.
		System.out.println("x is "+x);
		// x and y: 10 20
		// x is 40
	}

	// Demonstrate lifetime of a variable. (p 46)
	static  void varInitDemo() {
		int x;
		for (x=0; x<3; x++) {
			int y=-1; // y is initialized each time block is entered
			System.out.println("y is: "+y); // this always prints -1
			y = 100;
			System.out.println("y is now: "+y);
		}
		// y is: -1
		// y is now: 100
		// y is: -1
		// y is now: 100
		// y is: -1
		// y is now: 100
	}

	// Demonstrate the % operator.
	static void modDemo() {
		int iresult, irem;
		double dresult, drem;
		iresult = 10/3;
		irem = 10%3;
		dresult = 10.0/3.0;
		drem = 10.0%3.0;
		System.out.println("Result and remainder of 10/3: "+iresult+" "+irem);
		System.out.println("Result and remainder of 10.0/3.0: "+dresult+" "+drem);
		// Result and remainder of 10/3: 3 1
		// Result and remainder of 10.0/3.0: 3.3333333333333335 1.0
	}

	// Demonstrate the relational and logical operators.
	static void relLogOps() {
		int i, j;
		boolean b1, b2;
		i = 10;
		j = 11;
		if (i<j) System.out.println("i < j");
		if (i<=j) System.out.println("i <= j");
		if (i!=j) System.out.println("i != j");
		if (i==j) System.out.println("This won't execute");
		if (i>=j) System.out.println("This won't execute");
		if (i>j) System.out.println("This won't execute");
		b1 = true;
		b2 = false;
		if (b1&b2) System.out.println("This won't execute");
		if (!(b1&b2)) System.out.println("!(b1 & b2) is true");
		if (b1 | b2) System.out.println("b1 | b2 is true");
		if (b1 ^ b2) System.out.println("b1 ^ b2 is true");
		// i < j
		// i <= j
		// i != j
		// !(b1 &b2) is true
		// b1 | b2 is true
		// b1 ^ b2 is true
	}

	// Demonstrate the short-circuit operators.
	static void sCops() {
		int n, d, q;
		n=10;
		d=2;
		if (d!=0 && (n%d)==0) {
			System.out.println(d+" is a factor of "+n);
		}
		if (d!=0 & (n%d) ==0) { // allows division by zero to occur
			System.out.println(d+" is a factor of "+n);
		}
	}

	// Side effects can be important.
	static void sideEffects() {
		int i=0;
		// Here, i is still incremented even though the if statement fails.
		if(false & (++i<100)) System.out.println("this won't be displayed");
		System.out.println("if statement executed: "+i); // displays 1

		// In this case, i is not incremented because the short-circuit
		// operator skips the increment.
		if(false && (++i<100)) System.out.println("this won't be displayed");
		System.out.println("if statement executed: "+i); // still 1 !!
		// if statement executed: 1
		// if statement executed: 1
	}

	// A promotion surprise!
	static void promoDemo() {
		int b;
		int i;

		b=10;
		i=b*b; // OK, no cast needed

		b=10;
		b=(byte)(b*b); // cast needed!!
		System.out.println("i and b: " +i+ " " +b); 
		// i and b: 100 100
	}

	// Using a cast.
	static void useCast() {
		int i;
		for (i=0; i<5; i++) {
			System.out.println(i+" / 3: "+i/3);
			System.out.println(i+" / 3 with fractions: "+(double)i/3);
			System.out.println();
		}
		// 0 / 3: 0
		// 0 / 3 with fractions: 0.0

		// 1 / 3: 0
		// 1 / 3 with fractions: 0.3333333333333333

		// 2 / 3: 0
		// 2 / 3 with fractions: 0.6666666666666666

		// 3 / 3: 1
		// 3 / 3 with fractions: 1.0

		// 4 / 3: 1
		// 4 / 3 with fractions: 1.3333333333333333
	}

	public static void main(String[] args) {
		// Java's Primitive Types
		cubicInchesInCubicMile(); // Integers: byte, short, int, long
		calculateHypotenuse(); // Floating-Point Types: float, double
		charArithDemo(); // Characters: char
		boolDemo(); // The Boolean Type: boolean

		long c = 299_792_458;
		System.out.println(c); // 299792458

		int hex = 0xFF;
		System.out.println(hex + " in decimal"); // 255 in decimal
		int oct = 011;
		System.out.println(oct + " in decimal"); // 9 in decimal

		strDemo(); dynInit(); scopeDemo(); varInitDemo();
		modDemo(); relLogOps(); sCops(); sideEffects();
		promoDemo(); useCast();
	}
}