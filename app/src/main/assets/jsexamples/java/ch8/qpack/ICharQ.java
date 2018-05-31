package qpack;

// A character queue interface.
public interface ICharQ {
	void put(char ch); // Put a character into the queue.
	char get(); // Get a character from the queue.
}