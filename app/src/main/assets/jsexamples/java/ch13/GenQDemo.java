// A generic queue interface.
interface IGenQ<T> {
	void put(T ch) throws QueueFullException;
	T get() throws QueueEmptyException;
}

class QueueFullException extends Exception {
	int size;

	QueueFullException(int s) {
		size = s;
	}

	public String toString() {
		return "\nQueue is full. Maximum size is " + size;
	}
}

class QueueEmptyException extends Exception {
	public String toString() {
		return  "\nQueue is empty.";
	}
}

// A generic, fixed-size queue class.
class GenQueue<T> implements IGenQ<T> {
	private T q[];
	private int putloc, getloc;

	public GenQueue(T[] aRef) {
		q = aRef;
		putloc = getloc = 0;
	}

	public void put(T obj) throws QueueFullException {
		if (putloc == q.length) {
			throw new QueueFullException(q.length);
		}
		q[putloc++] = obj;
	}

	public T get() throws QueueEmptyException {
		if (getloc == putloc) {
			throw new QueueEmptyException();
		}
		return q[getloc++];
	}
}


class GenQDemo {
	public static void main(String[] args) {
		Integer iStore[] = new Integer[10];
		GenQueue<Integer> q = new GenQueue<>(iStore);
		Integer iVal;
		System.out.println("Demonstrate a queue of Integers.");
		try {
			for (int i=0; i<5; i++) {
				System.out.println("Adding " + i + " to q.");
				q.put(i);
			}
		} catch(QueueFullException e) {
			System.out.println(e);
		}
		System.out.println();

		try {
			for (int i=0; i<5; i++) {
				System.out.print("Getting next Integer from q: ");
				iVal = q.get();
				System.out.println(iVal);
			}
		} catch (QueueEmptyException e) {
			System.out.println(e);
		}
		System.out.println();

		// Create a Double queue.
		Double dStore[] = new Double[10];
		GenQueue<Double> q2 = new GenQueue<Double>(dStore);
		Double dVal;
		System.out.println("Demonstrate a queue of Doubles.");
		try {
			for (int i=0; i<5; i++) {
				System.out.println("Adding " + (double)i/2 + " to q2.");
				q2.put((double)i/2); // add double value to q2
			}
		} catch (QueueFullException e) {
			System.out.println(e);
		}
		System.out.println();

		try {
			for (int i=0; i<5; i++) {
				System.out.print("Getting next Double from q2: ");
				dVal = q2.get();
				System.out.println(dVal);
			}
		} catch (QueueEmptyException e) {
			System.out.println(e);
		}
	}	
}

// Demonstrate a queue of Integers.
// Adding 0 to q.
// Adding 1 to q.
// Adding 2 to q.
// Adding 3 to q.
// Adding 4 to q.

// Getting next Integer from q: 0
// Getting next Integer from q: 1
// Getting next Integer from q: 2
// Getting next Integer from q: 3
// Getting next Integer from q: 4

// Demonstrate a queue of Doubles.
// Adding 0.0 to q2.
// Adding 0.5 to q2.
// Adding 1.0 to q2.
// Adding 1.5 to q2.
// Adding 2.0 to q2.

// Getting next Double from q2: 0.0
// Getting next Double from q2: 0.5
// Getting next Double from q2: 1.0
// Getting next Double from q2: 1.5
// Getting next Double from q2: 2.0