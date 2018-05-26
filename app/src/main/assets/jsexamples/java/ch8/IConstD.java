// An interface that contains constants.
interface IConst {
	int MIN = 0;
	int MAX = 10;
	String ERRORMSG = "Boundary Error";
}

// One interface can extend another. (p 291)
interface A {
	void meth1();
	void meth2();
}

interface B extends A {
	void meth3();
}

class MyClass implements B {
	public void meth1() {
		System.out.println("Implement meth1().");
	}
	public void meth2() {
		System.out.println("Implement meth2().");
	}
	public void meth3() {
		System.out.println("Implement meth3().");
	}
}

interface MyIF {
	int getUserID();

	default int getAdminID() {
		return 1;
	}

	static int getUniversalID() {
		return 0;
	}
}

class MyIFImp implements MyIF {
	public int getUserID() {
		return 100;
	}
}

class MyIFImp2 implements MyIF {
	public int getUserID() {
		return 100;
	}
	public int getAdminID() {
		return 42;
	}
}

class IConstD implements IConst {
	public static void example1() {
		int nums[] = new int[MAX];

		for (int i=MIN; i<11; i++) {
			if (i >=MAX) System.out.println(ERRORMSG);
			else {
				nums[i] = i;
				System.out.print(nums[i] + " ");
			}
		}
		System.out.println();
		// 0 1 2 3 4 5 6 7 8 9 Boundary Error
	}

	public static void ifExtend() { // (p 292)
		MyClass ob = new MyClass();
		ob.meth1();
		ob.meth2();
		ob.meth3();
		// Implement meth1().
		// Implement meth2().
		// Implement meth3().
	}

	public static void defaultMethodDemo() { // (p 294)
		MyIFImp obj = new MyIFImp();
		System.out.println("User ID is " + obj.getUserID());
		System.out.println("Administrator ID is " + obj.getAdminID());
		// User ID is 100
		// Administrator ID is 1
	}

	public static void defaultMethodDemo2() {
		MyIFImp2 obj = new MyIFImp2();
		System.out.println("User ID is " + obj.getUserID());
		System.out.println("Administrator ID is " + obj.getAdminID());
		// User ID is 100
		// Administrator ID is 42
	}

	public static void main(String[] args) {
		example1();
		ifExtend();
		defaultMethodDemo();
		defaultMethodDemo2();
		int uID = MyIF.getUniversalID();
		System.out.println("MyIF.getUniversalID() = "+uID);
		// MyIF.getUniversalID() = 0
	}
}