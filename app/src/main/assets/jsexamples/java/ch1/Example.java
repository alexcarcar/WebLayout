class Example {
	public static void main(String[] args) {
		System.out.println("Java drives the web."); // Java drives the web.

		int var1;
		int var2;
		var1 = 1024;
		System.out.println("var1 contains "+var1); // var1 contains var1

		var2 = var1/2;
		System.out.print("var2 contains var1 / 2: ");
		System.out.println(var2); // var2 contains var1 / 2: 512

		int var;
		double x;
		var = 10;
		x = 10.0;

		System.out.println("Original value of var: " + var);
		System.out.println("Original value of x: " + x);
		System.out.println();
		// Original value of var: 10
		// Original value of x: 10.0
		//
		var = var / 4;
		x = x / 4;
		System.out.println("var after division: " + var);
		System.out.println("x after division: " + x);
		// var after division: 2
		// x after division: 2.5

		// === Converting Gallons to Liters (p 21)
		double gallons = 10;
		double liters = gallons*3.7854;
		System.out.println(gallons + " gallons is " + liters + " liters.");
		// 10.0 gallons is 37.854 liters.

		// === The if Statement (p 23)
		int a, b, c;
		a = 2;
		b = 3;
		if (a<b) System.out.println("a is less than b");
		c = a - b;
		if (c>=0) System.out.println("c is non-negative");
		if (c<0) System.out.println("c is negative");
		// a is less than b
		// c is negative

		// === The for Loop (p 24)
		int count;
		for (count=0; count<5; count=count+1)
			System.out.println("This is count: " + count);
		System.out.println("Done!");
		// This is count: 0
		// This is count: 1
		// This is count: 2
		// This is count: 3
		// This is count: 4
		// Done!
	}
}