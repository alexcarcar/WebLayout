class Backwards {

	// Recursive method to print a string "s" backwards
	static void backwards(String s) {
		int n = s.length();
		if (s == null || n==0) return;
		System.out.print(s.charAt(n-1));
		backwards(s.substring(0, n-1));
	}

	public static void main(String[] args) {
		String s = "This is a test";
		backwards(s);
	}
	// tset a si sihT
}