class CountSpaces {
	public static void main(String[] args) throws java.io.IOException {
		char ch;
		int spaces = 0;

		System.out.println("Enter a sentence ending with a period:");
		while ((ch=(char) System.in.read())!='.') 
			if (ch==' ') spaces++;
		System.out.println("There were "+spaces+" spaces entered.");
	}
}

// Enter a sentence ending with a period:
// Hello this is a test.
// There were 4 spaces entered.