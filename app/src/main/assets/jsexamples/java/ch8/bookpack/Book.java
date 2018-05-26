// A short package demonstration. (p 270)

// Book recoded for public access. (p 273)
package bookpack;

// Book and its members must be public in order to be used by other packages. (p 273)
public class Book {
	protected String title;
	protected String author;
	protected int pubDate;

	public Book(String t, String a, int d) {
		title = t;
		author = a;
		pubDate = d;
	}

	public void show() {
		System.out.println(title);
		System.out.println(author);
		System.out.println(pubDate);
		System.out.println();
	}
}
