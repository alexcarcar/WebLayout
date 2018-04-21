class Sound {
	private static final double feetPerSecond = 1100;
	public static void main(String[] args) {
		double dist;
		double seconds = 7.2;
		dist = feetPerSecond*seconds;
		System.out.println("The lightning is "+dist+" feet away.");
		// The lightning is 7920.0 feet away.

		double echoSeconds = 5; // seconds for round trip
		dist = feetPerSecond * echoSeconds/2; // divide by 2 for distance to wall
		System.out.println("The rock wall is "+dist+" feet away.");
		// The rock wall is 2750.0 feet away.
	}	
}