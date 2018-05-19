class SumTest {
	static int sum(int ...values) {
		int sum = 0;
		for (int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("The sum 1+2+3+5 = " + sum(1,2,3,5));
	}
}

// The sum 1+2+3+5 = 11
