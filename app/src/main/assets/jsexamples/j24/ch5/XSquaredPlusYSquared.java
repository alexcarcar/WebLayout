class XSquaredPlusYSquared {
	static boolean perfectSquare(long x) {
		long sqrt = Math.round(Math.sqrt(x));
		return x == sqrt * sqrt;
	}

	public static void main(String[] args) {
		int x, y;
		for (x=2; x<=20; x++) {
			for (y=x; y<=20; y++) {
				int x2PlusY2 = x*x + y*y;
				if (perfectSquare(x2PlusY2)) {
					System.out.print(x + "\t" + y + "\t" + x2PlusY2);
					System.out.println("("+Math.sqrt(x2PlusY2)+") *");
				}
			}
		}
	}
	// 3	4	25(5.0) *
	// 5	12	169(13.0) *
	// 6	8	100(10.0) *
	// 8	15	289(17.0) *
	// 9	12	225(15.0) *
	// 12	16	400(20.0) *
	// 15	20	625(25.0) *
}