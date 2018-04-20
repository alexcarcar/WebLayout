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

		// == Blocks of Code (p 26)
		double i, j, d;
		i=5;
		j=10;
		if (i!=0) {
			System.out.println("i does not equal to zero");
			d = j/i;
			System.out.println("j / i is " + d);
		}
		// i does not equal to zero
		// j / i is 2.0

		// == Improving Gallons to Liters (p 28)
		int counter = 0;
		for (gallons=1; gallons<=100; gallons++) {
			liters = gallons*3.7854;
			System.out.println(gallons+" gallons is "+liters+" liters.");
			counter++;
			if(counter==10) {
				System.out.println();
				counter=0;
			}
		}

		// 1.0 gallons is 3.7854 liters.
		// 2.0 gallons is 7.5708 liters.
		// 3.0 gallons is 11.356200000000001 liters.
		// 4.0 gallons is 15.1416 liters.
		// 5.0 gallons is 18.927 liters.
		// 6.0 gallons is 22.712400000000002 liters.
		// 7.0 gallons is 26.4978 liters.
		// 8.0 gallons is 30.2832 liters.
		// 9.0 gallons is 34.0686 liters.
		// 10.0 gallons is 37.854 liters.

		// 11.0 gallons is 41.6394 liters.
		// 12.0 gallons is 45.424800000000005 liters.
		// 13.0 gallons is 49.2102 liters.
		// 14.0 gallons is 52.9956 liters.
		// 15.0 gallons is 56.781 liters.
		// 16.0 gallons is 60.5664 liters.
		// 17.0 gallons is 64.3518 liters.
		// 18.0 gallons is 68.1372 liters.
		// 19.0 gallons is 71.9226 liters.
		// 20.0 gallons is 75.708 liters.

		// 21.0 gallons is 79.49340000000001 liters.
		// 22.0 gallons is 83.2788 liters.
		// 23.0 gallons is 87.0642 liters.
		// 24.0 gallons is 90.84960000000001 liters.
		// 25.0 gallons is 94.635 liters.
		// 26.0 gallons is 98.4204 liters.
		// 27.0 gallons is 102.2058 liters.
		// 28.0 gallons is 105.9912 liters.
		// 29.0 gallons is 109.7766 liters.
		// 30.0 gallons is 113.562 liters.

		// 31.0 gallons is 117.34740000000001 liters.
		// 32.0 gallons is 121.1328 liters.
		// 33.0 gallons is 124.9182 liters.
		// 34.0 gallons is 128.7036 liters.
		// 35.0 gallons is 132.489 liters.
		// 36.0 gallons is 136.2744 liters.
		// 37.0 gallons is 140.0598 liters.
		// 38.0 gallons is 143.8452 liters.
		// 39.0 gallons is 147.63060000000002 liters.
		// 40.0 gallons is 151.416 liters.

		// 41.0 gallons is 155.2014 liters.
		// 42.0 gallons is 158.98680000000002 liters.
		// 43.0 gallons is 162.7722 liters.
		// 44.0 gallons is 166.5576 liters.
		// 45.0 gallons is 170.34300000000002 liters.
		// 46.0 gallons is 174.1284 liters.
		// 47.0 gallons is 177.9138 liters.
		// 48.0 gallons is 181.69920000000002 liters.
		// 49.0 gallons is 185.4846 liters.
		// 50.0 gallons is 189.27 liters.

		// 51.0 gallons is 193.0554 liters.
		// 52.0 gallons is 196.8408 liters.
		// 53.0 gallons is 200.6262 liters.
		// 54.0 gallons is 204.4116 liters.
		// 55.0 gallons is 208.197 liters.
		// 56.0 gallons is 211.9824 liters.
		// 57.0 gallons is 215.7678 liters.
		// 58.0 gallons is 219.5532 liters.
		// 59.0 gallons is 223.3386 liters.
		// 60.0 gallons is 227.124 liters.

		// 61.0 gallons is 230.9094 liters.
		// 62.0 gallons is 234.69480000000001 liters.
		// 63.0 gallons is 238.4802 liters.
		// 64.0 gallons is 242.2656 liters.
		// 65.0 gallons is 246.05100000000002 liters.
		// 66.0 gallons is 249.8364 liters.
		// 67.0 gallons is 253.6218 liters.
		// 68.0 gallons is 257.4072 liters.
		// 69.0 gallons is 261.1926 liters.
		// 70.0 gallons is 264.978 liters.

		// 71.0 gallons is 268.7634 liters.
		// 72.0 gallons is 272.5488 liters.
		// 73.0 gallons is 276.3342 liters.
		// 74.0 gallons is 280.1196 liters.
		// 75.0 gallons is 283.90500000000003 liters.
		// 76.0 gallons is 287.6904 liters.
		// 77.0 gallons is 291.4758 liters.
		// 78.0 gallons is 295.26120000000003 liters.
		// 79.0 gallons is 299.0466 liters.
		// 80.0 gallons is 302.832 liters.

		// 81.0 gallons is 306.61740000000003 liters.
		// 82.0 gallons is 310.4028 liters.
		// 83.0 gallons is 314.1882 liters.
		// 84.0 gallons is 317.97360000000003 liters.
		// 85.0 gallons is 321.759 liters.
		// 86.0 gallons is 325.5444 liters.
		// 87.0 gallons is 329.32980000000003 liters.
		// 88.0 gallons is 333.1152 liters.
		// 89.0 gallons is 336.9006 liters.
		// 90.0 gallons is 340.68600000000004 liters.

		// 91.0 gallons is 344.4714 liters.
		// 92.0 gallons is 348.2568 liters.
		// 93.0 gallons is 352.04220000000004 liters.
		// 94.0 gallons is 355.8276 liters.
		// 95.0 gallons is 359.613 liters.
		// 96.0 gallons is 363.39840000000004 liters.
		// 97.0 gallons is 367.1838 liters.
		// 98.0 gallons is 370.9692 liters.
		// 99.0 gallons is 374.7546 liters.
		// 100.0 gallons is 378.54 liters.
	}
}