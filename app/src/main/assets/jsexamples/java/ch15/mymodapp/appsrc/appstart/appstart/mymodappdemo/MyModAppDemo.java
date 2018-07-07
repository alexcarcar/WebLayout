// Demonstrate a simple module-based application.
package appstart.mymodappdemo; // Notice the package declaration

import appfuncs.simplefuncs.SimpleMathFuncs; // Notice the import statment

class MyModAppDemo {
	public static void main(String[] args) {
		if (SimpleMathFuncs.isFactor(2, 10))
			System.out.println("2 is a factor of 10");
		System.out.println("lcf(35, 105) is ", SimpleMathFuncs.lcf(35, 105));
		System.out.println("gcf(35, 105) is ", SimpleMathFuncs.gcf(35, 105));
	}	
}