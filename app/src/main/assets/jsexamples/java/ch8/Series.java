public interface Series {
	int getNext(); // return next number in series
	void reset(); // restart
	void setStart(int x); // set starting value

	default int[] getNextArray(int n) {
		return getArray(n);
	}

	default int[] skipAndGetNextArray(int skip, int n) {
		getArray(skip);
		return getArray(n);
	}

	// In JDK 9, this can be private instead of "default"
	default int[] getArray(int n) {
		int[] vals = new int[n];
		for (int i=0; i<n; i++) {
			vals[i] = getNext();
		}
		return vals;
	}

}
