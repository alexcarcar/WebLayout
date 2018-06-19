// Using static imports (p 438)
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

// Autoboxing/unboxing takes place with method parameters and return values
class AutoBox {
    // This method has an Integer parameter.
    static void m(Integer v) { // Recieves an integer
        System.out.println("m() received " + v);
    }

    // This method returns an int.
    static int m2() {
        return 10;
    }

    // This method returns an Integer.
    static Integer m3() {
        return 99; // autoboxing 99 into an Integer.
    }

    public static void run() {
        // Pass an int to m().  Because m() has an Integer parameter, the int value passed is
        // automatically boxed.
        m(199);

        // Here, iOb receives the int value returned by m2().  This value is automatically boxed
        // so that it can be assigned to iOb.
        Integer iOb = m2();
        System.out.println("Return value from m2() is " + iOb);

        // Next, m3() is called.  It returns an Integer value which is auto-unboxed into an int.
        int i = m3();
        System.out.println("Return value from m3() is " + i);

        // Next, Math.sqrt() is called with iOb as an argument.  In this case, iOb is auto-unboxed
        // and its value promoted to double, which is the type needed by sqrt().
        iOb = 100;
        System.out.println("Square root of iOb is " + Math.sqrt(iOb));
    }
    // m() received 199
    // Return value from m2() is 10
    // Return value from m3() is 99
    // Square root of iOb is 10.0
}

class Example {
    // An enumeration of Transport varieties.
    // Use an enum constructor, instance variable, and method.
    enum Transport {
        CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);
        private int speed;

        Transport(int s) {
            speed = s;
        }

        int getSpeed() {
            return speed;
        }
    }

    static void enumDemo() {
        Transport tp;
        tp = Transport.AIRPLANE;
        System.out.println("Value of tp: " + tp + "\n");
        tp = Transport.TRAIN;
        if (tp == Transport.TRAIN)
            System.out.println("tp contains TRAIN.\n");
        switch (tp) {
            case CAR:
                System.out.println("A car carries people");
                break;
            case TRUCK:
                System.out.println("A truck carries freight");
                break;
            case AIRPLANE:
                System.out.println("An airplane flies.");
                break;
            case TRAIN:
                System.out.println("A train runs on rails.");
                break;
            case BOAT:
                System.out.println("A boat sails on water.");
                break;

            // Value of tp: AIRPLANE

            // tp contains TRAIN.

            // A train runs on rails.
        }
    }

    // Use the built-in enumeration methods.
    static void enumDemo2() {
        Transport tp;
        System.out.println("Here are all Transport constants.");

        // use values()
        Transport allTransports[] = Transport.values();
        for (Transport t : allTransports) {
            System.out.println(t);
        }
        System.out.println();

        // use valueOf()
        tp = Transport.valueOf("AIRPLANE");
        System.out.println("tp contains " + tp);

        // Here are all Transport constants.
        // CAR
        // TRUCK
        // AIRPLANE
        // TRAIN
        // BOAT

        // tp contains AIRPLANE
    }

    static void enumDemo3() {
        Transport tp;
        System.out.println("Typical speed for an airplane is " + Transport.AIRPLANE.getSpeed() + " mph.");
        System.out.println("All Transport speeds: ");
        for (Transport t : Transport.values()) {
            System.out.println(t + " typical speed is " + t.getSpeed() + " mph.");
        }
        // Typical speed for an airplane is 600 mph.
        // All Transport speeds:
        // CAR typical speed is 65 mph.
        // TRUCK typical speed is 55 mph.
        // AIRPLANE typical speed is 600 mph.
        // TRAIN typical speed is 70 mph.
        // BOAT typical speed is 22 mph.
    }

    // Demonstrate ordinal() and compareTo().
    static void enumDemo4() {
        Transport tp, tp2, tp3;
        System.out.println("Here are all Transport constants and their ordinal values:");
        for (Transport t : Transport.values()) {
            System.out.println(t + " " + t.ordinal());
        }

        tp = Transport.AIRPLANE;
        tp2 = Transport.TRAIN;
        tp3 = Transport.AIRPLANE;

        System.out.println();

        if (tp.compareTo(tp2) < 0)
            System.out.println(tp + " comes before " + tp2);

        if (tp.compareTo(tp2) > 0)
            System.out.println(tp2 + " comes before " + tp);

        if (tp.compareTo(tp3) == 0)
            System.out.println(tp + " equals " + tp3);

        // AIRPLANE comes before TRAIN
        // AIRPLANE equals AIRPLANE
    }

    static void autoBox() {
        Integer iOb = 100; // autobox an int
        int i = iOb; // auto-unbox
        System.out.println(i + " " + iOb); // 100 100
    }

    static void autoBox3() {
        // Autoboxing/unboxing occurs inside expressions.
        Integer iOb, iOb2;
        int i;

        iOb = 99;
        System.out.println("Original value of iOb: " + iOb); // 99

        // The following automatically unboxes iOb, performs the increment, and then reboxes
        // the result back into iOb.
        ++iOb;
        System.out.println("After ++iOb: " + iOb); // 100

        // Here, iOb is unboxed, its value is increased by 10, and the result is boxed and stored
        // back in iOb.
        iOb += 10;
        System.out.println("After iOb += 10: " + iOb); // 110

        // Here, iOb is unboxed, the expression is evaluated, and the result is reboxed and
        // assigned to iOb2;
        iOb2 = iOb + (iOb / 3);
        System.out.println("iOb2 after expression: " + iOb2); // 146

        // The same expression is evaluated, but the resultj is not reboxed
        i = iOb + (iOb / 3);
        System.out.println("i after expression: " + i); // 146
    }

    static void quadratic() {
    	double a, b, c, x1, x2;
    	// solve 4x^2 + x - 3 = 0, for x
    	a = 4;
    	b = 1;
    	c = -3;
    	x1 = (-b+Math.sqrt(Math.pow(b,2)-4*a*c)) / (2*a);
    	x2 = (-b-Math.sqrt(Math.pow(b,2)-4*a*c)) / (2*a);
    	System.out.println("Solutions: " + x1 + " " + x2);
    	// Solutions: 0.75 -1.0
    }

    static void staticQuadratic() {
    	double a, b, c, x1, x2;
    	// solve 4x^2 + x - 3 = 0, for x
    	a = 4;
    	b = 1;
    	c = -3;
    	x1 = (-b+sqrt(pow(b,2)-4*a*c)) / (2*a);
    	x2 = (-b-sqrt(pow(b,2)-4*a*c)) / (2*a);
    	System.out.println("Solutions: " + x1 + " " + x2);
    	// Solutions: 0.75 -1.0
    }

    // A simple annotation type.
    @interface MyAnno {
    	String str();
    	int val();
    }

    // Annotate a method
    @MyAnno(str="Annotation Example", val=100)
    public static void myMeth() {
    	System.out.println("this is a test");
    }

    public static void main(String[] args) {
        enumDemo();
        enumDemo2();
        enumDemo3();
        enumDemo4();
        autoBox();
        AutoBox.run();
        autoBox3();
        quadratic();
        staticQuadratic();
        myMeth();
    }
}