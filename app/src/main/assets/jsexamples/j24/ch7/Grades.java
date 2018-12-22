class Grades {
	public static void main(String[] args) {
		int grade = 67;
		System.out.println(gradeWithIf(grade));
		System.out.println(gradeWithSwitch(grade));

		grade = 87;
		System.out.println(gradeWithIf(grade));
		System.out.println(gradeWithSwitch(grade));

		grade = 93;
		System.out.println(gradeWithIf(grade));
		System.out.println(gradeWithSwitch(grade));
		// Grade: 67 D
		// Grade: 67 D
		// Grade: 87 B
		// Grade: 87 B
		// Grade: 93 A
		// Grade: 93 A
	}


	static void printGradeNumber(int grade) {
		System.out.print("Grade: "+ grade + " ");
	}

	static String gradeWithIf(int grade) {
		printGradeNumber(grade);
		if (grade>89) return "A";
		if (grade>79) return "B";
		if (grade>69) return "C";
		if (grade>59) return "D";
		return "F";
	}

	static String gradeWithSwitch(int grade) {
		printGradeNumber(grade);
		switch(grade) {
			case 100:case 99:case 98:case 97:case 96:case 95:case 94:case 93:case 92:case 91:case 90: return "A";
			case 89:case 88:case 87:case 86:case 85:case 84:case 83:case 82:case 81:case 80: return "B";
			case 79:case 78:case 77:case 76:case 75:case 74:case 73:case 72:case 71:case 70: return "C";
			case 69:case 68:case 67:case 66:case 65:case 64:case 63:case 62:case 61:case 60: return "D";
			default:return "F";
		}

	}
}