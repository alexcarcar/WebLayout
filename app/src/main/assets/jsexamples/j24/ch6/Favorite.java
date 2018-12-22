class Favorite {
	public static void main(String[] args) {
		// Comparing Two Strings
		String favorite = "chainsaw";
		String guess = "pool cue";
		System.out.println("Is Fin's favorite weapon a " + guess + "?");
		System.out.println("Answer: " + favorite.equals(guess));

		guess = "chainsaw";
		System.out.println("Is Fin's favorite weapon a " + guess + "?");
		System.out.println("Answer: " + favorite.equals(guess));

		// Is Fin's favorite weapon a pool cue?
		// Answer: false
		// Is Fin's favorite weapon a chainsaw?
		// Answer: true

	}
}