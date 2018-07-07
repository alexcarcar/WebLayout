interface MyIntPredicate2 {
	boolean test(int n);
}

class MyIntNum2 {

	private int v;
	MyIntNum2(int x) {
		v = x;
	}

	int getNum() {
		return v;
	}

	boolean isFactor(int n) {
		return (v%n) == 0;
	}

	boolean hasCommonFactor(int n) {
		for (int i=2; i<=n && i<=v; i++) {
			if (n%i==0 && v%i==0) return true;
		}
		return false;
	}
}

class MethodRefDemo {
	public static void main(String[] args) {
		boolean result;
		MyIntNum2 myNum = new MyIntNum2(12);
		MyIntNum2 myNum2 = new MyIntNum2(16);
		MyIntPredicate2 ip = myNum::isFactor;
		result = ip.test(3);
		if (result) System.out.println("3 is a factor of " + myNum.getNum());

		ip = myNum2::isFactor;
		result = ip.test(3);
		if (!result) System.out.println("3 is not a factor of " + myNum2.getNum());

		ip = myNum::hasCommonFactor;
		result = ip.test(9);
		if (result) System.out.println("9 has a common factor with " + myNum.getNum());

		ip = myNum2::hasCommonFactor;
		result = ip.test(9);
		if (!result) System.out.println("9 does not have a common factor with " + myNum2.getNum());
	}
}

// 3 is a factor of 12
// 3 is not a factor of 16
// 9 has a common factor with 12
// 9 does not have a common factor with 16
