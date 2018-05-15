// Public vs private access. (p 183)
class MyClass {
    private int alpha; // private access
    public int beta; // public access
    int gamma; // default access

    /* Methods to access alpha.  It is OK for a member of a class
     to access a private member of the same class. */
    void setAlpha(int a) {
        alpha = a;
    }

    int getAlpha() {
        return alpha;
    }
}

// This class implements a "fail-soft" array which prevents runtime errors
class FailSoftArray {
    private int a[]; // reference array
    private int errval; // value to return if get() fails
    public int length; // length is public

    // Construct array given its size and the value to return if get() fails
    public FailSoftArray(int size, int errv) {
        a = new int[size];
        errval = errv;
        length = size;
    }

    // Return value given index
    public int get(int index) {
        if (indexOK(index)) return a[index];
        return errval;
    }

    // Put a value at an index. Return false on failure.
    public boolean put(int index, int val) {
        if (indexOK(index)) {
            a[index] = val;
            return true;
        }
        return false;
    }

    private boolean indexOK(int index) {
        if (index >= 0 & index < length) return true;
        return false;
    }
}

// Objects can be passed to methods. (p 188)
class Block {
    int a, b, c;
    int volume;

    Block(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
        volume = a * b * c;
    }

    boolean sameBlock(Block ob) {
        if ((ob.a == a) & (ob.b == b) & (ob.c == c)) return true;
        return false;
    }

    boolean sameVolume(Block ob) {
        if (ob.volume == volume) return true;
        return false;
    }
}

// Primitive types are passed by value. (p 190)
class Test1 {
    void noChange(int i, int j) {
        i = i + j;
        j = -j;
    }
}

// Objects are pass through their references. (p 191)
class Test2 {
    int a, b;

    Test2(int i, int j) {
        a = i;
        b = j;
    }

    // Pass an object. Now, ob.a and ob.b in object used in call will be changed
    void change(Test2 ob) {
        ob.a = ob.a + ob.b;
        ob.b = -ob.b;
    }
}

// Return a String object. (p 192)
class ErrorMsg {
    String msgs[] = {"Output Error", "Input Error", "Disk Full", "Index Out-Of-Bounds"};

    String getErrorMsg(int i) {
        if (i >= 0 & i < msgs.length) return msgs[i];
        return "Invalid Error Code";
    }
}

// Return a programmer-defined object. (p 193)
class Err {
    String msg; // error message
    int severity; // code indicating severity of error

    Err(String m, int s) {
        msg = m;
        severity = s;
    }
}

class ErrorInfo {
    String msgs[] = {"Output Error", "Input Error", "Disk Full", "Index Out-Of-Bounds"};
    int howbad[] = {3, 3, 2, 4};

    Err getErrorInfo(int i) {
        if (i >= 0 & i < msgs.length) return new Err(msgs[i], howbad[i]);
        return new Err("Invalid Error Code", 0);
    }
}

// Demonstrate method overloading. (p 194)
class OverLoad {
    void ovlDemo() {
        System.out.println("No parameters");
    }

    void ovlDemo(int a) {
        System.out.println("One parameter: " + a);
    }

    int ovlDemo(int a, int b) {
        System.out.println("Two parameters: " + a + " " + b);
        return a + b;
    }

    double ovlDemo(double a, double b) {
        System.out.println("Two double parameters: " + a + " " + b);
        return a + b;
    }
}

class OverLoad2 {
	void f(byte x) {
		System.out.println("Inside f(byte): "+x);
	}

	void f(int x) {
		System.out.println("Inside f(int): "+x);
	}

	void f(double x) {
		System.out.println("Inside f(double): "+x);
	}
}

// Demonstrate an overloaded constructor. (p 199)
class MyClass2 {
	int x;

	MyClass2() {
		System.out.println("Inside MyClass2().");
		x = 0;
	}

	MyClass2(int i) {
		System.out.println("Inside MyClass2(int).");
		x = i;
	}

	MyClass2(double d) {
		System.out.println("Inside MyClass2(double).");
		x = (int) d;
	}

	MyClass2(int i, int j) {
		System.out.println("Inside MyClass2(int, int).");
		x = i * j;
	}
}

// Initialize one object with another.
class Summmation {
	int sum;

	// Construct it from an int.
	Summmation(int num) {
		sum = 0;
		for (int i=1; i<=num; i++) sum += i;
	}

	// Construct from another object.
	Summmation(Summmation ob) {
		sum = ob.sum;
	}
}

// A simple example of recursion. (p 204)
class Factorial {
	// This is a recursive function.
	int factR(int n) {
		int result;
		if (n==1) return 1;
		result = factR(n-1)*n;
		return result;
	}

	// This is an iterative equivalent.
	int factI(int n) {
		int t, result;
		result = 1;
		for (t=1; t<=n; t++) {
			result *= t;
		}
		return result;
	}
}

// Use a static variable. (p 207)
class StaticDemo {
	int x; // a normal instance variable
	static int y; // a static variable (there is only one copy for all objects)
	int sum() {
		return x+y;
	}
}

// Use a static method. (p 208)
class StaticMeth {
	static int val = 1024; // a static variable

	// a static method
	static int valDiv2() {
		return val/2;
	}

	/*
	int denom = 3;
	static int valDivDenom() {
		return val/denom; // won't compile
	} */
	// Example.java:247: error: non-static variable denom cannot be referenced
	// from a static context
    //            return val/denom; // won't compile
    //                       ^
}

// Use a static block. (p 209)
class StaticBlock {
	static double rootOf2;
	static double rootOf3;

	static { // This block is executed when the class is loaded.
		System.out.println("Inside static block.");
		rootOf2 = Math.sqrt(2.0);
		rootOf3 = Math.sqrt(3.0);
	}

	StaticBlock(String msg) {
		System.out.println(msg);
	}
	// Inside static block.
	// Inside Constructor
	// Square root of 2 is 1.4142135623730951
	// Square root of 3 is 1.7320508075688772
}

// Use an inner class. (p 213)
class Outer {
	int nums[];
	Outer(int n[]) {
		nums = n;
	}

	void analyze() {
		Inner inOb = new Inner();
		System.out.println("Minimum: " + inOb.min());
		System.out.println("Maximum: " + inOb.max());
		System.out.println("Average: " + inOb.avg());
	}

	// This is an inner class.
	class Inner {
		int min() {
			int m = nums[0];
			for (int i=1; i<nums.length; i++) if (nums[i]<m) m = nums[i];
			return m;
		}
		int max() {
			int m = nums[0];
			for (int i=1; i<nums.length; i++) if (nums[i]>m) m = nums[i];
			return m;
		}
		double avg() {
			double a = 0;
			for (int i=0; i<nums.length; i++) a += nums[i];
			return a/nums.length;
		}
	}
}

// Demonstrate variable-length arguments. (p 217)
class VarArgs {
	// vaTest() uses a vararg.
	static void vaTest(int ... v) {
		System.out.println("Number of args: " + v.length);
		System.out.println("Contents: ");
		for (int i=0; i<v.length; i++) {
			System.out.println(" arg "+i+": "+v[i]);
		}
	}
}

class Example {
    static void accessDemo() {
        MyClass ob = new MyClass();
        ob.setAlpha(-99);
        System.out.println("ob.alpha is " + ob.getAlpha()); // ob.alpha is -99
        // ob.alpha = 10 // Wrong! alpha is private!
        ob.beta = 88; // Okay because it is public
        ob.gamma = 99; // Okay because default is also public
        System.out.println(ob.beta + " " + ob.gamma); // 88 99
    }

    static void fsDemo() {
        FailSoftArray fs = new FailSoftArray(5, -1);
        int x;

        System.out.println("Fail quietly.");
        for (int i = 0; i < (fs.length * 2); i++) {
            fs.put(i, i * 10);
        }
        for (int i = 0; i < (fs.length * 2); i++) {
            x = fs.get(i);
            if (x != -1) System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("\nFail with error reports.");
        for (int i = 0; i < (fs.length * 2); i++) {
            if (!fs.put(i, i * 10)) System.out.println(i + " out of bounds");
        }
        for (int i = 0; i < (fs.length * 2); i++) {
            x = fs.get(i);
            if (x != -1) System.out.print(x + " ");
            else System.out.println(i + " out of bounds");
        }
        System.out.println();
        // Fail quietly.
        // 0 10 20 30 40

        // Fail with error reports.
        // 5 out of bounds
        // 6 out of bounds
        // 7 out of bounds
        // 8 out of bounds
        // 9 out of bounds
        // 0 10 20 30 40 5 out of bounds
        // 9 out of bounds
        // 6 out of bounds
        // 7 out of bounds
        // 8 out of bounds
    }

    static void passOb() {
        Block ob1 = new Block(10, 2, 5);
        Block ob2 = new Block(10, 2, 5);
        Block ob3 = new Block(4, 5, 5);
        System.out.println("ob1 same dimensions of ob2: " + ob1.sameBlock(ob2));
        System.out.println("ob1 same dimensions of ob3: " + ob1.sameBlock(ob3));
        System.out.println("ob1 same volume of ob3: " + ob1.sameVolume(ob3));
        // ob1 same dimensions of ob2: true
        // ob1 same dimensions of ob3: false
        // ob1 same volume of ob3: true
    }

    static void callByValue() {
        Test1 ob = new Test1();
        int a = 15, b = 20;
        System.out.println("a and b before call: " + a + " " + b);
        ob.noChange(a, b);
        System.out.println("a and b after call: " + a + " " + b);
        // a and b before call: 15 20
        // a and b after call: 15 20
    }

    static void passObRef() {
        Test2 ob = new Test2(15, 20);
        System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);
        ob.change(ob);
        System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
        // ob.a and ob.b before call: 15 20
        // ob.a and ob.b after call: 35 -20
    }

    static void errMsg() {
        ErrorMsg err = new ErrorMsg();
        System.out.println(err.getErrorMsg(2));
        System.out.println(err.getErrorMsg(19));
        // Disk Full
        // Invalid Error Code
    }

    static void errInfo() {
        ErrorInfo err = new ErrorInfo();
        Err e;
        e = err.getErrorInfo(2);
        System.out.println(e.msg + " severity: " + e.severity);
        e = err.getErrorInfo(19);
        System.out.println(e.msg + " severity: " + e.severity);
        // Disk Full severity: 2
        // Invalid Error Code severity: 0
    }

    static void overLoadDemo() {
    	OverLoad ob = new OverLoad();
    	int resI;
    	double resD;

    	// call all versions of ovlDemo()
    	ob.ovlDemo();
    	System.out.println();

    	ob.ovlDemo(2);
    	System.out.println();

    	resI = ob.ovlDemo(4, 6);
    	System.out.println("Result of ob.ovlDemo(4, 6): "+resI);
    	System.out.println();

    	resD = ob.ovlDemo(1.1, 2.32);
    	System.out.println("Result of ob.ovlDemo(1.1, 2.32): "+resD);
		// No parameters

		// One parameter: 2

		// Two parameters: 4 6
		// Result of ob.ovlDemo(4, 6): 10

		// Two double parameters: 1.1 2.32
		// Result of ob.ovlDemo(1.1, 2.32): 3.42
    }

    static void typeConv() {
    	OverLoad2 ob = new OverLoad2();
    	int i = 10;
    	double d = 10.1;

    	byte b = 99;
    	short s = 10;
    	float f = 11.5F;
    	ob.f(i);
    	ob.f(d);
    	ob.f(b);
    	ob.f(s);
    	ob.f(f);
		// Inside f(int): 10
		// Inside f(double): 10.1
		// Inside f(byte): 99
		// Inside f(int): 10 // type conversion: short to int
		// Inside f(double): 11.5 // type conversion: float to double
    }

    static void overloadConsDemo() {
    	MyClass2 t1 = new MyClass2();
    	MyClass2 t2 = new MyClass2(88);
    	MyClass2 t3 = new MyClass2(17.23);
    	MyClass2 t4 = new MyClass2(2, 4);

    	System.out.println("t1.x: " + t1.x);
    	System.out.println("t2.x: " + t2.x);
    	System.out.println("t3.x: " + t3.x);
    	System.out.println("t4.x: " + t4.x);

		// Inside MyClass2().
		// Inside MyClass2(int).
		// Inside MyClass2(double).
		// Inside MyClass2(int, int).
		// t1.x: 0
		// t2.x: 88
		// t3.x: 17
		// t4.x: 8
    }

    static void sumDemo() {
    	Summmation s1 = new Summmation(5);
    	Summmation s2 = new Summmation(s1);
    	System.out.println("s1.sum: "+s1.sum);
    	System.out.println("s2.sum: "+s2.sum);
    	// s1.sum: 15
		// s2.sum: 15
    }

    static void recursion() {
    	Factorial f = new Factorial();

    	System.out.println("Factorials using recursive method.");
    	System.out.println("3! = " + f.factR(3));
    	System.out.println("4! = " + f.factR(4));
    	System.out.println("5! = " + f.factR(5));
    	System.out.println("Factorials using iterative method.");
    	System.out.println("3! = " + f.factI(3));
    	System.out.println("4! = " + f.factI(4));
    	System.out.println("5! = " + f.factI(5));
		// Factorials using recursive method.
		// 3! = 6
		// 4! = 24
		// 5! = 120
		// Factorials using iterative method.
		// 3! = 6
		// 4! = 24
		// 5! = 120
    }

    static void sDemo() {
    	StaticDemo ob1 = new StaticDemo();
    	StaticDemo ob2 = new StaticDemo();

    	// Each object has its own copy of an instance variable.
    	ob1.x = 10;
    	ob2.x = 20;
    	System.out.println("ob1.x: "+ob1.x); // 10
    	System.out.println("ob2.x: "+ob2.x); // 20
    	StaticDemo.y = 19;
    	System.out.println("ob1.sum(): "+ob1.sum()); // 29
    	System.out.println("ob2.sum(): "+ob2.sum()); // 39
    	StaticDemo.y = 100;
    	System.out.println("ob1.sum(): "+ob1.sum()); // 110
    	System.out.println("ob2.sum(): "+ob2.sum()); // 120
		// ob1.x: 10
		// ob2.x: 20
		// ob1.sum(): 29
		// ob2.sum(): 39
		// ob1.sum(): 110
		// ob2.sum(): 120
    }

    static void sDemo2() {
    	System.out.println("val is "+StaticMeth.val); // 1024
    	System.out.println("StaticMeth.valDiv2() is "+StaticMeth.valDiv2()); // 512
    	StaticMeth.val = 4;
    	System.out.println("val is "+StaticMeth.val); // 4
    	System.out.println("StaticMeth.valDiv2() is "+StaticMeth.valDiv2()); // 2
		// val is 1024
		// StaticMeth.valDiv2() is 512
		// val is 4
		// StaticMeth.valDiv2() is 2
    }

    static void sDemo3() {
    	StaticBlock ob = new StaticBlock("Inside Constructor");
    	System.out.println("Square root of 2 is "+StaticBlock.rootOf2);
    	System.out.println("Square root of 3 is "+StaticBlock.rootOf3);
    }

    static void nestedClassDemo() {
    	int x[] = {3,2,1,5,6,9,7,8};
    	Outer outOb = new Outer(x);
    	outOb.analyze();
		// Minimum: 1
		// Maximum: 9
		// Average: 5.125
    }

    public static void main(String[] args) {
        accessDemo();
        fsDemo();
        passOb();
        callByValue();
        passObRef();
        errMsg();
        errInfo();
        overLoadDemo();
        typeConv();
        overloadConsDemo();
        sumDemo();
        recursion();
        sDemo();
        sDemo2();
        sDemo3();
        nestedClassDemo();

        // An inner class version of ShowBits.
        class ShowBits {
        	int numbits;
        	ShowBits(int n) {
        		numbits = n;
        	}
        	void show(long val) {
        		long mask = 1;
        		mask <<= numbits-1;
        		int spacer = 0;
        		for(;mask!=0;mask>>>=1) {
        			if((val&mask)!=0) System.out.print("1");
        			else System.out.print("0");
        			spacer++;
        			if((spacer%8)==0) {
        				System.out.print(" ");
        				spacer = 0;
        			}
        		}
        		System.out.println();
        	}
        }
        for(byte b=0; b<10; b++) {
        	ShowBits byteval = new ShowBits(8);
        	System.out.print(b + " in binary: ");
        	byteval.show(b);
        }
        // 0 in binary: 00000000 
		// 1 in binary: 00000001 
		// 2 in binary: 00000010 
		// 3 in binary: 00000011 
		// 4 in binary: 00000100 
		// 5 in binary: 00000101 
		// 6 in binary: 00000110 
		// 7 in binary: 00000111 
		// 8 in binary: 00001000 
		// 9 in binary: 00001001 

        VarArgs.vaTest(10);
		// Number of args: 1
		// Contents:
		//  arg 0: 10
        VarArgs.vaTest(1,2,3);
		// Number of args: 3
		// Contents:
		//  arg 0: 1
		//  arg 1: 2
		//  arg 2: 3
        VarArgs.vaTest();
		// Number of args: 0
		// Contents:
    }
}