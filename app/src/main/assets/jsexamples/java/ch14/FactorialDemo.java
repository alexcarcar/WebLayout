class FactorialDemo {
	interface NumericFunc {
		int func(int n);
	}

	public static void main(String[] args) {
		NumericFunc factorial = (n) -> {
			if (n <= 1) return 1;
			int answer = 1;
			for (int i=2; i<=n; i++) {
			 	answer *= i;
			} 
			return answer;
		};

		System.out.println(factorial.func(3)); // 3! = 3*2*1 = 6 
		System.out.println(factorial.func(0)); // 0! = 1
		System.out.println(factorial.func(5)); // 5! = 5*4*3*2*1 = 20*6 = 120
	}
	
	// 6
	// 1
	// 120
}