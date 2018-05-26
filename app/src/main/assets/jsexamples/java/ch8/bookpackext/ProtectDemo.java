// Demonstrate protected.
package bookpackext;

import bookpack.Book;

class ExtBook extends bookpack.Book {
	private String publisher;

	public ExtBook(String t, String a, int d, String p) {
		super(t, a, d);
		publisher = p;
	}

	public void show() {
		super.show();
		System.out.println(publisher);
		System.out.println();
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String p) {
		publisher = p;
	}

	// These are OK because subclass can access a protected member.
	public String getTitle() { return title; }
	public void setTitle(String t) { title = t; }
	public String getAuthor() { return author; }
	public void setAuthor(String a) { author = a; }
	public int getPubDate() { return pubDate; }
	public void setPubDate(int d) { pubDate = d; }
}

class ProtectDemo {
	public static void main(String[] args) {
		ExtBook books[] = new ExtBook[5];

		books[0] = new ExtBook("Java: A Beginner's Guide", "Schildt", 2018, "Oracle Press");
		books[1] = new ExtBook("Java: The Complete Reference", "Schildt", 2018, "Oracle Press");
		books[2] = new ExtBook("Introducing JavaFX 8 Programming", "Schildt", 2015, "Oracle Press");
		books[3] = new ExtBook("Red Storm Rising", "Clancy", 1986, "Putnam");
		books[4] = new ExtBook("On the Road", "Kerouac", 1955, "Viking");

		for (int i=0; i<books.length; i++) {
			books[i].show();
		}
	}
}

// Java: A Beginner's Guide
// Schildt
// 2018

// Oracle Press

// Java: The Complete Reference
// Schildt
// 2018

// Oracle Press

// Introducing JavaFX 8 Programming
// Schildt
// 2015

// Oracle Press

// Red Storm Rising
// Clancy
// 1986

// Putnam

// On the Road
// Kerouac
// 1955

// Viking

