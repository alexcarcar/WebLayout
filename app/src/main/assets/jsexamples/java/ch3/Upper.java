class Upper {
	public static void main(String[] args) throws java.io.IOException {
		int caseChanges = 0;
		String convertedSentence = "";
		char ch;

		System.out.println("Enter a sentence ending in a period:");
		while ( (ch=(char)System.in.read()) != '.') {
			if(ch>='a' && ch<='z') {
				ch = (char) ((int)ch - 32);
				caseChanges++;
			}
			convertedSentence += ch;
		}
		convertedSentence += '.';
		System.out.println(convertedSentence);
		System.out.println(caseChanges + " letters were converted to uppercase.");
	}
}

// Enter a sentence ending in a period:
// This is a test.
// THIS IS A TEST.
// 10 letters were converted to uppercase.