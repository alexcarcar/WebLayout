class Vehicle {
    int passengers;
    int fuelcap;
    int mpg;

    Vehicle() {
    }

    // This is a constructor for Vehicle. (p 129)
    Vehicle(int p, int f, int m) {
    	passengers = p;
    	fuelcap = f;
    	mpg = m;
    }

    // Display the range. (p 113)
    void printRange() {
        System.out.println("Range is " + range());
    }

    // Use a return value. (p 116)
    int range() {
        return mpg * fuelcap;
    }

    // Add a paramaterized method that computes the fuel for a distance
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }
}

// A simple example that uses a parameter. (p 118)
class ChkNum {
    // return true if x is even
    boolean isEven(int x) {
        if ((x % 2) == 0) return true;
        else return false;
    }
}

class Factor {
    boolean isFactor(int a, int b) {
        if ((b % a) == 0) return true;
        return false;
    }
}

// A simple constructor. (p 127)
class MyClass {
	int x;

	MyClass() {
		x = 10;
	}

	// A parameterized constructor. (p 128)
	MyClass(int i) {
		x = i;
	}
}

class Pwr {
	double b;
	int e;
	double val;

	Pwr(double base, int exp) {
		b = base;
		e = exp;
		val = 1;
		if(exp==0) return;
		for(;exp>0;exp--) val *= base;
	}

	double get_pwr() {
		return val;
	}
}

public class Example {

    // Declares an object of type Vehicle. (p 109)
    static void vehicleDemo() {
        Vehicle minivan = new Vehicle();
        int range;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        range = minivan.fuelcap * minivan.mpg;
        System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range + " miles.");
        // Minivan can carry 7 with a range of 336 miles.
    }

    // Declares two vehicle objects. (p 110)
    static void twoVehicles() {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        int range1, range2;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        range1 = minivan.fuelcap * minivan.mpg;
        range2 = sportscar.fuelcap * sportscar.mpg;
        System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range1 + " miles.");
        System.out.println("Sportscar can carry " + sportscar.passengers + " with a range of " + range2 + " miles.");
        // Minivan can carry 7 with a range of 336 miles.
        // Sportscar can carry 2 with a range of 168 miles.
    }

    // Add range to Vehicle. (p 113)
    static void addMeth() {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        int range1, range2;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        System.out.println("Minivan can carry " + minivan.passengers + ".");
        minivan.printRange();
        System.out.println("Sportscar can carry " + sportscar.passengers + ".");
        sportscar.printRange();
        // Minivan can carry 7.
        // Range is 336
        // Sportscar can carry 2.
        // Range is 168
    }

    static void retMeth() {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        int range1, range2;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        range1 = minivan.range();
        range2 = sportscar.range();
        System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range1 + " miles.");
        System.out.println("Sportscar can carry " + sportscar.passengers + " with a range of " + range2 + " miles.");
        // Minivan can carry 7 with a range of 336 miles.
        // Sportscar can carry 2 with a range of 168 miles.
    }

    static void parmDemo() {
        ChkNum e = new ChkNum();
        if (e.isEven(10)) System.out.println("10 is even.");
        if (e.isEven(9)) System.out.println("9 is even.");
        if (e.isEven(8)) System.out.println("8 is even.");
        // 10 is even.
        // 8 is even.
    }

    static void isFact() {
        Factor x = new Factor();
        if (x.isFactor(2, 20)) System.out.println("2 is a factor");
        if (x.isFactor(3, 20)) System.out.println("this won't be displayed");
        // 2 is a factor
    }

    // Compute fuel needed for a given distance. (p 120)
    static void compFuel() {
        Vehicle minivan = new Vehicle();
        Vehicle sportscar = new Vehicle();
        double gallons;
        int dist = 252;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        sportscar.passengers = 2;
        sportscar.fuelcap = 14;
        sportscar.mpg = 12;

        gallons = minivan.fuelneeded(dist);
        System.out.println("To go " + dist + " miles minivan needs " + gallons + " gallons of fuel.");
        gallons = sportscar.fuelneeded(dist);
        System.out.println("To go " + dist + " miles sportscar needs " + gallons + " gallons of fuel.");
        // To go 252 miles minivan needs 12.0 gallons of fuel.
        // To go 252 miles sportscar needs 21.0 gallons of fuel.
    }

    // Constructor demo. (p 127)
    static void consDemo() {
    	MyClass t1 = new MyClass();
    	MyClass t2 = new MyClass();
    	System.out.println(t1.x + " " + t2.x);
    	// 10 10
    }

	// A parameterized constructor demo. (p 128)
    static void parmConsDemo() {
    	MyClass t1 = new MyClass();
    	MyClass t2 = new MyClass(88);
    	System.out.println(t1.x + " " + t2.x);
    	// 10 88
    }

    // A constructor for Vehicle. (p 129)
    static void vehConsDemo() {
    	Vehicle minivan = new Vehicle(7, 16, 21);
    	Vehicle sportscar = new Vehicle(2, 14, 12);
    	double gallons;
    	int dist = 252;
    	gallons = minivan.fuelneeded(dist);
    	System.out.println("To go "+dist+" mi minivan needs "+gallons+" gals.");
    	gallons = sportscar.fuelneeded(dist);
    	System.out.println("To go "+dist+" mi sportscar needs "+gallons+" gals.");
		// To go 252 mi minivan needs 12.0 gals.
		// To go 252 mi sportscar needs 21.0 gals.
    }

    static void demoPwr() {
    	Pwr x = new Pwr(4.0, 2);
    	Pwr y = new Pwr(2.5, 1);
    	Pwr z = new Pwr(5.7, 0);
    	System.out.println(x.b+" raised to the "+x.e+" power is "+x.get_pwr());
    	System.out.println(y.b+" raised to the "+y.e+" power is "+y.get_pwr());
    	System.out.println(z.b+" raised to the "+z.e+" power is "+z.get_pwr());
		// 4.0 raised to the 2 power is 16.0
		// 2.5 raised to the 1 power is 2.5
		// 5.7 raised to the 0 power is 1.0
    }

    public static void main(String[] args) {
        vehicleDemo();
        twoVehicles();
        addMeth();
        retMeth();
        parmDemo();
        isFact();
        compFuel();
        consDemo();
        parmConsDemo();
        vehConsDemo();
        demoPwr();
    }
}
