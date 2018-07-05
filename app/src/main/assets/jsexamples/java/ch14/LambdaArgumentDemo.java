interface StringFunc {
	String func(String str);
}

class LambdaArgumentDemo {
	// This method has a functional interface as the type of its first parameter.  Thus, it can be passed
	// a reference to any instance of that interface, including an instance created by a lambda expression.
	// The second parameter specifies the string to operate on.
	static String changeStr(StringFunc sf, String s) {
		return sf.func(s);
	}

	public static void main(String[] args) {
		String inStr = "Lambda Expressions Expand Java";
		String outStr;
		System.out.println("Here  is input string: " + inStr);
		// Here  is input string: Lambda Expressions Expand Java

		// Define a lambda expression that reverses the contents of a string
		// and assign it to a StringFunc reference variable.
		StringFunc reverse = (str) -> {
			String result = "";
			for (int i=str.length()-1; i>=0; i--) {
				result += str.charAt(i);
			}
			return result;
		};

		outStr = changeStr(reverse, inStr);
		System.out.println("The string reversed: " + outStr);
		// The string reversed: avaJ dnapxE snoisserpxE adbmaL

		outStr = changeStr((str)->str.replace(' ', '-'), inStr);
		System.out.println("The string with spaces replaced: " + outStr);
		// The string with spaces replaced: Lambda-Expressions-Expand-Java

		// Block lambda that inverts the case of characters
		outStr = changeStr((str)->{
			String result = "";
			char ch;
			for (int i=0; i<str.length(); i++) {
				ch = str.charAt(i);
				if (Character.isUpperCase(ch)) {
					result += Character.toLowerCase(ch);
				} else {
					result += Character.toUpperCase(ch);
				}
			}
			return result;
		}, inStr);
		System.out.println("The string in reversed case: " + outStr);
		// The string in reversed case: lAMBDA eXPRESSIONS eXPAND jAVA
	}
}