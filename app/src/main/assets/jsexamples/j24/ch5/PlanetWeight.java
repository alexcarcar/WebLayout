class PlanetWeight {
	public static void main(String[] args) {
		System.out.print("Your weight on Earth is ");
		double weight = 195;
		System.out.println(weight);

		System.out.print("Your weight on Mercury is ");
		double mercury = weight * .378;
		System.out.println(mercury);

		System.out.print("Your weight on Moon is ");
		double moon = weight * .166;
		System.out.println(moon);

		System.out.print("Your weight on Jupiter is ");
		double jupiter = weight * 2.364;
		System.out.println(jupiter);

		// Your weight on Earth is 195.0
		// Your weight on Mercury is 73.71
		// Your weight on Moon is 32.370000000000005
		// Your weight on Jupiter is 460.97999999999996

		System.out.print("Your weight on Venus is ");
		double venus = weight * .907;
		System.out.println(venus);

		System.out.print("Your weight on Uranus is ");
		double uranus = weight * .889;
		System.out.println(uranus);

		// Your weight on Venus is 176.865
		// Your weight on Uranus is 173.355
	}
}