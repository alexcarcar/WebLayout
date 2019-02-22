import java.util.Random;

public class RandomPassword {

	static final String AB1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String AB2 = "0123456789";
	static final String AB3 = "_!#$.";

	static Random rnd = new Random();

	private static String randomString() {
		StringBuilder sb = new StringBuilder(14);
		for (int i = 0; i < 3; i++)
			sb.append(AB1.charAt(rnd.nextInt(AB1.length())));
		sb.append(AB2.charAt(rnd.nextInt(AB2.length())));
		sb.append(AB3.charAt(rnd.nextInt(AB3.length())));
		for (int i = 0; i < 3; i++)
			sb.append(AB1.charAt(rnd.nextInt(AB1.length())));
		sb.append(AB2.charAt(rnd.nextInt(AB2.length())));
		sb.append(AB3.charAt(rnd.nextInt(AB3.length())));
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(randomString());
	}
}